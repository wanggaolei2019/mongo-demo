package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataTemplate;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public interface MetadataTemplateService {
    
    /**
     * 条件分页查询元数据模板信息
     *
     * @param pageReq 查询参数
     * @return 分页数据结果
     */
    PageResp<MetadataTemplate> page(PageReq<MetadataQuery> pageReq);
    
    /**
     * 条件分页查询元数据模板信息
     *
     * @param pageReq 查询参数
     * @return 分页数据结果
     */
    PageResp<MetadataTemplate> page2(PageReq<MetadataQuery> pageReq);
    
    /**
     * 保存元数据模板
     *
     * @param metadataTemplate 元数据模板
     */
    void save(MetadataTemplate metadataTemplate);
    
    /**
     * 保存元数据模板
     *
     * @param metadataTemplateList 元数据模板
     */
    void saveAll(List<MetadataTemplate> metadataTemplateList);
    
    /**
     * findById
     * @param id id
     * @return one
     */
    MetadataTemplate findById(String id) throws BusinessException;
    
    /**
     * delete one
     * @param id id
     */
    void deleteById(String id);
    
    /**
     * delete all
     * @param ids ids
     */
    void deleteAll(List<String> ids);
}
