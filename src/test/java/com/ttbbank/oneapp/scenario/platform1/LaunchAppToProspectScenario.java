package com.ttbbank.oneapp.scenario.platform1;

import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LaunchAppToProspectScenario extends BaseScenario {

    @Test(groups = "Launch App on Temp Screen", dependsOnGroups = {"Enter Home Screen Dev Latest","Enter Service Screen Dev Latest"})
    public void LaunchAPP() {

    }
}
