package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 使用ClassHelper类可以获取所加载的类，但是无法实例化对象
 * 这里提供一个反射工具类，对外提供更好用的工具方法
 */
public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            LOGGER.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }

}
