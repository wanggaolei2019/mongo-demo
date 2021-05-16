package com.github.wanggaolei2019.mongodemo.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author no one
 */
public class BusinessException extends Exception {
    private static final long serialVersionUID = 1435081871849475077L;
    
    private static final Logger logger = LoggerFactory.getLogger(BusinessException.class);
    
    public BusinessException(Throwable cause) {
        super(cause);
        logger.info(cause.getMessage());
    }
    
    public BusinessException(String message) {
        super(message);
        logger.info(message);
    }
    
    public static BusinessException of(String message) {
        return new BusinessException(message);
    }
    
    public static BusinessException notFound() {
        return new BusinessException("数据不存在");
    }
}
