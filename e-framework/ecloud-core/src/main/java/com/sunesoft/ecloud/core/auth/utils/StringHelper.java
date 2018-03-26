package com.sunesoft.ecloud.core.auth.utils;

/**
 * @author: Zhouzh
 * @Date: 2018/3/24
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
