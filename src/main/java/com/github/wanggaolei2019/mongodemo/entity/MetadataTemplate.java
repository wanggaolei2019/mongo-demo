package com.github.wanggaolei2019.mongodemo.entity;

import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Document(collection = "metadata_template")
@ApiModel("元数据样板")
public class MetadataTemplate implements Serializable {
    private static final long serialVersionUID = 3608053396235029445L;
    
    @Id
    String _id;
    
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
    
    private String status;
    
    private String createBy;
    
    private String updateBy;
    
    @CreatedDate
    private Date createTime;
    
    @LastModifiedDate
    private Date updateTime;
    
    public String get_id() {
        return _id;
    }
    
    public void set_id(String _id) {
        this._id = _id;
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
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", MetadataTemplate.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
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
                .add("status='" + status + "'")
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .toString();
    }
}
