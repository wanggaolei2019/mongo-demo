package com.github.wanggaolei2019.mongodemo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import com.github.wanggaolei2019.mongodemo.repository.MetadataCollectionRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MongoDemoApplicationTests {
    
    @Resource
    MongoTemplate mongoTemplate;
    
    @Resource
    MetadataCollectionRepository metadataCollectionRepository;
    
    @Test
    void contextLoads() {
    
    }
    
    @Test
    void saveTest() {
        // 标准Spring Data 的 Repository用法
        MetadataCollection metadataCollection = new MetadataCollection();
        metadataCollection.setName("保单信息");
        metadataCollection.setDescribe("保单大对象元数据集合");
        metadataCollection.setCreateBy("wanggl");
        metadataCollection.setVersion(1L);
        metadataCollectionRepository.save(metadataCollection);
        System.out.println("保存成功：" + JSONUtil.toJsonPrettyStr(metadataCollection));
    }
    
    @Test
    void saveTest2() {
        // mongoTemplate 与 实体类混用
        MetadataCollection metadataCollection = new MetadataCollection();
        metadataCollection.setName("保单信息");
        metadataCollection.setDescribe("保单大对象元数据集合");
        metadataCollection.setCreateBy("wanggl");
        metadataCollection.setVersion(1L);
        mongoTemplate.save(metadataCollection);
        System.out.println("保存成功：" + JSONUtil.toJsonPrettyStr(metadataCollection));
    }
    
    @Test
    void saveTest3() {
        // mongoTemplate 与 Document
        String str = "{\n" +
                "    \"modifiedVersion\": 0,\n" +
                "    \"version\": 1,\n" +
                "    \"createBy\": \"wanggl\",\n" +
                "    \"name\": \"保单信息\",\n" +
                "    \"describe\": \"保单大对象元数据集合\"\n" +
                "}";
        Document document = Document.parse(str);
        DateTime now = DateUtil.date();
        document.append("createTime", now);
        document.append("updateTime", now);
        
        mongoTemplate.save(document, "metadata_collection");
        System.out.println("保存成功：" + JSONUtil.toJsonPrettyStr(document));
    }
    
    @Test
    void findTest() {
        // 标准Spring Data 的 Repository用法
        Page<MetadataCollection> collectionPage = metadataCollectionRepository.findAll(
                PageRequest.of(0, 5, Sort.by("updateTime").descending())
        );
        if (collectionPage.hasContent()) {
            collectionPage.get().forEach(data -> {
                        data.setDescribe(RandomUtil.randomString(6));
                        metadataCollectionRepository.save(data);
                        System.out.println("更新成功：" + JSONUtil.toJsonPrettyStr(data));
                    }
            );
        }
    }
    
    @Test
    void findTest2() {
        // mongoTemplate 与 实体类混用
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("updateTime").descending());
        List<MetadataCollection> collectionPage = mongoTemplate.find(
                new Query().with(pageRequest), MetadataCollection.class
        );
        if (!collectionPage.isEmpty()) {
            collectionPage.forEach(data -> {
                        data.setDescribe(RandomUtil.randomString(6));
                        mongoTemplate.save(data);
                        System.out.println("更新成功：" + JSONUtil.toJsonPrettyStr(data));
                    }
            );
        }
    }
    
    @Test
    void findTest3() {
        // mongoTemplate 与 Document
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by("updateTime").descending());
        List<Document> collectionPage = mongoTemplate.find(
                new Query().with(pageRequest), Document.class
        );
        if (!collectionPage.isEmpty()) {
            collectionPage.forEach(data -> {
                        Update update = Update.update("describe", RandomUtil.randomString(6));
                        Query query = Query.query(Criteria.where("_id").is(data.getString("_id")));
                        mongoTemplate.updateFirst(query, update, "metadata_collection");
                        
                        Document document = mongoTemplate.findOne(query, Document.class, "metadata_collection");
                        System.out.println("更新成功：" + JSONUtil.toJsonPrettyStr(document));
                    }
            );
        }
    }
    
}
