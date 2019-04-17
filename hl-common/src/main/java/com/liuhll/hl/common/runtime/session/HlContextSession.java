package com.liuhll.hl.common.runtime.session;

import com.liuhll.hl.common.constant.CommonConstants;

import java.util.HashMap;
import java.util.Map;
public class HlContextSession {
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

    public static void setUserId(String userId){
        set(CommonConstants.CONTEXT_KEY_USER_ID,userId);
    }

    public static void setUserName(String username){
        set(CommonConstants.CONTEXT_KEY_USERNAME,username);
    }

    public static String getUserId(){
        return returnStringValue(get(CommonConstants.CONTEXT_KEY_USER_ID));
    }

    public static String getUserName(){
        return returnStringValue(get(CommonConstants.CONTEXT_KEY_USERNAME));
    }

    private static String returnStringValue(Object value) {
        return value==null?null:value.toString();
    }

    public static void remove(){
        threadLocal.remove();
    }



}
