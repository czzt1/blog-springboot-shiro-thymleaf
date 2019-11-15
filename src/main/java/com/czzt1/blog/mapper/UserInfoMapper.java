package com.czzt1.blog.mapper;

import com.czzt1.blog.pojo.UserInfo;

public interface UserInfoMapper {
    UserInfo selectUserByName(String username);

    int insertNewUser(UserInfo userInfo);
}
