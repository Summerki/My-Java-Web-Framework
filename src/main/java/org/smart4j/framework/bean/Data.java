package org.smart4j.framework.bean;

/**
 * 返回JSON数据的数据对象Bean
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
