package com.ldy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ldy.entity.bean.UserBean;
import com.ldy.entity.form.UserForm;

public interface IUserService extends IService<UserBean> {
    void add(UserForm user);
}
