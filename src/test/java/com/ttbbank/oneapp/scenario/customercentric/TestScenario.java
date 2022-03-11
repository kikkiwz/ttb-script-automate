package com.ttbbank.oneapp.scenario.customercentric;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.testng.annotations.Test;

public class TestScenario extends BaseScenario {

    @Test(groups = "example Group")
    public void exampleTest() {

        TtbTestContext context = getTtbTestContext();
        context.findElement(OneAppElementKeys.MORE_TAB).click();
        context.findElement(OneAppElementKeys.SETTING_BUTTON).click();
    }
}
