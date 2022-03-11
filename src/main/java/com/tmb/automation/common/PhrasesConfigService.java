package com.tmb.automation.common;

public interface PhrasesConfigService {

    String getValueTh(String key);
    String getValueEn(String key);
    String getValue(String language , String key);

}
