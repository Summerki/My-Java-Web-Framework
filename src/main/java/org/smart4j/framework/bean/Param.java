package org.smart4j.framework.bean;

import java.util.Map;

/**
 * 请求参数对象
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     * @return
     */
    public long getLong(String name) {
        return (Long) paramMap.get(name);
    }

    /**
     * 获取所有的字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
