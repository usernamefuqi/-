package com.atguigu.crud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author admin
 */
public class DateUtil {

    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

    //精确到秒
    public static Date string1Date() {
        Date date = new Date();
        Date dateFormat = null;
        try {
            String dateStr = sdf1.format(date);
            dateFormat = sdf1.parse(dateStr);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return dateFormat;
    }

    //精确到天
    public static Date string2Date(String dateString) {
        Date date = null;
        try {
            date = sdf2.parse(dateString);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return date;
    }
    public static String dateFormat() {
        return sdf2.format(new Date());
    }

    public static Date string3Date() {
        Date date = new Date();
        Date dateFormat = null;
        try {
            String dateStr = sdf2.format(date);
            dateFormat = sdf2.parse(dateStr);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        return dateFormat;
    }

}
