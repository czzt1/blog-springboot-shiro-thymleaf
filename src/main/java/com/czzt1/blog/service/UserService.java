package com.czzt1.blog.service;

import com.czzt1.blog.pojo.User;

import java.util.Set;


public interface UserService {
    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);

    User getByUsername(String username);
}
