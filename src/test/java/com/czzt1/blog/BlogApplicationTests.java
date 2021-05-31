package com.czzt1.blog;

import com.czzt1.blog.service.impl.DailySentenceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Resource
    DailySentenceServiceImpl dailySentenceService;


    @Test
    public void contextLoads() {
        dailySentenceService.getDailySentence();
    }

}
