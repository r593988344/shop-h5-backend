package com.shop.web.dao.mapper;

import com.shop.web.dao.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface UserMapper {
    Integer registerUser(@Param("userName") String userName, @Param("password") String password);

    Integer loginUser(@Param("userName") String userName, @Param("password") String password);

    UserInfo getUserInfo();
}
