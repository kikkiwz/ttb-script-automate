package com.ttbbank.oneapp.framework;

import java.util.Properties;


public class OneAppConfig {
    private Properties prop;
    private static OneAppConfig instance = new OneAppConfig();

    public static OneAppConfig getInstance() {
        return instance;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public String getConfig(String key) {
        return prop.getProperty(key);
    }
}
