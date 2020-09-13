package com.shop.web.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @Author: hzwangwenting-01
 * @Description:
 * @Date: 2017/6/29 下午3:29
 */
public class Util {

    /**
     *
     * @return uuid
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }


    /**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     *
     * @param validateStr
     *            指定的字符串
     * @return 字符串的长度
     */
    public static int getChineseLength(String validateStr) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < validateStr.length(); i++) {
            /* 获取一个字符 */
            String temp = validateStr.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }


    public static boolean isAllBank(String ... strings){
        for ( String s : strings){
            if ( !StringUtils.isBlank(s) ){
                return false ;
            }
        }
        return true ;
    }

    public static boolean isAllNotBlank(String ... strings ){
        for ( String s : strings){
            if ( StringUtils.isBlank(s) ){
                return false ;
            }
        }
        return true ;
    }

    public static String getToken(){
        return "WEB" + UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getBoLuo(){
        return "union"+getUUID().substring(24);
    }

    public static void main(String[] args) {
        String s = UUID.randomUUID().toString().replaceAll("-","").substring(26);
        System.out.println(s);

    }

}
