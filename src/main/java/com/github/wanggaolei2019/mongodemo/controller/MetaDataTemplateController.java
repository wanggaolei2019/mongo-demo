package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.common.ApiResp;
import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataDTO;
import com.github.wanggaolei2019.mongodemo.dto.MetadataQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataTemplate;
import com.github.wanggaolei2019.mongodemo.service.MetadataTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@RestController
@RequestMapping("metadata/template")
public class MetaDataTemplateController {
    
    private final MetadataTemplateService metadataTemplateService;
    
    public MetaDataTemplateController(MetadataTemplateService metadataTemplateService) {
        this.metadataTemplateService = metadataTemplateService;
    }
    
    @PostMapping("page")
    ApiResp<PageResp<MetadataTemplate>> page(@RequestBody PageReq<MetadataQuery> pageReq) {
        return ApiResp.ofSuccess(metadataTemplateService.page(pageReq));
    }
    
    @PostMapping("page2")
    ApiResp<PageResp<MetadataTemplate>> page2(@RequestBody PageReq<MetadataQuery> pageReq) {
        return ApiResp.ofSuccess(metadataTemplateService.page2(pageReq));
    }
    
    @GetMapping("findById")
    ApiResp<MetadataTemplate> findById(@RequestParam("id") String id) throws BusinessException {
        return ApiResp.ofSuccess(metadataTemplateService.findById(id));
    }
    
    @PostMapping("save")
    ApiResp<Object> save(@RequestBody MetadataTemplate metadataTemplate) {
        metadataTemplateService.save(metadataTemplate);
        return ApiResp.ofSuccess("保存成功");
    }
    
    @PostMapping("saveAll")
    ApiResp<Object> saveAll(@RequestBody List<MetadataTemplate> metadataTemplateList) {
        metadataTemplateService.saveAll(metadataTemplateList);
        return ApiResp.ofSuccess("保存成功");
    }
    
    @PostMapping("deleteById")
    ApiResp<Object> deleteById(@RequestBody String id) throws BusinessException {
        metadataTemplateService.deleteById(id);
        return ApiResp.ofSuccess("删除成功");
    }
    
    @PostMapping("deleteAll")
    ApiResp<Object> deleteAll(@RequestBody List<String> ids) throws BusinessException {
       metadataTemplateService.deleteAll(ids);
        return ApiResp.ofSuccess("删除成功");
    }
}
