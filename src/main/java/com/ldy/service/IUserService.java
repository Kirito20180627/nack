package com.ldy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldy.entity.po.User;
import com.ldy.entity.form.UserForm;

public interface IUserService extends IService<User> {
    void add(UserForm user);
    void insert();
    void insertOne();
}
