package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-19
 */
@Service
public class DataSyncServiceImpl implements DataSyncService {
    private static final Logger logger = LoggerFactory.getLogger(DataSyncServiceImpl.class);
    
    private final MongoTemplate mongoTemplate;
    
    public DataSyncServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    
    /**
     * 数据同步
     *
     * @param documents 入参
     */
    @Override
    public void sync(List<Document> documents) throws BusinessException {
        if (CollectionUtils.isEmpty(documents)) {
            throw BusinessException.of("数据不能为空");
        }
        // todo 数据校验(根据元数据集合)
        
        // 并行保存
        documents.parallelStream().forEach(document -> {
            String label = document.getString("label");
            
            // 原子更新或插入
            // 更新表达式
            Update documentUpdate = Update.fromDocument(document);
            // 查询表达式
            Query query = Query.query(this.createCriteriaByDocument(document));
            mongoTemplate.upsert(query, documentUpdate, label);
        });
    }
    
    /**
     * 构建主键查询条件
     *
     * @param document document大对象
     * @return Criteria
     */
    private Criteria createCriteriaByDocument(Document document) {
        Criteria criteria = new Criteria();
        // 主键key
        List<String> dataPrimaryKeys = document.getList("dataPrimaryKeys", String.class);
        for (String dataPrimaryKey : dataPrimaryKeys) {
            String[] keys = StringUtils.split(dataPrimaryKey, ".");
            Object value = null;
            Document temp = document;
            for (int i = 0; i < keys.length; i++) {
                // 最后一层，得到最终结果
                if (i == keys.length - 1) {
                    value = document.get(keys[i]);
                    // 不是最后一层，继续取
                } else {
                    temp = temp.get(keys[i], Document.class);
                }
            }
            criteria.and(dataPrimaryKey).is(value);
        }
        return criteria;
    }
}
