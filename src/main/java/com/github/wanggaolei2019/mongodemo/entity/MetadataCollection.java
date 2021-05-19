package com.github.wanggaolei2019.mongodemo.entity;

import com.github.wanggaolei2019.mongodemo.dto.ModuleDTO;
import io.swagger.annotations.ApiModel;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Document(collection = "metadata_collection")
@ApiModel("元数据集合")
public class MetadataCollection implements Serializable {
    private static final long serialVersionUID = -2662780591332706282L;
    
    @Id
    private String _id;
    
    private List<String> dataPrimaryKeys;
    
    private String label;
    
    private String name;
    
    private String describe;
    
    private String status;
    
    private List<ModuleDTO> moduleList;
    
    private String createBy;
    
    private String updateBy;
    
    @CreatedDate
    private Date createTime;
    
    @LastModifiedDate
    private Date updateTime;
    
    @Version
    private Long modifiedVersion;
    
    public String get_id() {
        return _id;
    }
    
    public void set_id(String _id) {
        this._id = _id;
    }
    
    public List<String> getDataPrimaryKeys() {
        return dataPrimaryKeys;
    }
    
    public void setDataPrimaryKeys(List<String> dataPrimaryKeys) {
        this.dataPrimaryKeys = dataPrimaryKeys;
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
    
    public Long getModifiedVersion() {
        return modifiedVersion;
    }
    
    public void setModifiedVersion(Long modifiedVersion) {
        this.modifiedVersion = modifiedVersion;
    }
    
    @Override
    public String toString() {
        return new StringJoiner(", ", MetadataCollection.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("dataPrimaryKeys=" + dataPrimaryKeys)
                .add("label='" + label + "'")
                .add("name='" + name + "'")
                .add("describe='" + describe + "'")
                .add("status='" + status + "'")
                .add("moduleList=" + moduleList)
                .add("createBy='" + createBy + "'")
                .add("updateBy='" + updateBy + "'")
                .add("createTime=" + createTime)
                .add("updateTime=" + updateTime)
                .add("modifiedVersion=" + modifiedVersion)
                .toString();
    }
}
