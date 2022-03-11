package com.ttbbank.oneapp.scenario.investment;

import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetDCAPlanScenarioFundFromMyMutual extends FundFactSheetTestScenario {

    @Test(groups = "Set DCA Plan", dependsOnGroups = "Fund Fact Sheet")
    public void setDCAPlanTest() throws InterruptedException {

        TtbTestContext context = getTtbTestContext();

        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_SET_DCA_FUND_NAME_LABEL);

        Assert.assertTrue(context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_FUND_FULL_NAME_LABEL).isDisplayed());

        //Selected Port
        WebElement portfolioText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_PORTFOLIO_TEXT);
        portfolioText.click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_PORTFOLIO_SCREEN_TITLE_BUTTON);
        WebElement portfolioNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_PORTFOLIO_NAME_LABEL);
        portfolioNameLabel.click();

        //Selected Payment Detail
        WebElement paymentDetailText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_PAYMENT_DETAIL_TEXT);
        paymentDetailText.click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_PAYMENT_DETAIL_SCREEN_TITLE_LABEL);
        WebElement paymentDetailAcctNameLabel = context.findElement(OneAppElementKeys.INVESTMENT_PAYMENT_DETAIL_ACCOUNT_NAME_LABEL);
        paymentDetailAcctNameLabel.click();

        //Enter the amount
        WebElement investmentAmountText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_INVESTMENT_AMOUNT_TEXT);
        investmentAmountText.sendKeys("1000.12");

        //Selected Start Mount
        WebElement startDateText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_INVESTMENT_START_TEXT);
        startDateText.clear();
        startDateText.click();
        System.err.println(context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_YEARS_LABEL).getText());
        System.err.println(context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_AUG_LABEL).getText());
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_CLOSE_BUTTON);
        WebElement startMonthPicker = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_AUG_LABEL);
        startMonthPicker.click();

        //Selected End Month
        WebElement endDateText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_INVESTMENT_END_TEXT);
        endDateText.click();
        context.waitUntilVisible(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_CLOSE_BUTTON);
        WebElement endMonthPicker = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_MONTH_SEP_LABEL);
        endMonthPicker.click();

        //Selected Day of Moth
        WebElement everyDayText = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_EVERY_DAY_OF_MONTH_TEXT);
        everyDayText.click();
        if (context.isAndroid()) {
            context.waitUntilVisible(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_DATE_SCREEN_TITLE_LABEL);
            WebElement everyDayPicker = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SELECTED_DATE_13TH_LABEL);
            everyDayPicker.click();
        } else {
            tapDateOfCalendar();
        }

        //Click Save
        WebElement saveButton = context.findElement(OneAppElementKeys.INVESTMENT_SET_DCA_SAVE_BUTTON);
        saveButton.click();

    }

    public void tapDateOfCalendar() {
        Dimension size = getTtbTestContext().getDriver().manage().window().getSize();

//        int anchor = (int) (size.height - 20);
//        int anchor = (int) ((size.height * 14) / 100);
//        System.out.println("value of percentage >> " + anchor);
//        int startPoint = (int) (size.width / 2);
        new TouchAction(getTtbTestContext().getDriver())
                .tap(PointOption.point(56, 776))
                .perform();
    }


}
