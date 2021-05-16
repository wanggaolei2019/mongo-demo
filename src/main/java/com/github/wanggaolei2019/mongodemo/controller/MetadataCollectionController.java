package com.github.wanggaolei2019.mongodemo.controller;

import com.github.wanggaolei2019.mongodemo.service.MetadataCollectionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
