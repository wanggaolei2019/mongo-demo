package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import com.github.wanggaolei2019.mongodemo.common.PageReq;
import com.github.wanggaolei2019.mongodemo.common.PageResp;
import com.github.wanggaolei2019.mongodemo.dto.MetadataQuery;
import com.github.wanggaolei2019.mongodemo.entity.MetadataTemplate;
import com.github.wanggaolei2019.mongodemo.entity.QMetadataTemplate;
import com.github.wanggaolei2019.mongodemo.repository.MetadataTemplateRepository;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author wanggl
 * @since 2021-05-16
 */
@Service
public class MetadataTemplateServiceImpl implements MetadataTemplateService{
    
    private final MetadataTemplateRepository metadataTemplateRepository;
    
    private final MongoTemplate mongoTemplate;
    
    public MetadataTemplateServiceImpl(MetadataTemplateRepository metadataTemplateRepository, MongoTemplate mongoTemplate) {
        this.metadataTemplateRepository = metadataTemplateRepository;
        this.mongoTemplate = mongoTemplate;
    }
    
    /**
     * 条件分页查询元数据模板信息
     *
     * @param pageReq 查询参数
     * @return 分页数据结束
     */
    @Override
    public PageResp<MetadataTemplate> page(PageReq<MetadataQuery> pageReq) {
        QMetadataTemplate qMetadataTemplate = QMetadataTemplate.metadataTemplate;
        MetadataQuery metadataQuery = pageReq.getParams();
    
        Predicate predicate = qMetadataTemplate._id.isNotNull();
    
        predicate = StringUtils.isEmpty(metadataQuery.getLabel()) ? predicate :
                ExpressionUtils.and(predicate, qMetadataTemplate.label.like("%"+metadataQuery.getLabel()+"%"));
        predicate = StringUtils.isEmpty(metadataQuery.getName()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.name.like("%"+metadataQuery.getName()+"%"));
        predicate = StringUtils.isEmpty(metadataQuery.getType()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.type.eq(metadataQuery.getType()));
        predicate = StringUtils.isEmpty(metadataQuery.getModule()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.module.eq(metadataQuery.getModule()));
        predicate = StringUtils.isEmpty(metadataQuery.getInputRequired()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.inputRequired.eq(metadataQuery.getInputRequired()));
        predicate = StringUtils.isEmpty(metadataQuery.getQueryRequired()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.queryRequired.eq(metadataQuery.getQueryRequired()));
        predicate = StringUtils.isEmpty(metadataQuery.getDisabled()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.disabled.eq(metadataQuery.getDisabled()));
        predicate = StringUtils.isEmpty(metadataQuery.getStatus()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.status.eq(metadataQuery.getStatus()));
        predicate = StringUtils.isEmpty(metadataQuery.getCreateBy()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.createBy.like("%"+metadataQuery.getCreateBy()+"%"));
        predicate = StringUtils.isEmpty(metadataQuery.getUpdateBy()) ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.updateBy.like("%"+metadataQuery.getUpdateBy()+"%"));
        predicate = null == metadataQuery.getCreateTimeStart() ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.createTime.goe(metadataQuery.getCreateTimeStart()));
        predicate = null == metadataQuery.getCreateTimeEnd() ? predicate :
                ExpressionUtils.and(predicate,qMetadataTemplate.createTime.loe(metadataQuery.getCreateTimeEnd()));
        
        long count = metadataTemplateRepository.count(predicate);
        if (count <= 0) {
            return PageResp.ofEmpty(pageReq,MetadataTemplate.class);
        }
    
        Page<MetadataTemplate> metadataTemplates = metadataTemplateRepository.findAll(predicate, pageReq.getPage());
        return PageResp.of(metadataTemplates);
    }
    
    /**
     * 条件分页查询元数据模板信息
     *
     * @param pageReq 查询参数
     * @return 分页数据结束
     */
    @Override
    public PageResp<MetadataTemplate> page2(PageReq<MetadataQuery> pageReq) {
        MetadataQuery metadataQuery = pageReq.getParams();
        Criteria criteria = new Criteria();
        if (StringUtils.isNotEmpty(metadataQuery.getLabel())) {
            criteria.and("label").regex("^.*" + metadataQuery.getLabel() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataQuery.getName())) {
            criteria.and("name").regex("^.*" + metadataQuery.getName() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataQuery.getType())) {
            criteria.and("type").is(metadataQuery.getType());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getModule())) {
            criteria.and("module").is(metadataQuery.getModule());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getInputRequired())) {
            criteria.and("inputRequired").is(metadataQuery.getInputRequired());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getQueryRequired())) {
            criteria.and("queryRequired").is(metadataQuery.getQueryRequired());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getDisabled())) {
            criteria.and("disabled").is(metadataQuery.getDisabled());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getStatus())) {
            criteria.and("status").is(metadataQuery.getStatus());
        }
        if (StringUtils.isNotEmpty(metadataQuery.getCreateBy())) {
            criteria.and("createBy").regex("^.*" + metadataQuery.getCreateBy() + ".*$");
        }
        if (StringUtils.isNotEmpty(metadataQuery.getUpdateBy())) {
            criteria.and("updateBy").regex("^.*" + metadataQuery.getUpdateBy() + ".*$");
        }
        if (null != metadataQuery.getCreateTimeStart()) {
            criteria.and("createTime").gte(metadataQuery.getCreateTimeStart());
        }
        if (null != metadataQuery.getCreateTimeEnd()) {
            criteria.and("createTime").lte(metadataQuery.getCreateTimeEnd());
        }
        
        Query query = Query.query(criteria);
        long count = mongoTemplate.count(query, MetadataTemplate.class);
        if (count <= 0) {
            return PageResp.ofEmpty(pageReq,MetadataTemplate.class);
        }
        List<MetadataTemplate> templateList = mongoTemplate.find(query, MetadataTemplate.class);
        return PageResp.of(pageReq.getPageNo(), pageReq.getPageSize(), templateList, count);
    }
    
    /**
     * 保存元数据模板
     *
     * @param metadataTemplate 元数据模板
     */
    @Override
    public void save(MetadataTemplate metadataTemplate) {
        metadataTemplateRepository.save(metadataTemplate);
    }
    
    /**
     * 保存元数据模板
     *
     * @param metadataTemplateList 元数据模板
     */
    @Override
    public void saveAll(List<MetadataTemplate> metadataTemplateList) {
        metadataTemplateList.parallelStream().forEach(metadataTemplateRepository::save);
    }
    
    /**
     * findById
     *
     * @param id id
     * @return one
     */
    @Override
    public MetadataTemplate findById(String id) throws BusinessException {
        Optional<MetadataTemplate> optional = metadataTemplateRepository.findById(id);
        return optional.orElseThrow(BusinessException::notFound);
    }
    
    /**
     * delete one
     *
     * @param id id
     */
    @Override
    public void deleteById(String id) {
        metadataTemplateRepository.deleteById(id);
    }
    
    /**
     * delete all
     *
     * @param ids ids
     */
    @Override
    public void deleteAll(List<String> ids) {
        for (String id : ids) {
            metadataTemplateRepository.deleteById(id);
        }
    }
}
