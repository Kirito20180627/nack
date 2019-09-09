package com.ldy.common.exception;


public enum ErrorCodeEnum {
    SYS_ERROR("SYS_ERROR","系统错误，请重试"),
    UNKNOWN_ERROR("UNKNOWN_SYS_ERROR","未知的系统异常"),
    SERVICE_INVOKE_FAIL("SERVICE_INVOKE_FAIL","服务调用失败"),
    ILLEGAL_ARGS("ILLEGAL_ARGS","参数校验错误");

    private String code;
    private String desc;

    ErrorCodeEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public static ErrorCodeEnum getByValue(String code){
        for (ErrorCodeEnum result : values()){
            if (result.getCode().equals(code)){
                return result;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
