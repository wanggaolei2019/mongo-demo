package com.github.wanggaolei2019.mongodemo.dto;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public class MetadataDTO implements Serializable {
    private static final long serialVersionUID = 2936831878242497909L;
    
    private String label;
    
    private String name;
    
    private String type;
    
    private String compareType;
    
    private String module;
    
    private String inputRequired;
    
    private String queryRequired;
    
    private String inputDefault;
    
    private String queryDefault;
    
    private String disabled;
    
    public String getCompareType() {
        return compareType;
    }
    
    public void setCompareType(String compareType) {
        this.compareType = compareType;
    }
    
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
    
    public String getQueryRequired() {
        return queryRequired;
    }
    
    public void setQueryRequired(String queryRequired) {
        this.queryRequired = queryRequired;
    }
    
    public String getInputDefault() {
        return inputDefault;
    }
    
    public void setInputDefault(String inputDefault) {
        this.inputDefault = inputDefault;
    }
    
    public String getQueryDefault() {
        return queryDefault;
    }
    
    public void setQueryDefault(String queryDefault) {
        this.queryDefault = queryDefault;
    }
    
    public String getDisabled() {
        return disabled;
    }
    
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", MetadataDTO.class.getSimpleName() + "[", "]")
                .add("label='" + label + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("compareType='" + compareType + "'")
                .add("module='" + module + "'")
                .add("inputRequired='" + inputRequired + "'")
                .add("queryRequired='" + queryRequired + "'")
                .add("inputDefault='" + inputDefault + "'")
                .add("queryDefault='" + queryDefault + "'")
                .add("disabled='" + disabled + "'")
                .toString();
    }
}
