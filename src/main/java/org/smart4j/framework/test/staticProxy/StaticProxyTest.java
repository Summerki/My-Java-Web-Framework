package org.smart4j.framework.test.staticProxy;

/**
 * 静态代理Demo
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Hello helloProxy = new HelloProxy();
        helloProxy.say("Jack");
    }

}


