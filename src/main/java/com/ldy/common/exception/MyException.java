package com.ldy.common.exception;

import java.util.HashMap;
import java.util.Map;

public class MyException extends RuntimeException{

    private static final long serialVersionUID = -8581672033133636908L;
    /**
     *  错误码枚举
     */
    private ErrorCodeEnum errorCode;
    /**
     * 详细错误信息
     */
    private Map<String, String> errorMap = new HashMap<>();
    /**
     * 带参构造器.
     *
     * @param errorCode
     */
    public MyException(ErrorCodeEnum errorCode) {
        super(errorCode.getDesc());
        this.setErrorCode(errorCode);
    }
    /**
     * 带参构造器.
     *
     * @param errorCode
     * @param message
     */
    public MyException(ErrorCodeEnum errorCode, String message) {
        super(message.isEmpty() ? errorCode.getDesc() : message);
        this.setErrorCode(errorCode);
    }
    /**
     * 带参构造器.
     *
     * @param errorCode
     * @param errorMap
     */
    public MyException(ErrorCodeEnum errorCode, Map<String, String> errorMap) {
        this(errorCode);
        this.errorMap = errorMap;
    }
    /**
     * 带参构造器.
     *
     * @param message
     */
    public MyException(String message) {
        super(message);
        this.setErrorCode(ErrorCodeEnum.UNKNOWN_ERROR);
    }
    /**
     * Gets error code.
     *
     * @return the error code
     */
    public ErrorCodeEnum getErrorCode() {
        return errorCode;
    }
    /**
     * Sets error code.
     *
     * @param errorCode the error code
     */
    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }
    /**
     * Gets error map.
     *
     * @return the error map
     */
    public Map<String, String> getErrorMap() {
        return errorMap;
    }
    /**
     * Sets error map.
     *
     * @param errorMap the error map
     */
    public void setErrorMap(Map<String, String> errorMap) {
        this.errorMap = errorMap;
    }
    private static String findMessage(Map<String, String> errorMap) {
        if (errorMap.isEmpty()) {
            return null;
        }
        return errorMap.values().iterator().next();
    }



}
