package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataCollectionQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import com.github.wanggaolei2019.mongodemo.repository.MetadataCollectionRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Service
public class MetadataCollectionServiceImpl implements MetadataCollectionService {
    
    private final MetadataCollectionRepository metadataCollectionRepository;
    
    private final MongoTemplate mongoTemplate;
    
    public MetadataCollectionServiceImpl(MetadataCollectionRepository metadataCollectionRepository, MongoTemplate mongoTemplate) {
        this.metadataCollectionRepository = metadataCollectionRepository;
        this.mongoTemplate = mongoTemplate;
    }
    
    /**
     * 条件分页查询元数据集合
     *
     * @param pageReq 查询参数
     * @return 分页数据结果
     */
    @Override
    public PageResp<MetadataCollection> page(PageReq<MetadataCollectionQuery> pageReq) {
        MetadataCollectionQuery metadataCollectionQuery = pageReq.getParams();
        Criteria criteria = new Criteria();
        if (StringUtils.isNotEmpty(metadataCollectionQuery.getDescribe())) {
            criteria.and("describe").regex("^.*" + metadataCollectionQuery.getDescribe() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataCollectionQuery.getName())) {
            criteria.and("name").regex("^.*" + metadataCollectionQuery.getName() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataCollectionQuery.getStatus())) {
            criteria.and("status").is(metadataCollectionQuery.getStatus());
        }
        if (StringUtils.isNotEmpty(metadataCollectionQuery.getCreateBy())) {
            criteria.and("createBy").regex("^.*" + metadataCollectionQuery.getCreateBy() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataCollectionQuery.getUpdateBy())) {
            criteria.and("updateBy").regex("^.*" + metadataCollectionQuery.getUpdateBy() + ".*$");
        }
        if (null != metadataCollectionQuery.getCreateTimeStart()) {
            criteria.and("createTime").gte(metadataCollectionQuery.getCreateTimeStart());
        }
        if (null != metadataCollectionQuery.getCreateTimeEnd()) {
            criteria.and("createTime").lte(metadataCollectionQuery.getCreateTimeEnd());
        }
        
        Query query = Query.query(criteria);
        query.fields().exclude("moduleList");
        long count = mongoTemplate.count(query, MetadataCollection.class);
        if (count <= 0) {
            return PageResp.ofEmpty(pageReq, MetadataCollection.class);
        }
        List<MetadataCollection> templateList = mongoTemplate.find(query, MetadataCollection.class);
        return PageResp.of(pageReq.getPageNo(), pageReq.getPageSize(), templateList, count);
    }
    
    /**
     * 保存元数据集合
     *
     * @param metadataCollection 源数据集合
     */
    @Override
    public void save(MetadataCollection metadataCollection) {
        if (StringUtils.isEmpty(metadataCollection.get_id())) {
            metadataCollection.setModifiedVersion(null);
        }
        metadataCollectionRepository.save(metadataCollection);
    }
    
    /**
     * findById
     *
     * @param id id
     * @return one
     */
    @Override
    public MetadataCollection findById(String id) throws BusinessException {
        Optional<MetadataCollection> optional = metadataCollectionRepository.findById(id);
        return optional.orElseThrow(BusinessException::notFound);
    }
}
