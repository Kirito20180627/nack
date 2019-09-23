package com.ldy.entity.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class UserBean {

    private int id;
    private String name;
    private String password;



}
