package com.ldy.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldy.entity.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
