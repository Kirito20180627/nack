package com.ldy.common.pattern.templatePattern;

public class BaseBizResult<T> {
    public BaseBizResult(String errorCode, String errorMsg){
        super();
        this.succeed=false;
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;
    }

    public BaseBizResult(T data) {
        super();
        this.succeed = true;
        this.data = data;
    }

    private boolean succeed;

    private String errorCode;

    private String errorMsg;

    private T data;

    public boolean isSucceed() {
        return succeed;
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
