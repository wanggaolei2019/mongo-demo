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
    
    private String code;
    
    private String name;
    
    private String type;
    
    private Integer seqNo;
    
    List<MetadataDTO> metadataList;
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
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
    
    public Integer getSeqNo() {
        return seqNo;
    }
    
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
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
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("seqNo=" + seqNo)
                .add("metadataList=" + metadataList)
                .toString();
    }
}
