package com.shop.web.service;

import com.shop.web.dao.mapper.UserMapper;
import com.shop.web.dao.model.UserInfo;
import com.shop.web.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    // 注册
    public BaseResponse registerUser(String userName, String password) {
        userMapper.registerUser(userName, password);
        return new BaseResponse();
    }

    // 登录
    public BaseResponse loginUser(String userName, String password) {
        userMapper.loginUser(userName, password);
        return new BaseResponse();
    }

    public BaseResponse getUserInfo() {
        // 获取用户信息
        UserInfo userInfo = userMapper.getUserInfo();
        return new BaseResponse(userInfo);
    }
}
