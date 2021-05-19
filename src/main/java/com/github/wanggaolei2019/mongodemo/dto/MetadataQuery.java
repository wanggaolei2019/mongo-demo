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
    
    private String code;
    
    private String name;
    
    private String type;
    
    private String module;
    
    private String inputRequired;
    
    private String disabled;
    
    private String display;
    
    private String status;
    
    private String createBy;
    
    private String updateBy;
    
    private Date createTimeStart;
    
    private Date createTimeEnd;
    
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
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("module='" + module + "'")
                .add("inputRequired='" + inputRequired + "'")
                .add("disabled='" + disabled + "'")
                .add("display='" + display + "'")
                .add("status='" + status + "'")
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTimeStart=" + createTimeStart)
                .add("createTimeEnd=" + createTimeEnd)
                .toString();
    }
}
