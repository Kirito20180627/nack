package com.ldy.entity.form;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserForm implements Serializable {
    private static final long serialVersionUID = -1228997288483966431L;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private JSONObject remark;

}
