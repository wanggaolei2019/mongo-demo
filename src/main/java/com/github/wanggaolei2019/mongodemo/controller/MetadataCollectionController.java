package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.common.ApiResp;
import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataCollectionQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataCollection;
import com.github.wanggaolei2019.mongodemo.service.MetadataCollectionService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Api(tags = "2.0:元数据集合")
@ApiSort(20)
@RestController
@RequestMapping("metadata/collection")
public class MetadataCollectionController {
    
    private final MetadataCollectionService metadataCollectionService;
    
    public MetadataCollectionController(MetadataCollectionService metadataCollectionService) {
        this.metadataCollectionService = metadataCollectionService;
    }
    
    @ApiOperation(value = "1:条件分页查询mongoTemplate")
    @ApiOperationSupport(order = 1)
    @PostMapping("page")
    ApiResp<PageResp<MetadataCollection>> page(@RequestBody PageReq<MetadataCollectionQuery> pageReq) {
        return ApiResp.ofSuccess(metadataCollectionService.page(pageReq));
    }
    
    @ApiOperation(value = "2:根据id查询")
    @ApiOperationSupport(order = 2)
    @GetMapping("findById")
    ApiResp<MetadataCollection> findById(@RequestParam("id") String id) throws BusinessException {
        return ApiResp.ofSuccess(metadataCollectionService.findById(id));
    }
    
    @ApiOperation(value = "3:新增或更新")
    @ApiOperationSupport(order = 3)
    @PostMapping("save")
    ApiResp<Object> save(@RequestBody MetadataCollection metadataCollection) {
        metadataCollectionService.save(metadataCollection);
        return ApiResp.ofSuccess("保存成功");
    }
    
}
