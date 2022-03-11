package com.ttbbank.oneapp.scenario.investment;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomeScenario extends BaseScenario {

    @Test(groups = "Home Page", dependsOnGroups = "Activate new flow")
    public void verifyAppHomePage() throws IOException {

        TtbTestContext context = getTtbTestContext();

        context.scrollDown();


        ExtentTest scenario = getFeature().createNode(Scenario.class, "Home");
        String transactionPlan = "images/" + context.getPlateFormName() + "/Home/Home page.png";
        takeScreenshot(transactionPlan);
        scenario.createNode(Given.class, "Home").addScreenCaptureFromPath(transactionPlan).pass("Home page display widget fund search correctly");

        WebElement searchFundWidget = context.findElement(OneAppElementKeys.TTB_PRODUCTS_FUND_SEARCH_WIDGET);
        searchFundWidget.click();

        context.setContextToWebView(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL, true);

        WebElement screenTitleLabel = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_TITLE_SCREEN_LABEL);
        System.out.println(screenTitleLabel.getText());

        WebElement backNavigationBar = context.findElement(OneAppElementKeys.INVESTMENT_FUND_SEARCH_BACK_NAVIGATION_BAR);
        backNavigationBar.click();

    }

}
