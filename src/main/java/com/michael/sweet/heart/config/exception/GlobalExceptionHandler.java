package com.michael.sweet.heart.config.exception;

import com.baomidou.mybatisplus.extension.api.IErrorCode;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.enums.ApiErrorCode;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.michael.sweet.heart.common.json.CodeEnumType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 *
 * @author michael.wang
 * @date 2019/9/27 17:44
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>
     * 自定义MP业务模块异常
     * <p>
     *
     * @param e 异常类型
     * @return
     */
    @ExceptionHandler(value = ApiException.class)
    public R<Object> handleBadRequest(ApiException e) {
        /*
         * MP业务逻辑异常
         */
        if (e instanceof ApiException) {
            IErrorCode errorCode = ((ApiException) e).getErrorCode();
            if (null != errorCode) {
                logger.debug("Rest request error, {}", errorCode.toString());
                return R.failed(errorCode);
            }
            logger.debug("Rest request error, {}", e.getMessage());
            return R.failed(e.getMessage());
        }

        /**
         * 系统内部异常，打印异常栈
         */
        logger.error("Error: handleBadRequest StackTrace : ", e);
        return R.failed(ApiErrorCode.FAILED);
    }

    /**
     * @Description: 自定义RestController层异常处理，
     * @Param: [ex]  SweetException
     * @return: java.util.Map
     * @Author: Arnold.zhao
     * @Date: 2019/4/10
     */
    @ExceptionHandler(value = SweetException.class)
    public Map myErrorHandler(SweetException ex) {
        Map map = new HashMap();
        map.put("code", ex.getCode());
        map.put("msg", ex.getMessage());
        map.put("status", ex.getStatus());
        logger.error("Error: handleBadRequest StackTrace : ", ex);
        return map;
    }

    @ExceptionHandler(value = Exception.class)
    public Map throwableHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", CodeEnumType.SYSTEM_FAILURE.getCode());
        map.put("msg", CodeEnumType.SYSTEM_FAILURE.getMessage());
        map.put("status", CodeEnumType.SYSTEM_FAILURE.getStatus());
        logger.error("Error: handleBadRequest StackTrace : ", ex);
        return map;
    }

    /*
        暂不使用model view做异常映射展示
     */
   /* @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", e.getMessage());
        modelAndView.setViewName("/error/error");
        return modelAndView;
    }*/

}
