package org.smart4j.framework.test.JDKDynamicProxy;

/**
 * 测试JDK动态代理
 * JDK动态代理只能代理接口，不能代理没有接口的类
 *
 */
public class Client {

    public static void main(String[] args) {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("Jack");
    }

}
