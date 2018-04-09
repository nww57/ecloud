package com.sunesoft.ecloud.auth;

import com.sunesoft.ecloud.auth.utils.StringHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author: Zhouzh
 * @Date: 2018/3/24
 */
public class UserContext {

    public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

    public static void set(String key, Object value) {
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }

    public static Object get(String key){
        Map<String, Object> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<String, Object>();
            threadLocal.set(map);
        }
        return map.get(key);
    }

    public static String getUserID(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
        return returnObjectValue(value);
    }

    public static String getUsername(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
        return returnObjectValue(value);
    }

    public static String getRealName(){
        Object value = get(CommonConstants.CONTEXT_KEY_REALNAME);
        return StringHelper.getObjectValue(value);
    }
    public static String getAgencyId(){
        Object value = get(CommonConstants.CONTEXT_KEY_AGENCY_ID);
        return StringHelper.getObjectValue(value);
    }
    public static String getToken(){
        Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
        return StringHelper.getObjectValue(value);
    }
    public static void setToken(String token){set(CommonConstants.CONTEXT_KEY_USER_TOKEN,token);}

    public static void setRealName(String name){set(CommonConstants.CONTEXT_KEY_REALNAME,name);}

    public static void setUserID(UUID userID){
        set(CommonConstants.CONTEXT_KEY_USER_ID,userID);
    }
    public static void setAgencyId(UUID userID){
        set(CommonConstants.CONTEXT_KEY_AGENCY_ID,userID);
    }

    public static void setUsername(String username){
        set(CommonConstants.CONTEXT_KEY_USER_NAME,username);
    }

    private static String returnObjectValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }

}
