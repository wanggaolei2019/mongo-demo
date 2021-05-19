package com.github.wanggaolei2019.mongodemo.service;

import com.github.wanggaolei2019.mongodemo.common.BusinessException;
import org.bson.Document;

import java.util.List;

/**
 * @author wanggl
 * @since 2021-05-19
 */
public interface DataSyncService {
    /**
     * 数据同步
     *
     * @param documents 入参
     */
    void sync(List<Document> documents) throws BusinessException;
}
