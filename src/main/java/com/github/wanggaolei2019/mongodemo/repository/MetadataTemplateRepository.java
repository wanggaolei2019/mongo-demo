package com.github.wanggaolei2019.mongodemo.repository;

import com.github.wanggaolei2019.mongodemo.entity.MetadataTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public interface MetadataTemplateRepository extends MongoRepository<MetadataTemplate, String>
        , QuerydslPredicateExecutor<MetadataTemplate> {
    
}
