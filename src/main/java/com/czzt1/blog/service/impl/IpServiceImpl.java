package com.czzt1.blog.service.impl;

import com.czzt1.blog.service.IpService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IpServiceImpl implements IpService {

    @Override
    public String getAreaByIpAddr(String ipAddr) {
        String url="http://whois.pconline.com.cn/ip.jsp?"+ipAddr;
        RestTemplate restTemplate=new RestTemplate();
        String result=restTemplate.getForObject(url,String.class);
        return result.replaceAll("\r","").replaceAll("\n","");
    }

}
