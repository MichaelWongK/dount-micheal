package com.michael.sweet.heart.config.exception;

import com.michael.sweet.heart.common.json.CodeEnumType;

/**
 * 控制层Controller 自定义异常提示
 *
 * @author michael.wang
 * @date 2019/9/27 17:44
 */

public class SweetException extends Exception {

    //异常状态码定义（暂）
    private CodeEnumType codeEnumType;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public SweetException(CodeEnumType codeEnumType, Throwable cause) {
        super(codeEnumType.getMessage(), cause);
        this.codeEnumType = codeEnumType;
    }


    public SweetException(CodeEnumType codeEnumType) {
        super(codeEnumType.getMessage());
        this.codeEnumType = codeEnumType;
    }


    public SweetException(String message, Throwable cause) {
        super(message, cause);
    }

    public SweetException(Throwable cause) {
        super(cause);
    }

    protected SweetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getStatus() {
        return codeEnumType.getStatus();
    }

    public Integer getCode() {
        return codeEnumType.getCode();
    }

    public CodeEnumType getCodeEnumType() {
        return codeEnumType;
    }

    public void setCodeEnumType(CodeEnumType codeEnumType) {
        this.codeEnumType = codeEnumType;
    }


}
