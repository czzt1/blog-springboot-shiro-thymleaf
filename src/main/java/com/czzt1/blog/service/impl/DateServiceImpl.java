package com.czzt1.blog.service.impl;

import com.czzt1.blog.service.DateService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class DateServiceImpl implements DateService {
    @Override
    public String curDateStr() {
        SimpleDateFormat sdf=new SimpleDateFormat("");
        return null;
    }
}
