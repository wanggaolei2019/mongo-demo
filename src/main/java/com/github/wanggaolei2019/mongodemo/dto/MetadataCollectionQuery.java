package com.github.wanggaolei2019.mongodemo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
public class MetadataCollectionQuery implements Serializable {
    private static final long serialVersionUID = -4304699624532777210L;
    
    private String name;
    
    private String describe;
    
    private String status;
    
    private String createBy;
    
    private String updateBy;
    
    private Date createTimeStart;
    
    private Date createTimeEnd;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescribe() {
        return describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
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
        return new StringJoiner(", ", MetadataCollectionQuery.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("describe='" + describe + "'")
                .add("status='" + status + "'")
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTimeStart=" + createTimeStart)
                .add("createTimeEnd=" + createTimeEnd)
                .toString();
    }
}
