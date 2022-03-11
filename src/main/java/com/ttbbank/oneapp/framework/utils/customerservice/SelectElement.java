package com.ttbbank.oneapp.framework.utils.customerservice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectElement {
    private String selectTextDate;

    public SelectElement(Select element, int index, boolean setSelectElement) {
        List<WebElement> selectList = element.getOptions();
        for (int i = 0; i < selectList.size(); i++) {
            if (setSelectElement) {
                if (index < 24) {
                    if (i == index) {
                        element.selectByVisibleText(selectList.get(i).getText());
                        this.selectTextDate = selectList.get(i).getText();
                    }
                } else {
                    element.selectByVisibleText(selectList.get(selectList.size() - 1).getText());
                }
            } else {
                if (i == index) {
                    this.selectTextDate = selectList.get(i).getText();
                }
            }
        }
    }

    public String SelectText() {
        System.err.println("textttttt : " + this.selectTextDate);
        return this.selectTextDate;
    }
}
