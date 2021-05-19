package com.github.wanggaolei2019.mongodemo.repository;

import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public interface MetadataCollectionRepository extends MongoRepository<MetadataCollection, String>
        , QuerydslPredicateExecutor<MetadataCollection> {
    /**
     * 根据code查询
     *
     * @param code code
     * @return Boolean
     */
    Boolean existsByCode(String code);
}
