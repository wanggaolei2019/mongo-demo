package com.github.wanggaolei2019.mongodemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.wanggaolei2019.mongodemo.dto.ModuleDTO;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Document(collection = "metadata_collection")
public class MetadataCollection implements Serializable {
    private static final long serialVersionUID = -2662780591332706282L;
    
    @Id
    private String _id;
    
    private String name;
    
    private String describe;
    
    private Long version;
    
    private String status;
    
    private List<ModuleDTO> moduleList;
    
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
    
    public Long getVersion() {
        return version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public List<ModuleDTO> getModuleList() {
        return moduleList;
    }
    
    public void setModuleList(List<ModuleDTO> moduleList) {
        this.moduleList = moduleList;
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
        return new StringJoiner(", ", MetadataCollection.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("name='" + name + "'")
                .add("describe='" + describe + "'")
                .add("version=" + version)
                .add("status='" + status + "'")
                .add("moduleList=" + moduleList)
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .toString();
    }
}
