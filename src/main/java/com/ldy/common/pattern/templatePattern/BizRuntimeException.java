package com.ldy.common.pattern.templatePattern;

public class BizRuntimeException extends RuntimeException {
    //建议用异常码枚举
    private String errorCode;
    private String errorMsg;

    public BizRuntimeException(String errorCode,String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
