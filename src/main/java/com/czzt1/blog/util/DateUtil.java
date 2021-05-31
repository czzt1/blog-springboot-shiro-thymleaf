package com.czzt1.blog.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author czzt1
 * @Date 2019-06-20- 18:27
 */
public class DateUtil {
    public static String getWeekStr() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            case 8:
                return "星期日";
            default:
                return "未知";
        }

    }
}
