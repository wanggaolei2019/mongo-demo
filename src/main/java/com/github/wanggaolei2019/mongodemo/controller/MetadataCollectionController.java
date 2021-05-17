package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.common.ApiResp;
import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataCollectionQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import com.github.wanggaolei2019.mongodemo.service.MetadataCollectionService;
import org.springframework.web.bind.annotation.*;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@RestController
@RequestMapping("metadata/collection")
public class MetadataCollectionController {
    
    private final MetadataCollectionService metadataCollectionService;
    
    public MetadataCollectionController(MetadataCollectionService metadataCollectionService) {
        this.metadataCollectionService = metadataCollectionService;
    }
    
    @PostMapping("page")
    ApiResp<PageResp<MetadataCollection>> page(@RequestBody PageReq<MetadataCollectionQuery> pageReq) {
        return ApiResp.ofSuccess(metadataCollectionService.page(pageReq));
    }
    
    @GetMapping("findById")
    ApiResp<MetadataCollection> findById(@RequestParam("id") String id) throws BusinessException {
        return ApiResp.ofSuccess(metadataCollectionService.findById(id));
    }
    
    @PostMapping("save")
    ApiResp<Object> save(@RequestBody MetadataCollection metadataCollection) {
        metadataCollectionService.save(metadataCollection);
        return ApiResp.ofSuccess("保存成功");
    }
    
}
