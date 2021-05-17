package com.github.wanggaolei2019.mongodemo.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@ApiModel("元数据样板查询参数")
public class MetadataQuery implements Serializable {
    
    private static final long serialVersionUID = 5254660050291725375L;
    
    private String label;
    
    private String name;
    
    private String type;
    
    private String module;
    
    private String inputRequired;
    
    private String queryRequired;
    
    private String disabled;
    
    private String status;
    
    private String createBy;
    
    private String updateBy;
    
    private Date createTimeStart;
    
    private Date createTimeEnd;
    
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
    
    public String getDisabled() {
        return disabled;
    }
    
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCreateBy() {
        return createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    
    public String getUpdateBy() {
        return updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    public Date getCreateTimeStart() {
        return createTimeStart;
    }
    
    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }
    
    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }
    
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", MetadataQuery.class.getSimpleName() + "[", "]")
                .add("label='" + label + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("module='" + module + "'")
                .add("inputRequired='" + inputRequired + "'")
                .add("queryRequired='" + queryRequired + "'")
                .add("disabled='" + disabled + "'")
                .add("status='" + status + "'")
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTime=" + createTimeStart)
                .add("updateTime=" + createTimeEnd)
                .toString();
    }
}
