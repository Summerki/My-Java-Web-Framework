package org.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * 我们在Controller里面定义Service成员变量
 * 我们使用IOC的方式实现Service成员变量的实例化
 */
public class IocHelper {

    static {
        // 获取BEAN_MAP
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtils.isNotEmpty((Collection<?>) beanMap)) {
            // 遍历Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                // 获取Bean类和Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                // 获取Bean类定义的所有成员变量（Bean Field）
                Field[] beanFields = beanClass.getFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    // 遍历Bean Field
                    for (Field beanField : beanFields) {
                        // 判断当前Bean Field是否带有Inject注解
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            // 在Bean Map中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                // 通过反射初始化Bean Field的值
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

}
