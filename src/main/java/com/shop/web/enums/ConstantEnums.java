package com.shop.web.enums;


import lombok.Getter;

@Getter
public enum ConstantEnums {

    success(0, "SUCCESS"),
    USERNAME_WITH_PASSWORD_ERROR(1001, "用户名或密码错误"),

    PARAM_ERROR(2001, "参数错误:%s"),
    ;

    private Integer code;

    private String msg;


    ConstantEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
