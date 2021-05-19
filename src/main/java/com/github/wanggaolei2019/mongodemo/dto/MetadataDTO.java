package com.github.wanggaolei2019.mongodemo.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@ApiModel("元数据信息")
public class MetadataDTO implements Serializable {
    private static final long serialVersionUID = 2936831878242497909L;
    
    private String label;
    
    private String name;
    
    private String type;
    
    private Integer seqNo;
    
    private String compareType;
    
    private String module;
    
    private String inputRequired;
    
    private String inputDefault;
    
    private String disabled;
    
    private String display;
    
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
    
    public Integer getSeqNo() {
        return seqNo;
    }
    
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
    
    public String getCompareType() {
        return compareType;
    }
    
    public void setCompareType(String compareType) {
        this.compareType = compareType;
    }
    
    public String getModule() {
        return module;
    }
    
    public void setModule(String module) {
        this.module = module;
    }
    
    public String getInputRequired() {
        return inputRequired;
    }
    
    public void setInputRequired(String inputRequired) {
        this.inputRequired = inputRequired;
    }
    
    public String getInputDefault() {
        return inputDefault;
    }
    
    public void setInputDefault(String inputDefault) {
        this.inputDefault = inputDefault;
    }
    
    public String getDisabled() {
        return disabled;
    }
    
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    
    public String getDisplay() {
        return display;
    }
    
    public void setDisplay(String display) {
        this.display = display;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", MetadataDTO.class.getSimpleName() + "[", "]")
                .add("label='" + label + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("seqNo=" + seqNo)
                .add("compareType='" + compareType + "'")
                .add("module='" + module + "'")
                .add("inputRequired='" + inputRequired + "'")
                .add("inputDefault='" + inputDefault + "'")
                .add("disabled='" + disabled + "'")
                .add("display='" + display + "'")
                .toString();
    }
}
