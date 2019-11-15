package com.czzt1.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.czzt1.blog.pojo.DailySentence;
import com.czzt1.blog.service.DailySentenceService;
import com.czzt1.blog.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author czzt1
 * @Date 2019-06-20- 16:43
 */
@Service
public class DailySentenceServiceImpl implements DailySentenceService {

    private final RestTemplate restTemplate;

    public DailySentenceServiceImpl(){

        this.restTemplate=new RestTemplate();

    }

    @Override
    public DailySentence getDailySentence() {
        DailySentence dailySentence=new DailySentence();
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf1=new SimpleDateFormat("yyyy年MM月dd日 ");
            String dateStr=sdf.format(new Date());
            String url="http://open.iciba.com/dsapi/?date="+dateStr;
            String resultStr=this.restTemplate.getForObject(url, String.class);
            JSONObject jsonObject= JSON.parseObject(resultStr);

            dailySentence.setEnglishText(jsonObject.getString("content"));
            dailySentence.setChineseText(jsonObject.getString("note"));
            String formatDateStr=sdf1.format(new Date())+ DateUtil.getWeekStr();
            dailySentence.setDateStr(formatDateStr);
        }catch (Exception e){
            dailySentence.setEnglishText("123");
            dailySentence.setChineseText("123");
            dailySentence.setDateStr("123");
        }
        return dailySentence;
    }
}
