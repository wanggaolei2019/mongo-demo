package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataCollectionQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public interface MetadataCollectionService {
    /**
     * 条件分页查询元数据集合
     *
     * @param pageReq 查询参数
     * @return 分页数据结果
     */
    PageResp<MetadataCollection> page(PageReq<MetadataCollectionQuery> pageReq);
    
    /**
     * 保存元数据集合
     *
     * @param metadataCollection 源数据集合
     */
    void save(MetadataCollection metadataCollection);
    
    /**
     * findById
     *
     * @param id id
     * @return one
     */
    MetadataCollection findById(String id) throws BusinessException;
}
