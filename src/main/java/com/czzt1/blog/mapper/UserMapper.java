package com.czzt1.blog.mapper;

import com.czzt1.blog.pojo.User;

public interface UserMapper {
    public User getByUsername(String username);
}
