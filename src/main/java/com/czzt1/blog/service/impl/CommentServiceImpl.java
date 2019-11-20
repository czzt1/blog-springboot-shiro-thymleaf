package com.czzt1.blog.service.impl;

import com.czzt1.blog.mapper.CommentMapper;
import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
