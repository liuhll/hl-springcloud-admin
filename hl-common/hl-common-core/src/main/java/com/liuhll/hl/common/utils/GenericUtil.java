package com.liuhll.hl.common.utils;

import java.lang.reflect.ParameterizedType;

public class GenericUtil {
    public static Class getGenericClass(Class clazz,Integer genericIndex){
        return(Class) (((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[genericIndex - 1]);
    }

    public static Class getGenericClass(Class clazz){
        return(Class) (((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[1]);
    }
}
