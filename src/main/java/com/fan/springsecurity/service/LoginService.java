package com.fan.springsecurity.service;

import com.fan.springsecurity.domain.ResponseResult;
import com.fan.springsecurity.domain.User;

public interface LoginService {
    ResponseResult login(User user);
    
    ResponseResult loginOut();
}
