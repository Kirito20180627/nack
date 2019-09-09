package com.ldy.entity.vo;

import java.io.Serializable;

public class JsonResult implements Serializable {

    private static final long serialVersionUID = -2988388391057584135L;
    private String status;
    private Object data;
    private String msg;

    public static JsonResult success() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus("");
        jsonResult.setMsg("成功");
        return jsonResult;
    }

    public static JsonResult fail() {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setStatus("");
        jsonResult.setMsg("失败");
        return jsonResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
