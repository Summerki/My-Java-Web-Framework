package org.smart4j.framework.test.JDKDynamicProxy;

/**
 * Greeting接口实现类
 */
public class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {

        System.out.println("Hello! " + name);

    }


}
