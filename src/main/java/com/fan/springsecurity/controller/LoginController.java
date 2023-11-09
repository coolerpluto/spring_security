package com.fan.springsecurity.controller;

import com.fan.springsecurity.domain.ResponseResult;
import com.fan.springsecurity.domain.User;
import com.fan.springsecurity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
    
    @GetMapping("/loginOut")
    public ResponseResult loginOut(){
        return loginService.loginOut();
    }
}
