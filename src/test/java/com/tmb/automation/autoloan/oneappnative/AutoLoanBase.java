package com.tmb.automation.autoloan.oneappnative;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mongodb.annotations.ThreadSafe;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.between;
import static java.time.Duration.ofMillis;

public class AutoLoanBase extends NativeBase {

    ExtentReports extent;
    ExtentTest feature;

    public void setExtentReports(ExtentReports extent) {
        this.extent = extent;
    }

    public ExtentReports getExtent() {
        return extent;
    }

    public ExtentTest getFeature() {
        return feature;
    }

    public void setFeature(ExtentTest feature) {
        this.feature = feature;
    }

    public void enterServiceRequest() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            (new TouchAction(getDriver()))
                    .press(PointOption.point(540, 2044))
                    .waitAction(waitOptions(ofMillis(800)))
                    .moveTo(PointOption.point(699, 1066)).release()
                    .perform();
            Thread.sleep(3000);
            
            (new TouchAction(getDriver())).tap(PointOption.point(521, 2090)).waitAction(waitOptions(ofMillis(800))).perform();
            Thread.sleep(3000);
            return;
        }
//        (new TouchAction(getDriver()))
//                .press(PointOption.point(259, 531))
//                .waitAction(waitOptions(ofMillis(800)))
//                .moveTo(PointOption.point(258, 100)).release()
//                .perform();
//        waitByAccessibilityId("Service Request");

        WebElement serviceRequestButton = getDriver().findElementByAccessibilityId("Service Request");
        serviceRequestButton.click();
//        waitByByXPath("(//XCUIElementTypeOther[@name=\"Service Request\"])[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[5]");


    }

    public void enterAutoLoan() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            Thread.sleep(5000);
            ScrolltillElementintoDisplay("//android.view.View[@text='HP Account Detail 216001064HP Account Detail']");
            Thread.sleep(3000);
            MobileElement autoLoan = (MobileElement) getDriver().findElement(By.xpath("//android.view.View[@text='HP Account Detail 216001064HP Account Detail']"));
            autoLoan.click();
            waitByByXPath("//android.widget.Button[@text='Pay Bill']");
            return;
        }
        Thread.sleep(5000);
        ScrolltillElementintoDisplay("//XCUIElementTypeStaticText[@value='HP Account Detail 216001064']");
        Thread.sleep(10000);
        MobileElement hpAccount = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@value='HP Account Detail 216001064']"));
        hpAccount.click();
        waitByByXPath("//XCUIElementTypeButton[@label='Pay Bill']");
    }

    public void enterPin() {
        if ("android".equalsIgnoreCase(getPlatform())) {
            waitById("com.ttbbank.oneapp.vit:id/key_00");
            enterPin(getDriver(), "android", "010203");
            return;
        }
        String BUTTON_0 = "//XCUIElementTypeStaticText[@name=\"0\"]";
        waitByByXPath(BUTTON_0);
        enterPin(getDriver(), "iOS", "010203");
    }

    public void waitHomeScreenVisible() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            waitByAccessibilityId("Welcome K. Name Test");
//            waitByByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[2]/android.view.View[1]/android.view.View[1]");
//            waitByElementId("home-screen-customer-name");
            return;
        }
        waitByAccessibilityId("Welcome K. Name Test");
    }

    public void openEntryMenu() {
        String platform = getPlatform();
        System.out.println("In open entry menu   "+platform);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if ("android".equalsIgnoreCase(platform)) {
        	getDriver().findElement(By.xpath("(//android.widget.ImageView[@resource-id='com.ttbbank.oneapp.vit:id/iv_tab_icon'])[2]")).click();
        	
    		System.out.println("We Logged in successfully on android");

            return;
        }
       // (new TouchAction(getDriver())).tap(PointOption.point(265, 865)).perform();
       getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Service\"]")).click();
      
       System.out.println("We Logged in successfully on ios");
    }

    public void enterViewRegistrationBook() throws InterruptedException {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            Thread.sleep(5000);
            (new TouchAction(getDriver()))
                    .press(PointOption.point(500, 1900))
                    .waitAction(waitOptions(ofMillis(800)))
                    .moveTo(PointOption.point(500, 300)).release()
                    .perform();
            Thread.sleep(2000);
            (new TouchAction(getDriver())).tap(PointOption.point(500, 1925)).waitAction(waitOptions(ofMillis(1000))).perform();
//            WebElement viewCarRegistration = getDriver().findElementById("al-view-car-book-button");
//            WebElement viewCarRegistration = getDriver().findElementByXPath("/html/body/div/div[1]/div[3]/div[3]/button[2]");
//            viewCarRegistration.click();
            return;
        }
        MobileElement viewRegistrationBTN = (MobileElement) getDriver().findElementByAccessibilityId("View Car Registration Book");
        viewRegistrationBTN.click();
        System.out.println("clicked---");
    }

    public void enterClosingAccount() throws InterruptedException {
        String platform = getPlatform();
        Thread.sleep(1000);
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement closeAccountAndBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text='Closing Account / Calculator']"));
            closeAccountAndBTN.click();
            return;
        }
        MobileElement ClosingAccountBTN1 = (MobileElement) getDriver()
                .findElement(By.xpath("//XCUIElementTypeStaticText[@label='Closing Account / Calculator']"));
        ClosingAccountBTN1.click();
    }

    public void openTapCalculateCloseAccount() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement calAmountTap = (MobileElement) getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View");
            calAmountTap.click();
            return;
        }
        MobileElement tapCalculate = (MobileElement) getDriver()
                .findElementByAccessibilityId("Calculate amount");
        tapCalculate.click();
    }

    public void openCalendar() throws InterruptedException {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement CalendarAndBTN = (MobileElement) getDriver().findElement(By.xpath("//android.view.View[@text='Select the date to close account']"));
            CalendarAndBTN.click();
            return;
        }
        MobileElement calendar = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeOther[@name=\"Closing Account\"]/XCUIElementTypeOther[6]"));
        calendar.click();
    }

    public void selectCalInvalidDate() throws InterruptedException {
        String platform = getPlatform();
        Thread.sleep(1500);
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement invalidDate = (MobileElement) getDriver().findElementById("android:id/button1");
            invalidDate.click();
            Boolean wrongHeaderAndroid = getDriver().findElement(By.xpath("//android.view.View[@text='Wrong date is selected']")).isDisplayed();
            Assert.assertTrue(wrongHeaderAndroid);
            MobileElement okBTNForPopupInvalidDate = (MobileElement) getDriver().findElement(By.xpath("//android.widget.Button[@text='OK']"));
            okBTNForPopupInvalidDate.click();
            return;
        }
        new TouchAction(getDriver()).tap(PointOption.point(150, 59)).waitAction().perform();
        Boolean wrongHeaderiOS = getDriver().findElementByAccessibilityId("Wrong date is selected").isDisplayed();
        Assert.assertTrue(wrongHeaderiOS);
        Thread.sleep(1500);
        MobileElement el1 = (MobileElement) getDriver().findElementByAccessibilityId("OK");
        el1.click();


    }

    public void closeWarningPopupInvalidDate() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            return;
        }
        MobileElement OkBTN = (MobileElement) getDriver().findElement(By.name("OK"));
        OkBTN.click();
        Boolean warningInvalidDate = getDriver().findElementById("Must be future date within contract period").isDisplayed();
        Assert.assertTrue(warningInvalidDate);
    }

    public void selectCalValidDate() throws InterruptedException {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            (new TouchAction(getDriver())).tap(PointOption.point(226, 1640)).perform();
            (new TouchAction(getDriver())).tap(PointOption.point(841, 1789)).perform();
            return;
        }
        new TouchAction(getDriver()).tap(PointOption.point(62, 534)).perform();
        new TouchAction(getDriver()).tap(PointOption.point(325, 604)).perform();
        MobileElement date27 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"27\"]"));
        MobileElement okBTN = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"OK\"]"));
        Thread.sleep(1000);
        date27.click();
        Thread.sleep(1000);
        okBTN.click();
    }

    public void enterValidEmail() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement validEmail = (MobileElement) getDriver().findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText");
            validEmail.clear();
            validEmail.sendKeys("suphakorn.ratsamhee@gmail.com");
            return;
        }

    }

    public void tapProcessByBank() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement processByBank = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text='Proceed by bank']"));
            processByBank.click();
            return;
        }
        MobileElement processByBank = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Proceed by bank']"));
        processByBank.click();
    }

    public void tapProcessByYourself() {
        String platform = getPlatform();
        if ("android".equalsIgnoreCase(platform)) {
            MobileElement processByYouSelf = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text='Proceed by yourself']"));
            processByYouSelf.click();
            return;
        }
        MobileElement processByYourself = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Proceed by yourself']"));
        processByYourself.click();
    }

    public void ScrollDown() {
        Dimension dimension = getDriver().manage().window().getSize();
        Double scrollHeightStart = dimension.getHeight() * 0.8;
        int scrollStart = scrollHeightStart.intValue();


        Double scrollHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = scrollHeightEnd.intValue();


        new TouchAction((PerformsTouchActions) getDriver()).longPress(PointOption.point(0, scrollStart))
                .moveTo(PointOption.point(0, scrollEnd)).release()
                .perform();

    }

    public List<WebElement> ViewElement(String xpath) {

        return getDriver().findElements(By.xpath(xpath));

    }

    public void ScrolltillElementintoDisplay(String xpath) {
        System.out.println("Inside Scrolling--- and size is--" + ViewElement(xpath).size());
        if (ViewElement(xpath).size() == 0) {
            while (ViewElement(xpath).size() == 0) {
                System.out.println("Scrolling---" + ViewElement(xpath).size());
                ScrollDown();
            }
            System.out.println(ViewElement(xpath).get(0).isDisplayed());
            try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            while (!ViewElement(xpath).get(0).isDisplayed()) {
                System.out.println("Scrolling till display--" + ViewElement(xpath).size());
                ScrollDown();
            }
            System.out.println("Scrolling completed on display ---" + ViewElement(xpath).size());
        } else {
            while (!ViewElement(xpath).get(0).isDisplayed()) {
                System.out.println("Scrolling till display--" + ViewElement(xpath).size());
                ScrollDown();
            }
            System.out.println("Scrolling completed on display ---" + ViewElement(xpath).size());
        }
    }

    public void enterCarTransferForm() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            Thread.sleep(1000);
            MobileElement carTransferBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text='Car Transferring Form']"));
            carTransferBTN.click();
            return;

        }
        MobileElement carTransferForm = (MobileElement) getDriver().findElement(By.name("Car Transferring Form"));
        carTransferForm.click();
    }

    public void tapAddEmail() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            Thread.sleep(1000);
            MobileElement editEmailBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.Button[@text='Edit Email Address']"));
            editEmailBTN.click();

            return;
        }
        waitByByXPath("//XCUIElementTypeButton[@name='Edit Email Address']");
        MobileElement carTransferAddEmailBTN = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Edit Email Address']"));
        carTransferAddEmailBTN.click();

    }

    public void inputInvalidEmail() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())) {
            MobileElement clearEmailValue = (MobileElement) getDriver().findElement(By.xpath("//android.widget.EditText[@resource-id='al-edit-email-account-information-input-email']"));
            clearEmailValue.clear();
            MobileElement emailAddressLabel = (MobileElement) getDriver().findElement(By.xpath("//android.view.View[@text='Edit Email Address']"));
            emailAddressLabel.click();
            MobileElement emailField = (MobileElement) getDriver().findElement(By.xpath("//android.widget.EditText[@resource-id='al-edit-email-account-information-input-email']"));
            emailField.sendKeys("Test12345");
            return;
        }
        Thread.sleep(1000);
        MobileElement clearCarTransferEmail = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail.clear();
        MobileElement clearCarTransferEmail2 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail2.clear();
        MobileElement clearCarTransferEmail3 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail3.clear();
        MobileElement clearCarTransferEmail4 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail4.clear();
        MobileElement labelAddEmail = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Edit Email Address']"));
        labelAddEmail.click();
        Thread.sleep(1000);
        MobileElement carTransferEmailField = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        carTransferEmailField.sendKeys("Test");

    }

    public void tapSaveEmail() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())){
            Thread.sleep(1000);
            MobileElement emailAddressLabel = (MobileElement) getDriver().findElement(By.xpath("//android.view.View[@text='Edit Email Address']"));
            emailAddressLabel.click();
            Thread.sleep(1000);
            MobileElement saveBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.Button[@resource-id='al-edit-email-account-information-save-button']"));
            saveBTN.click();
            return;
        }
        Thread.sleep(1000);
        MobileElement labelAddEmail = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Edit Email Address']"));
        labelAddEmail.click();
        Thread.sleep(1000);
        MobileElement emailOKBTNCarTransfer = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Save']"));
        emailOKBTNCarTransfer.click();
    }

    public void inputValidEmail() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())){
            Thread.sleep(1000);
            MobileElement clearEmailValue = (MobileElement) getDriver().findElement(By.xpath("//android.widget.EditText[@resource-id='al-edit-email-account-information-input-email']"));
            clearEmailValue.clear();
            MobileElement emailAddressLabel = (MobileElement) getDriver().findElement(By.xpath("//android.view.View[@text='Edit Email Address']"));
            emailAddressLabel.click();
            Thread.sleep(1000);
            MobileElement emailField = (MobileElement) getDriver().findElement(By.xpath("//android.widget.EditText[@resource-id='al-edit-email-account-information-input-email']"));
            emailField.sendKeys("tadasoikin@gmail.com");

            return;
        }
        Thread.sleep(1000);
        MobileElement clearCarTransferEmail = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail.clear();
        MobileElement clearCarTransferEmail2 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail2.clear();
        MobileElement clearCarTransferEmail3 = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        clearCarTransferEmail3.clear();
        MobileElement labelAddEmail = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Edit Email Address']"));
        labelAddEmail.click();
        Thread.sleep(1000);
        MobileElement enterValidEmailCarTransfer = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeTextField[@label='']"));
        enterValidEmailCarTransfer.sendKeys("tadasoikin@gmail.com");
    }

    public void tapNext() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())){
            Thread.sleep(2000);
            ScrolltillElementintoDisplay("//android.widget.Button[@text='Next']");
            MobileElement nextBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.Button[@text='Next']"));
            nextBTN.click();
            return;
        }
        Thread.sleep(2000);
        ScrolltillElementintoDisplay("//XCUIElementTypeButton[@label='Next']");
        MobileElement nextBTNCarTransfer = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@label='Next']"));
        nextBTNCarTransfer.click();
    }

    public void requestSuccessFul() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())){
            Thread.sleep(1000);
            waitByByXPath("//android.view.View[@text='Request Successful']");
            return;
        }
        waitByByXPath("//XCUIElementTypeStaticText[@label='Request Successful']");

    }

    public void enterCopyOfContract() throws InterruptedException {
        if ("android".equalsIgnoreCase(getPlatform())){
            Thread.sleep(1000);
            MobileElement CopyOfContractBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text='Contract copy']"));
            CopyOfContractBTN.click();

            return;
        }
        waitByByXPath("//XCUIElementTypeStaticText[@label='Contract copy']");
        MobileElement CopyOfContactBTN = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeStaticText[@label='Contract copy']"));
        CopyOfContactBTN.click();
    }

    public void tapSearchBranch(){
        if ("android".equalsIgnoreCase(getPlatform())){
            waitByByXPath("//android.widget.Button[@text='Search branch']");
            MobileElement searchBranchBTN = (MobileElement) getDriver().findElement(By.xpath("//android.widget.Button[@text='Search branch']"));
            searchBranchBTN.click();
            return;
        }
        waitByByXPath("//XCUIElementTypeButton[@name='Search branch']");
        MobileElement searchBranchBTN = (MobileElement) getDriver().findElement(By.xpath("//XCUIElementTypeButton[@name='Search branch']"));
        searchBranchBTN.click();
    }

}
