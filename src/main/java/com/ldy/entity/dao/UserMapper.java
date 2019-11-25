package com.ldy.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldy.entity.form.UserForm;
import com.ldy.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    void insertWithJson(User user);

    List<User> selectWithJson();


}
