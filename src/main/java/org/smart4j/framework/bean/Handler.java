package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装注解Action上带有的信息
 * 更准确的说是，封装是哪个类哪个方法带有Action注解
 */
public class Handler {

    /**
     * Controller类
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
