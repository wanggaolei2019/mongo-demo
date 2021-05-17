package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.common.ApiResp;
import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataTemplate;
import com.github.wanggaolei2019.mongodemo.service.MetadataTemplateService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Api(tags = "1.0:元数据样板")
@ApiSort(10)
@RestController
@RequestMapping("metadata/template")
public class MetaDataTemplateController {
    
    private final MetadataTemplateService metadataTemplateService;
    
    public MetaDataTemplateController(MetadataTemplateService metadataTemplateService) {
        this.metadataTemplateService = metadataTemplateService;
    }
    
    @ApiOperation(value = "1:条件分页查询querydsl")
    @ApiOperationSupport(order = 1)
    @PostMapping("page")
    ApiResp<PageResp<MetadataTemplate>> page(@RequestBody PageReq<MetadataQuery> pageReq) {
        return ApiResp.ofSuccess(metadataTemplateService.page(pageReq));
    }
    
    @ApiOperation(value = "2:条件分页查询mongoTemplate")
    @ApiOperationSupport(order = 2)
    @PostMapping("page2")
    ApiResp<PageResp<MetadataTemplate>> page2(@RequestBody PageReq<MetadataQuery> pageReq) {
        return ApiResp.ofSuccess(metadataTemplateService.page2(pageReq));
    }
    
    @ApiOperation(value = "3:根据id查询")
    @ApiOperationSupport(order = 3)
    @GetMapping("findById")
    ApiResp<MetadataTemplate> findById(@RequestParam("id") String id) throws BusinessException {
        return ApiResp.ofSuccess(metadataTemplateService.findById(id));
    }
    
    @ApiOperation(value = "4:新增或更新")
    @ApiOperationSupport(order = 4)
    @PostMapping("save")
    ApiResp<Object> save(@RequestBody MetadataTemplate metadataTemplate) {
        metadataTemplateService.save(metadataTemplate);
        return ApiResp.ofSuccess("保存成功");
    }
    
    @ApiOperation(value = "5:批量新增或更新")
    @ApiOperationSupport(order = 5)
    @PostMapping("saveAll")
    ApiResp<Object> saveAll(@RequestBody List<MetadataTemplate> metadataTemplateList) {
        metadataTemplateService.saveAll(metadataTemplateList);
        return ApiResp.ofSuccess("保存成功");
    }
    
    @ApiOperation(value = "6:根据id删除")
    @ApiOperationSupport(order = 6)
    @PostMapping("deleteById")
    ApiResp<Object> deleteById(@RequestBody String id) throws BusinessException {
        metadataTemplateService.deleteById(id);
        return ApiResp.ofSuccess("删除成功");
    }
    
    @ApiOperation(value = "7:根据id批量删除")
    @ApiOperationSupport(order = 7)
    @PostMapping("deleteAll")
    ApiResp<Object> deleteAll(@RequestBody List<String> ids) throws BusinessException {
        metadataTemplateService.deleteAll(ids);
        return ApiResp.ofSuccess("删除成功");
    }
}
