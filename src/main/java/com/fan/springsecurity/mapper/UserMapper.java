package com.fan.springsecurity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fan.springsecurity.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
