package com.shop.web.controller;

import com.shop.web.dto.BaseResponse;
import com.shop.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    /**
     * 注册
     * @param userName
     * @param password
     * @return
     */

    @PostMapping("/registerUser")
    public BaseResponse registerUser(@NotBlank(message = "用户名不为空")
                                  @RequestParam(value = "userName") String userName,
                                  @NotBlank(message = "密码不为空")
                                  @RequestParam(value = "password") String password){

        return userService.registerUser(userName, password);
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */

    @PostMapping("/loginUser")
    public BaseResponse loginUser(@NotBlank(message = "用户名不为空")
                                  @RequestParam(value = "userName") String userName,
                                  @NotBlank(message = "密码不为空")
                                  @RequestParam(value = "password") String password){

        return userService.loginUser(userName, password);
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getUserInfo")
    public BaseResponse getUserInfo(){

        return userService.getUserInfo();
    }
}
