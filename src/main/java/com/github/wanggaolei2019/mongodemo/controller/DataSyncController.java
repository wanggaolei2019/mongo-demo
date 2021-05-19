package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.common.ApiResp;
import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.service.DataSyncService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Api(tags = "3.0:数据同步")
@ApiSort(30)
@RestController
@RequestMapping("datasync")
public class DataSyncController {
    
    private final DataSyncService dataSyncService;
    
    public DataSyncController(DataSyncService dataSyncService) {
        this.dataSyncService = dataSyncService;
    }
    
    
    @ApiOperation(value = "1:数据同步接口")
    @ApiOperationSupport(order = 1)
    @PostMapping("sync")
    ApiResp<Object> page(@RequestBody List<Document> documents) throws BusinessException {
        dataSyncService.sync(documents);
        return ApiResp.ofSuccess("保存成功");
    }
    
}
