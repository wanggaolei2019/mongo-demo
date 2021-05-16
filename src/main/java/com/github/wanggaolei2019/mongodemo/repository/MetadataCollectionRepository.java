package com.github.wanggaolei2019.mongodemo.repository;

import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public interface MetadataCollectionRepository extends MongoRepository<MetadataCollection, String> {
    
    /**
     * 根据名称模糊分页查询
     *
     * @param name     名称
     * @param pageable 分页参数
     * @return 分页查询表结果
     */
    Page<MetadataCollection> findAllByNameLike(String name, Pageable pageable);
}
