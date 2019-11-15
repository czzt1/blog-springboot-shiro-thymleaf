package com.czzt1.blog.service.impl;

import com.czzt1.blog.mapper.LabelMapper;
import com.czzt1.blog.pojo.Label;
import com.czzt1.blog.service.LabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LabelServiceImpl implements LabelService {

    @Resource
    private LabelMapper labelMapper;
    @Override
    public Label getLabelById(int id) {
        return labelMapper.getLabelById(id);
    }
}
