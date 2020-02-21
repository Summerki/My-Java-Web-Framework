package org.smart4j.framework.test.staticProxy;

/**
 * Hello接口的实现类
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}
