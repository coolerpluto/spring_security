package com.fan.springsecurity.service.impl;

import com.fan.springsecurity.domain.LoginUser;
import com.fan.springsecurity.domain.ResponseResult;
import com.fan.springsecurity.domain.User;
import com.fan.springsecurity.service.LoginService;
import com.fan.springsecurity.utils.JwtUtil;
import com.fan.springsecurity.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private RedisCache redisCache;
    
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if (authenticate == null){
            throw new RuntimeException("登录失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        Map<String, String> map = new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login"+userId, loginUser);
        return new ResponseResult(200,"登录成功", map);
    }

    @Override
    public ResponseResult loginOut() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authentication.getPrincipal();
        String userId = principal.getUser().getId().toString();
        redisCache.deleteObject("login"+userId);
        return new ResponseResult(200,"注销成功");
    }
}
