package com.ldy.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldy.entity.po.User;
import com.ldy.entity.dao.UserMapper;
import com.ldy.entity.form.UserForm;
import com.ldy.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

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

    /**
     * 测试spring的事务机制
     */
    @Override
    public void insert() {
        this.insertOne();
    }


    @Override
    @Transactional
    public void insertOne() {
        User user = new User();
        user.setName("wangzhijun");
        user.setPassword("1125");
        JSONObject object = new JSONObject();
        object.put("1125","生日");
        user.setRemark(object);

        this.save(user);

        int i = 1 / 0;

        List<User> users = list();
        System.out.println(users);

    }
}
