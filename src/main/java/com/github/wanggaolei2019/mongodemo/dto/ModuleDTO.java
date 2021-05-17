package com.github.wanggaolei2019.mongodemo.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@ApiModel("元数据模块信息")
public class ModuleDTO implements Serializable {
    private static final long serialVersionUID = 8586625556124847920L;
    
    private String label;
    
    private String name;
    
    private String type;
    
    List<MetadataDTO> metadataList;
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public List<MetadataDTO> getMetadataList() {
        return metadataList;
    }
    
    public void setMetadataList(List<MetadataDTO> metadataList) {
        this.metadataList = metadataList;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", ModuleDTO.class.getSimpleName() + "[", "]")
                .add("label='" + label + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("metadataList=" + metadataList)
                .toString();
    }
}
