package com.ttbbank.oneapp.scenario.lending;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class CardDetailScenario extends BaseScenario {

    @Test(groups = "Card Detail Primary")
    public void cardDetailPrimary() throws InterruptedException, IOException {

        //001100000000000000000018593707	1800272993728
        registerCrmByPassOTP("1800272993728");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Card Detail");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();



        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();


        // Credit Card Page.
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CREDIT_CARD_SO_FAST);
        String getCredit = creDitCard.getText();
        creDitCard.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        String creditCard = "images/CardDetail/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        WebElement getAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_PRODUCT_LANDIND_ACCOUNT);
        String getAc = getAccount.getText();

        //Click on More button
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        moreButton.click();
        Thread.sleep(500);
        String moreBT = "images/CardDetail/More Menu.png";
        takeScreenshot(moreBT);
        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");


        //Click on Card Detail
        WebElement cardDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_BUTTON);
        cardDetail.click();
        WebElement textAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT);
        Thread.sleep(1000);
        String cardDetailBT = "images/CardDetail/Card Detail Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Card Details page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Get Text to Assert
        WebElement textPoint = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_POINT);
        WebElement textDataAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_DATA_ACCOUNT);
        WebElement textDataCardName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DATAIL_DATA_CARD_NAME);
        WebElement textDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_HEAD);


        Assert.assertEquals(textDetail.getText(),"Card Detail");
        Assert.assertEquals(textAccount.getText(), "Account");
        Assert.assertEquals(textPoint.getText(), "Points");
        Assert.assertEquals(getCredit, textDataCardName.getText());
        Assert.assertEquals(getAc, textDataAccount.getText());

        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String cardDetail2 = "images/CardDetail/Card Detail 2.png";
        takeScreenshot(cardDetail2);
        scenario.createNode(Given.class, "Card Detail Page 2").addScreenCaptureFromPath(cardDetail2).pass("pass");


        WebElement textProductName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PRODUCT_NAME);
        WebElement textCardType = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_TYPE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_NUMBER);
        WebElement textCardHolder = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_HOLDER);
        WebElement textCardLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_LIMIT);
        WebElement textTotalAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_TOTAL_AMOUNT_DUE);
        WebElement textDetailMinimum = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_MINIMUM);
        WebElement textDetailStatement = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_STATEMENT);
        WebElement textPaymentDue = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PAYMENT_DUE);


        Assert.assertEquals(textProductName.getText(),"Product name");
        Assert.assertEquals(textCardType.getText(),"Card type");
        Assert.assertEquals(textCardNumber.getText(),"Card number");
        Assert.assertEquals(textCardHolder.getText(),"Card holder");
        Assert.assertEquals(textCardLimit.getText(),"Card limit");
        Assert.assertEquals(textTotalAmount.getText(),"Total amount due");
        Assert.assertEquals(textDetailMinimum.getText(),"Minimum amount due");
        Assert.assertEquals(textDetailStatement.getText(),"Statement date");
        Assert.assertEquals(textPaymentDue.getText(),"Payment due date");

        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(300);

        WebElement textPointDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_POINT_DETAIL);
        WebElement textOutstanding = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_OUTSTANDING);
        WebElement textExpiring = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_EXPIRING);

        Assert.assertEquals(textPointDetail.getText(),"Point details");
        Assert.assertEquals(textOutstanding.getText(),"Outstanding points");
        Assert.assertEquals(textExpiring.getText(),"Expiring points");

        Thread.sleep(300);
        String cardDetail3 = "images/CardDetail/Card Detail 3.png";
        takeScreenshot(cardDetail3);
        scenario.createNode(Given.class, "Card Detail Page 3").addScreenCaptureFromPath(cardDetail3).pass("pass");
        getExtent().flush();

    }

    @Test(groups = "Card Detail SUP Card")
    public void cardDetailSUP() throws InterruptedException, IOException {

        //001100000000000000000011004078	9446753669299
        registerCrmByPassOTP("9446753669299");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Card Detail SUP Card");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
//        enterPin();
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        System.out.println("Click on Card");
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();
        Thread.sleep(10000);
        String imgCard = "images/CardDetailSUP/Card Page.png";
        takeScreenshot(imgCard);
        scenario.createNode(Given.class, "Card Page").addScreenCaptureFromPath(imgCard).pass("pass");

        System.out.println("Swipe to find Card");
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CARD_DETAIL_SUP_CARD);
        Thread.sleep(2000);
        String imgCardSUP = "images/CardDetailSUP/SUP Card.png";
        takeScreenshot(imgCardSUP);
        scenario.createNode(Given.class, "SUP Card").addScreenCaptureFromPath(imgCardSUP).pass("pass");

        // Credit Card Page.
        System.out.println("Clcick on SUP Card");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_SUP_CARD);
        String getCredit = creDitCard.getText();
        creDitCard.click();
        Thread.sleep(35000);

        System.out.println("Change Webview");
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_BT_SUP_CARD, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_BT_SUP_CARD);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        System.out.println("More");
        WebElement moreBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_BT_SUP_CARD);
        Thread.sleep(3000);
        String creditCard = "images/CardDetailSUP/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click More");
        moreBT.click();
        String moreImg = "images/CardDetailSUP/More.png";
        takeScreenshot(moreImg);
        scenario.createNode(Given.class, "More menu").addScreenCaptureFromPath(moreImg).pass("pass");

        //Click on Card Detail
        System.out.println("Card Details");
        WebElement cardDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_BUTTON);
        cardDetail.click();
        Thread.sleep(10000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT, false);
        WebElement textAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT);
        Thread.sleep(1000);
        String cardDetailBT = "images/CardDetailSUP/Card Detail Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Card Details page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Get Text to Assert
        WebElement textDataAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_DATA_ACCOUNT);
        WebElement textDataCardName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DATAIL_DATA_CARD_NAME);
        WebElement textDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_HEAD);

        Assert.assertEquals(textDetail.getText(),"Card Detail");
        Assert.assertEquals(textAccount.getText(), "Account");

        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String cardDetail2 = "images/CardDetailSUP/Card Detail 2.png";
        takeScreenshot(cardDetail2);
        scenario.createNode(Given.class, "Card Detail Page 2").addScreenCaptureFromPath(cardDetail2).pass("pass");


        WebElement textProductName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PRODUCT_NAME);
        WebElement textCardType = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_TYPE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_NUMBER);
        WebElement textCardHolder = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_HOLDER);
        WebElement textCardLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_LIMIT);


        Assert.assertEquals(textProductName.getText(),"Product name");
        Assert.assertEquals(textCardType.getText(),"Card type");
        Assert.assertEquals(textCardNumber.getText(),"Card number");
        Assert.assertEquals(textCardHolder.getText(),"Card holder");
        Assert.assertEquals(textCardLimit.getText(),"Card limit");

        getExtent().flush();

    }

    @Test(groups = "Card Detail Primary has SUP")
    public void cardDetailHaveSUP() throws InterruptedException, IOException {

        //001100000000000000000011004078	9446753669299
//        registerCrmByPassOTP("9446753669299");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Card Detail Primary has SUP");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();
        enterPin();
//        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
//        skipOnAccount.click();

        System.out.println("Click on Card");
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();
        Thread.sleep(10000);
        String imgCard = "images/CardDetailPriHasSUP/Card Page.png";
        takeScreenshot(imgCard);
        scenario.createNode(Given.class, "Card Page").addScreenCaptureFromPath(imgCard).pass("pass");

        System.out.println("Swipe to find Card");
        ttbTestContext.scrollTillElementIntoDisplay(OneAppElementKeys.LENDING_CARD_DETAIL_SUP_CARD);
        Thread.sleep(2000);
        String imgCardSUP = "images/CardDetailPriHasSUP/SUP Card.png";
        takeScreenshot(imgCardSUP);
        scenario.createNode(Given.class, "SUP Card").addScreenCaptureFromPath(imgCardSUP).pass("pass");

        // Credit Card Page.
        System.out.println("Clcick on SUP Card");
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PRI_HAVE_SUP);
        String getCredit = creDitCard.getText();
        creDitCard.click();
        Thread.sleep(35000);

        System.out.println("Change Webview");
        if (ttbTestContext.isAndroid()) {
            WebDriver context = ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_BT_SUP_CARD, true);
            Thread.sleep(3000);
            Set<String> webNames = context.getWindowHandles();
            for (String s : webNames) {
                ttbTestContext.getDriver().switchTo().window(s);
                System.out.println("test : " + s);
                try {
                    ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_BT_SUP_CARD);
                    break;
                } catch (Exception e) {
                    System.out.println("This webview is't to use");
                }
            }
        }

        System.out.println("More");
        WebElement moreBT = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_MORE_PRI_HAS_SUP);
        Thread.sleep(3000);
        String creditCard = "images/CardDetailPriHasSUP/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Tap on Primary Credit Card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");

        System.out.println("Click More");
        moreBT.click();
        String moreImg = "images/CardDetailPriHasSUP/More.png";
        takeScreenshot(moreImg);
        scenario.createNode(Given.class, "More menu").addScreenCaptureFromPath(moreImg).pass("pass");

        //Click on Card Detail
        System.out.println("Card Details");
        WebElement cardDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_BUTTON);
        cardDetail.click();
        Thread.sleep(10000);
        ttbTestContext.setContextToWebView(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT, false);
        WebElement textAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT);
        Thread.sleep(1000);
        String cardDetailBT = "images/CardDetailPriHasSUP/Card Detail Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Card Details page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Get Text to Assert
        WebElement textPoint = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_POINT);
        WebElement textDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_HEAD);


        Assert.assertEquals(textDetail.getText(),"Card Detail");
        Assert.assertEquals(textAccount.getText(), "Account");
        Assert.assertEquals(textPoint.getText(), "Points");

        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String cardDetail2 = "images/CardDetailPriHasSUP/Card Detail 2.png";
        takeScreenshot(cardDetail2);
        scenario.createNode(Given.class, "Card Detail Page 2").addScreenCaptureFromPath(cardDetail2).pass("pass");


        WebElement textProductName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PRODUCT_NAME);
        WebElement textCardType = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_TYPE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_NUMBER);
        WebElement textCardHolder = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_HOLDER);
        WebElement textCardLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_LIMIT);
        WebElement textTotalAmount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_TOTAL_AMOUNT_DUE);
        WebElement textDetailMinimum = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_MINIMUM);
        WebElement textDetailStatement = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_STATEMENT);
        WebElement textPaymentDue = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PAYMENT_DUE);


        Assert.assertEquals(textProductName.getText(),"Product name");
        Assert.assertEquals(textCardType.getText(),"Card type");
        Assert.assertEquals(textCardNumber.getText(),"Card number");
        Assert.assertEquals(textCardHolder.getText(),"Card holder");
        Assert.assertEquals(textCardLimit.getText(),"Card limit");
        Assert.assertEquals(textTotalAmount.getText(),"Total amount due");
        Assert.assertEquals(textDetailMinimum.getText(),"Minimum amount due");
        Assert.assertEquals(textDetailStatement.getText(),"Statement date");
        Assert.assertEquals(textPaymentDue.getText(),"Payment due date");

        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.3, 0.5);
        Thread.sleep(300);

        WebElement textPointDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_POINT_DETAIL);
        WebElement textOutstanding = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_OUTSTANDING);
        WebElement textExpiring = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_EXPIRING);

        Assert.assertEquals(textPointDetail.getText(),"Point Detail");
        Assert.assertEquals(textOutstanding.getText(),"Outstanding points");
        Assert.assertEquals(textExpiring.getText(),"Expiring points");

        Thread.sleep(300);
        String cardDetail3 = "images/CardDetailPriHasSUP/Card Detail 3.png";
        takeScreenshot(cardDetail3);
        scenario.createNode(Given.class, "Card Detail Page 3").addScreenCaptureFromPath(cardDetail3).pass("pass");
        getExtent().flush();

    }

    @Test(groups = "Card Detail SSC Card")
    public void cardDetailSCC() throws InterruptedException, IOException {

        //001100000000000000000000506607	7531564253565
        registerCrmByPassOTP("7531564253565");
        TtbTestContext ttbTestContext = getTtbTestContext();
        System.out.println("Start...");

        ExtentTest scenario = getFeature().createNode(Scenario.class, "Android Card Detail SSC Card");
        String homeScreen = "images/Card Detail SCC/Home Screen TTB app.png";
        takeScreenshot(homeScreen);
        scenario.createNode(Given.class, "Home Screen TTB app").addScreenCaptureFromPath(homeScreen).pass("pass");
        System.out.println("Click on Account");
        WebElement accountButton = ttbTestContext.findElement(OneAppElementKeys.ACCOUNT_BUTTON);
        accountButton.click();

//        Thread.sleep(2000);
//        enterPin();
        System.out.println("Click Skip intro");
        WebElement skipOnAccount = ttbTestContext.findElement(OneAppElementKeys.NEXT_INTRO_HONE_SCREEN_BUTTON);
        skipOnAccount.click();

        System.out.println("Click Card Button");
        WebElement cardButton = ttbTestContext.findElement(OneAppElementKeys.CARD_HOME_SCREEN_BUTTON);
        cardButton.click();


        System.out.println("Click on account that selected");
        // Credit Card Page. should 4762-81XX-XXXX-0448
        WebElement creDitCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_SET_ATM_PIN_SELECT_SSC);
        String accSum = "images/Card Detail SCC/Account Summary.png";
        takeScreenshot(accSum);
        scenario.createNode(Given.class, "Click on Account Button, App navigate to Account Summary Page").addScreenCaptureFromPath(accSum).pass("pass");

        String getCredit = creDitCard.getText();
        creDitCard.click();
        ttbTestContext.waitUntilVisible(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
        WebDriverWait wait = new WebDriverWait(ttbTestContext.getDriver(), 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("com.ttbbank.oneapp.vit:id/complete_animation")));
        Thread.sleep(10000);
        String creditCard = "images/Card Detail SCC/Product Landing Page.png";
        takeScreenshot(creditCard);
        scenario.createNode(Given.class, "Click on Credit supplementary card, App navigate to Product Landing Page").addScreenCaptureFromPath(creditCard).pass("pass");


        //Click on More button
        System.out.println("Click on more button");
        WebElement moreButton = ttbTestContext.findElement(OneAppElementKeys.LENDING_MORE_BUTTON_LANDING_PAGE);
//        moreButton.click();
//        Thread.sleep(1000);
//        String moreBT = "images/Card Detail SCC/More Menu.png";
//        takeScreenshot(moreBT);
//        scenario.createNode(Given.class, "More menu.").addScreenCaptureFromPath(moreBT).pass("pass");


        //Click on Card Detail
        System.out.println("Click on Card Detail");
        WebElement clickDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_BUTTON);
        Thread.sleep(300);
        System.out.println("Click");
        clickDetail.click();
        Thread.sleep(1500);
        WebElement textAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_ACCOUNT);
        Thread.sleep(1000);
        String cardDetailBT = "images/Card Detail SCC/Card Detail Page.png";
        takeScreenshot(cardDetailBT);
        scenario.createNode(Given.class, "Click on Card details menu, App navigate to Card Details page.").addScreenCaptureFromPath(cardDetailBT).pass("pass");

        // Get Text to Assert
        WebElement textDataAccount = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_DATA_ACCOUNT);
//        WebElement textDataCardName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DATAIL_DATA_CARD_NAME);
        WebElement textDetail = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_HEAD);
        WebElement textCardManage = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_MANAGEMENT);
//        WebElement textAdjust = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_ADJUST);
        WebElement textBlockCard = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_BLOCK_CARD);


        Assert.assertEquals(textDetail.getText(),"Card Detail");
        Assert.assertEquals(textAccount.getText(), "Account");
        Assert.assertTrue(getCredit.equalsIgnoreCase(textDataAccount.getText()));
        Assert.assertEquals(textCardManage.getText(),"Card Management");
//        Assert.assertEquals(textAdjust.getText(), "Adjust usage limit");
        Assert.assertEquals(textBlockCard.getText(),"Block card");

        Thread.sleep(1000);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        ttbTestContext.verticalSwipeByPercentages(0.9, 0.1, 0.5);
        Thread.sleep(300);
        String cardDetail2 = "images/Card Detail SCC/Card Detail 2.png";
        takeScreenshot(cardDetail2);
        scenario.createNode(Given.class, "Card Detail Page 2").addScreenCaptureFromPath(cardDetail2).pass("pass");


        WebElement textProductName = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_PRODUCT_NAME);
        WebElement textCardType = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_TYPE);
        WebElement textCardNumber = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_NUMBER);
//        WebElement textCardHolder = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_HOLDER);
//        WebElement textCardLimit = ttbTestContext.findElement(OneAppElementKeys.LENDING_CARD_DETAIL_CARD_LIMIT);

        Assert.assertEquals(textProductName.getText(),"Product name");
        Assert.assertEquals(textCardType.getText(),"Card type");
        Assert.assertEquals(textCardNumber.getText(),"Card number");
//        Assert.assertEquals(textCardHolder.getText(),"Card holder");
//        Assert.assertEquals(textCardLimit.getText(),"Card limit");

        getExtent().flush();

    }
}
