package com.czzt1.blog.service.impl;

import com.czzt1.blog.mapper.UserMapper;
import com.czzt1.blog.pojo.User;
import com.czzt1.blog.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Set<String> getRoles(String username) {
        return null;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }
}
