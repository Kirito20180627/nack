package com.ldy.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ldy.entity.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<UserBean> {
}
