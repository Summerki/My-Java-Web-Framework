package org.smart4j.framework.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取属性Properties工具类
 */
public class PropsUtil {

    /**
     * 读取指定的properties文件返回properties对象
     * @param configFile
     * @return
     */
    public static Properties loadProps(String configFile) {
        Properties properties = new Properties();
        InputStream is = PropsUtil.class.getClassLoader().getResourceAsStream(configFile);
        try {
            properties.load(is);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据指定的propertiesKey从properties里面返回value
     * @param properties
     * @param propertiesKey
     * @return
     */
    public static String getString(Properties properties, String propertiesKey) {
        return properties.getProperty(propertiesKey);
    }


    /**
     * 根据指定的propertiesKey从properties里面返回value，如果没有找到propertiesKey就返回默认值defaultPath
     * @param properties
     * @param propertiesKey
     * @param defaultPath
     * @return
     */
    public static String getString(Properties properties, String propertiesKey, String defaultPath) {
        try {
            String propertiesValue = properties.getProperty(propertiesKey);
            return propertiesValue;
        } catch (Exception e) {
            return defaultPath;
        }
    }
}
