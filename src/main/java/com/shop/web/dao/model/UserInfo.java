package com.shop.web.dao.model;

import lombok.Data;

@Data
public class UserInfo {
    // 账号 id
    private String userId;
    // 用户名
    private String userName;
    // 密码
    private String password;
}
