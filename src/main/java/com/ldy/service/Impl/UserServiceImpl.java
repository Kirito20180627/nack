package com.ldy.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldy.entity.po.User;
import com.ldy.entity.dao.UserMapper;
import com.ldy.entity.form.UserForm;
import com.ldy.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.serial.SerialException;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = SerialException.class)
    public void add(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        this.save(user);
    }
}
