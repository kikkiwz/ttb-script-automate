package com.ttbbank.oneapp.framework;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class OneAppElement {

    private final FindBy findBy;
    private final String elementLocator;
    private final int index;

    public OneAppElement(FindBy findBy, String elementLocator) {
        this(findBy, elementLocator, 0);
    }

    public OneAppElement(FindBy findBy, String elementLocator, int index) {
        this.findBy = findBy;
        this.elementLocator = elementLocator;
        this.index = index;
    }



    public By getLocator() {
        if (FindBy.ID == findBy) {
            return By.id(elementLocator);
        }
        if (FindBy.XPATH == findBy) {
            return By.xpath(elementLocator);
        }
        if (FindBy.ACCESSIBILITY_ID == findBy) {
            return MobileBy.AccessibilityId(elementLocator);
        }
        if (FindBy.TEXT == findBy) {
            return MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + elementLocator + "\")");
        }
        if (FindBy.RESOURCE_ID == findBy) {
            return MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"" + elementLocator + "\").instance("+index+")");
        }
        if (FindBy.CSS_SELECTOR == findBy) {
            return By.cssSelector(elementLocator);
        }

        return null;
    }

}
