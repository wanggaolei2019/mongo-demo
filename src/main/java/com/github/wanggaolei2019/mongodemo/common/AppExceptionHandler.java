package com.github.wanggaolei2019.mongodemo.common;


import cn.hutool.core.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 声明要捕获的异常类
 *
 * @author GOODBOY
 */
@RestControllerAdvice
public class AppExceptionHandler {
    
    private final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);
    
    @ExceptionHandler(value = Exception.class)
    public ApiResp<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return ApiResp.ofFailed("系统内部异常：" + e.getMessage());
    }
    
    @ExceptionHandler(value = NullPointerException.class)
    public ApiResp<Object> handleNullPointerException(NullPointerException e) {
        log.error(e.getMessage(), e);
        StackTraceElement[] stackTrace = e.getStackTrace();
        if (ArrayUtil.isNotEmpty(stackTrace)) {
            StackTraceElement stackTraceElement = stackTrace[0];
            if (stackTraceElement != null) {
                return ApiResp.ofFailed("空指针异常：" + stackTraceElement.getMethodName());
            }
        }
        return ApiResp.ofFailed("空指针异常：");
    }
    
    @ExceptionHandler(value = BusinessException.class)
    public ApiResp<Object> handleBusinessException(BusinessException e) {
        log.info(e.getMessage(), e);
        return ApiResp.ofFailed("处理失败：" + e.getMessage());
    }
}
