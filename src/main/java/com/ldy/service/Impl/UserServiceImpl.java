package com.ldy.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldy.entity.bean.UserBean;
import com.ldy.entity.dao.UserMapper;
import com.ldy.entity.form.UserForm;
import com.ldy.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.serial.SerialException;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserBean> implements IUserService {
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SerialException.class)
    public void add(UserForm userForm) {
        UserBean userBean = new UserBean();
        userBean.setName(userForm.getName());
        userBean.setPassword(userForm.getPassword());
        this.save(userBean);
    }
}
