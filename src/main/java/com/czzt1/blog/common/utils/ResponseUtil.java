package com.czzt1.blog.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtil {
    public static Map<String,Object> generateResponse(String retCode,String retMsg,Object data){
        Map<String,Object> response=new LinkedHashMap<>();
        response.put("retCode",retCode);
        response.put("retMsg",retMsg);
        response.put("data",data);
        return response;
    }

}

