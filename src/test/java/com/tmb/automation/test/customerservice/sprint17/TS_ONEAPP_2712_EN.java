package com.tmb.automation.test.customerservice.sprint17;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.BasePlatform2;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.tmb.automation.api.customerservice.VirtualPassbook.getAccountSaving;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;

public class TS_ONEAPP_2712_EN extends Base{
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}


    @Test(priority = 0)
    public void TS_ONEAPP_2710_EN_VPTutorial_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-tutorial-header-label']")));
        MobileElement HeaderText = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-header-label']");
        String elHeaderText = HeaderText.getText();
        MobileElement PassBookTutorial = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-desc-label']");
        String elPassBookTutorial = PassBookTutorial.getText();
        MobileElement Start = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-tutorial-button-footer']");
        String elStart = Start.getText();

        Assert.assertTrue(elHeaderText.equals("Passbook"));
        Assert.assertTrue(elPassBookTutorial.equals("You can view the passbook at any time, ready to download or share with friends or partners.Free! No additional cost."));
        Assert.assertTrue(elStart.equals("Start"));
        MobileElement start = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-tutorial-button-footer']"));
        start.click();
    }

//    @Test(priority = 1)
//    public static void TC_ONEAPP_4521_EN_CSTTutorial_SIT_00005() throws Exception {
//        WebDriverWait wait = new WebDriverWait(com.tmb.automation.test.customerservice.sprint17.appiumDriverMobile, 40);
//        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button"));
//        btnBack.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
//        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
//        virtualPassbook.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
//
//        if(false){
//            parentReport = extent.createTest("TC_ONEAPP-4521_EN", "TC_ONEAPP-4521_EN");
//        }
//        childReport = parentReport.createNode("TC_ONEAPP-4521_CSTTutorial_SIT_00005");
//        childReport.log(Status.INFO, "<pre>Expected Result : The system should not display Tutorial screen.</pre>");
////        childReport.log(Status.INFO, "<pre>Actual result : Display Title : " + TextColor.blueColor(elTutorialTitle)
////                + "</br>Display Text In progress Status : " + TextColor.blueColor(elTutorialDetail)
////                + "</pre>");
//        childReport.pass("Actual result : The system should display Case Status Tracking screen." + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//        MobileElement btnCST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-case-status-tracking']"));
//        btnCST.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='case-status-tracking-label-head']")));
//        childReport.pass("Actual result : The system should display Case Status Tracking screen." + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
////        Assert.assertTrue(elTutorialTitle.equals("Complaint / Request Tracking"));
////        Assert.assertTrue(elTutorialDetail.equals("Enable you to track status of your request and complaint anywhere anytime."));
//
//    }

    public void scroll() throws Exception {Dimension dim = appiumDriverMobile.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        TouchAction ts = new TouchAction(appiumDriverMobile);
        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
//        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
    }

    @Test(priority = 2)
    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00001() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-account-list-header-label']")));

        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_10']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_0']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_0']");
        String elBranchName = BranchName.getText();
        System.err.println("get element : " + elPassBook);
        System.err.println("get element : " + eltitlePassbook);
        System.err.println("get element : " + elAccountNickName);
        System.err.println("get element : " + elAccountNumber);
        System.err.println("get element : " + elBranchName);
        String[] arrAccountNO = elAccountNumber.split("-");
        String AccountNO = arrAccountNO[2]+arrAccountNO[3];
        String AccountNOSubstr = AccountNO.substring(2,6);
        System.err.println("split" + AccountNO.substring(2,6));

        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length BBB : " +jsonB.size());
        String account_type = "";
        String account_status = "";
        for(int i = 0; i < jsonB.size(); i++){
            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
            if(jsonObjIndexB.get("account_number").toString().substring(6,10).equals(AccountNOSubstr)){
                if(jsonObjIndexB.get("account_type").toString().equals("SDA") && jsonObjIndexB.get("account_status").toString().equals("INACTIVE")){
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = jsonObjIndexB.get("account_type").toString();
                    account_status = jsonObjIndexB.get("account_status").toString();
                }else {
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
                }
            }
        }
        System.err.println("accountType : "+ account_type);
        System.err.println("account_status : "+ account_status);

             Thread.sleep(5000);
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='0']"));
        selectAccount.click();
          Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));

        Assert.assertTrue(elPassBook.equals("Passbook"));
        Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
        Assert.assertTrue(elAccountNickName.equals("TMB SME One Bank (saving account)"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX396-0"));
        Assert.assertTrue(elBranchName.equals("PHAHONYOTHIN"));
        Assert.assertTrue(account_type.equals("SDA"));
        Assert.assertTrue(account_status.equals("INACTIVE"));
    }

    @Test(priority = 3)
    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00002() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
          }

//    @Test(priority = 2) //CDA
//    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00005() throws Exception {
//        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
//        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
//        virtualPassbook.click();wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
//
//        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
//        String elPassBook = PassBook.getText();
//        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
//        String eltitlePassbook = titlePassbook.getText();
//        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_11']");
//        String elAccountNickName = AccountNickName.getText();
//        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_1']");
//        String elAccountNumber = AccountNumber.getText();
//        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_1']");
//        String elBranchName = BranchName.getText();
//        System.err.println("get element : " + elPassBook);
//        System.err.println("get element : " + eltitlePassbook);
//        System.err.println("get element : " + elAccountNickName);
//        System.err.println("get element : " + elAccountNumber);
//        System.err.println("get element : " + elBranchName);
//        String[] arrAccountNO = elAccountNumber.split("-");
//        String AccountNO = arrAccountNO[2]+arrAccountNO[3];
//        String AccountNOSubstr = AccountNO.substring(2,6);
//        System.err.println("split" + AccountNO.substring(2,6));
//
//        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
//        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
//        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
//        System.err.println("length BBB : " +jsonB.size());
//        String account_type = "";
//        String account_status = "";
//        for(int i = 0; i < jsonB.size(); i++){
//            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
//            if(jsonObjIndexB.get("account_number").toString().substring(6,10).equals(AccountNOSubstr)){
//                if(jsonObjIndexB.get("account_type").toString().equals("CDA") && jsonObjIndexB.get("account_status").toString().equals("ACTIVE")){
//                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
//                    account_type = jsonObjIndexB.get("account_type").toString();
//                    account_status = jsonObjIndexB.get("account_status").toString();
//                }else {
//                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
//                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
//                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
//                }
//            }
//        }
//        System.err.println("accountType : "+ account_type);
//        System.err.println("account_status : "+ account_status);
//
//        if(false){
//            parentReport = extent.createTest("TS_ONEAPP_2712_EN", "TS_ONEAPP_2712_EN");
//        }
//        childReport = parentReport.createNode("TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00005");
//        childReport.log(Status.INFO, "<pre> Expected Result : 1. The system should display Select Account screen Details as below:\n" +
//                "1.1 Display Back icon\n" +
//                "1.2 Display Title: \"E-Passbook\" (EN), \"หน้าสมุดบัญชี\" (TH)\n" +
//                "1.3 Display Text Information: \"Please select the deposit account\" (EN), \"เลือกบัญชีที่คุณต้องการ\" (TH)\n" +
//                "1.4 Display Select Icon\n" +
//                "1.5 Display Account Nick Name correctly\n" +
//                "1.6 Display Account Number in format length = 10 digits = XXX-X-XX999-9 if length not 10 digits = XXXXXXXXXX9999 (masking only last 4 digits)\n" +
//                "1.7 Display Branch Name correctly\n" +
//                "1.8 Display Confirm Button as disable button\n" +
//                "2. The system change the color of Select Icon and Account Card.\n" +
//                "2.1 The system enable Confirm Button after selecting account\n" +
//                "2.2 The system allows user to select only one account\n" +
//                "3. After clicking on Confirm Button, the system should display Virtual passbook.");
//        childReport.log(Status.INFO, "<pre> actual result : Display Title : " + TextColor.blueColor(elPassBook) + "</br>Display Text Information : " + TextColor.blueColor(eltitlePassbook)
//                + "</br>Display Account Nick Name : " + TextColor.blueColor(elAccountNickName)
//                + "</br>Display Account Number : " + TextColor.blueColor(elAccountNumber)
//                + "</br>Display Branch Name : " + TextColor.blueColor(elBranchName)
//                + "</br>Display Account Type : " + account_type
//                + "</br>Display Account Status : " + account_status + "</pre>");
//        childReport.pass("1. The system should display Select Account screen Details as below:" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        MobileElement selectAccount13 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='2']"));
//        selectAccount13.click();
//        Thread.sleep(2000);
//        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='4']"));
//        selectAccount.click();
//        childReport.pass("2. The system change the color of Select Icon and Account Card.\n" +
//                "2.1 The system enable Confirm Button after selecting account\n" +
//                "2.2 The system allows user to select only one account\n" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        Thread.sleep(1000);
//        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
//        View.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));
//
//        childReport.pass("3. After clicking on Confirm Button, the system should display Virtual passbook."+ TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//        Assert.assertTrue(elPassBook.equals("Passbook"));
//        Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
//        Assert.assertTrue(elAccountNickName.equals("Term Deposit Account 6 Months"));
//        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX385-3"));
//        Assert.assertTrue(elBranchName.equals("PHAHONYOTHIN"));
//        Assert.assertTrue(account_type.equals("CDA"));
//        Assert.assertTrue(account_status.equals("ACTIVE"));
//    }

    @Test(priority = 4)
    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00003() throws Exception {
        Thread.sleep(5000);
//        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
//        btnBackVirtual.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
//        scroll();
//        scroll();
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_12']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_2']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_2']");
        String elBranchName = BranchName.getText();
        System.err.println("get element : " + elPassBook);
        System.err.println("get element : " + eltitlePassbook);
        System.err.println("get element : " + elAccountNickName);
        System.err.println("get element : " + elAccountNumber);
        System.err.println("get element : " + elBranchName);
        String[] arrAccountNO = elAccountNumber.split("-");
        String AccountNO = arrAccountNO[2]+arrAccountNO[3];
        String AccountNOSubstr = AccountNO.substring(2,6);
        System.err.println("split" + AccountNO.substring(2,6));


        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length BBB : " +jsonB.size());
        String account_type = "";
        String account_status = "";
        for(int i = 0; i < jsonB.size(); i++){
            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
            if(jsonObjIndexB.get("account_number").toString().substring(6,10).equals(AccountNOSubstr)){
                if(jsonObjIndexB.get("account_type").toString().equals("DDA") && jsonObjIndexB.get("account_status").toString().equals("ACTIVE")){
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = jsonObjIndexB.get("account_type").toString();
                    account_status = jsonObjIndexB.get("account_status").toString();
                }else {
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
                }
            }
        }
        System.err.println("accountType : "+ account_type);
        System.err.println("account_status : "+ account_status);

        MobileElement selectAccount15 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='2']"));
        selectAccount15.click();
           Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));

        Assert.assertTrue(elPassBook.equals("Passbook"));
        Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
        Assert.assertTrue(elAccountNickName.equals("Current Account"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX792-0"));
        Assert.assertTrue(elBranchName.equals("PHAHONYOTHIN"));
        Assert.assertTrue(account_type.equals("DDA"));
        Assert.assertTrue(account_status.equals("ACTIVE"));
    }


    @Test(priority = 5)
    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00010() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
//        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
//        virtualPassbook.click();wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length BBB : " +jsonB.size());
        String account_type = "";
        String account_status = "";
        String account_number = "";
        String product_name_en = "";
        for(int i = 0; i < jsonB.size(); i++){
            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
            if(jsonObjIndexB.get("account_number").toString().equals("0012068896")){
                if(jsonObjIndexB.get("relationship_code").toString().equals("PRIJNT")){
                    account_number = jsonObjIndexB.get("account_number").toString();
                    product_name_en = jsonObjIndexB.get("product_name_en").toString();
                    account_type = jsonObjIndexB.get("account_type").toString();
                    account_status = jsonObjIndexB.get("relationship_code").toString();
                }else {
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
                }
            }
        }
        System.err.println("product_name_en : "+ product_name_en);
        System.err.println("account_number : "+ account_number);
        System.err.println("accountType : "+ account_type);
        System.err.println("account_status : "+ account_status);

        
        //    scroll();
//        childReport.pass("The system should not provide join account in Select Account screen."+ TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
////        scroll();
//        childReport.pass("The system should not provide join account in Select Account screen."+ TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());

        Assert.assertTrue(product_name_en.equals("Basic Account"));
        Assert.assertTrue(account_number.equals("0012068896"));
        Assert.assertTrue(account_type.equals("SDA"));
        Assert.assertTrue(account_status.equals("PRIJNT"));
    }


    @Test(priority = 6)
    public void TS_ONEAPP_2712_EN_VPSelectAcct_SIT_00011() throws Exception {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
//        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
//        virtualPassbook.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));


        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_11']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_1']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_1']");
        String elBranchName = BranchName.getText();
        MobileElement AccountNickName2 = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_10']");
        String elAccountNickName2 = AccountNickName2.getText();
        MobileElement AccountNumber2 = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_0']");
        String elAccountNumber2 = AccountNumber2.getText();
        MobileElement BranchName2 = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_0']");
        String elBranchName2 = BranchName2.getText();
        System.err.println("get element : " + elPassBook);
        System.err.println("get element : " + eltitlePassbook);
        System.err.println("get element : " + elAccountNickName);
        System.err.println("get element : " + elAccountNumber);
        System.err.println("get element : " + elBranchName);
        String[] arrAccountNO = elAccountNumber2.split("-");
        String AccountNO = arrAccountNO[2]+arrAccountNO[3];
        String AccountNOSubstr = AccountNO.substring(2,6);
        System.err.println("split" + AccountNO.substring(2,6));

        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length BBB : " +jsonB.size());
        String account_type = "";
        String account_status = "";
        for(int i = 0; i < jsonB.size(); i++){
            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
            if(jsonObjIndexB.get("account_number").toString().substring(6,10).equals(AccountNOSubstr)){
                if(jsonObjIndexB.get("account_type").toString().equals("SDA") && jsonObjIndexB.get("account_status").toString().equals("INACTIVE")){
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = jsonObjIndexB.get("account_type").toString();
                    account_status = jsonObjIndexB.get("account_status").toString();
                }else {
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
                }
            }
        }
        System.err.println("accountType : "+ account_type);
        System.err.println("account_status : "+ account_status);

           MobileElement selectAccount13 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='1']"));
        selectAccount13.click();
        Thread.sleep(2000);
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='0']"));
        selectAccount.click();
         Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));
        MobileElement TextHeader = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]");
        String elTextHeader = TextHeader.getText();
        System.err.println("get element : " + elTextHeader);
        MobileElement AccountName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-name']");
        String elAccountName = AccountName.getText();
        System.err.println("get element : " + elAccountName);
//        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        MobileElement AccountNumberdetailScreen = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-account-no']");
        String elAccountNumberDetailScreen = AccountNumberdetailScreen.getText();
        System.err.println("get element : " + elAccountNumberDetailScreen);
        MobileElement BranchNameDetailScreen = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-branch-name']");
        String elBranchNameDetailScreen = BranchNameDetailScreen.getText();
        System.err.println("get element : " + elBranchNameDetailScreen);
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-product-name-label']");
        String elProductName = ProductName.getText();
        System.err.println("get element : " + elProductName);
        MobileElement Note = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[12]");
        String elNote = Note.getText();
        System.err.println("get element : " + elNote);
        MobileElement textInNote = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[13]");
        String eltextInNote = textInNote.getText();
        System.err.println("get element : " + eltextInNote);
        MobileElement textInNote2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[14]");
        String eltextInNote2 = textInNote2.getText();
        System.err.println("get element : " + eltextInNote2);
        MobileElement btnBackMain = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-back-to-main-button']");
        String elbtnBackMain = btnBackMain.getText();
        MobileElement btnImage = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-image']");
        String elbtnImage = btnImage.getText();
        MobileElement btnPDFfile = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-detail-button-gen-pdf']");
        String elbtnPDFfile = btnPDFfile.getText();
      
        Assert.assertTrue(elPassBook.equals("Passbook"));
        Assert.assertTrue(eltitlePassbook.equals("Please select an account"));
        Assert.assertTrue(elAccountNickName2.equals("TMB SME One Bank (saving account)"));
        Assert.assertTrue(elAccountNumber2.equals("XXX-X-XX396-0"));
        Assert.assertTrue(elBranchName2.equals("PHAHONYOTHIN"));
        Assert.assertTrue(account_type.equals("SDA"));
        Assert.assertTrue(account_status.equals("INACTIVE"));
        Assert.assertTrue(elTextHeader.equals("Passbook"));
        Assert.assertTrue(elAccountNumberDetailScreen.equals("001-9-68396-0"));
        Assert.assertTrue(elAccountName.equals("น.ส. สุธาวัลย์ จิรันดร"));
        Assert.assertTrue(elBranchNameDetailScreen.equals("พหลโยธิน"));
        Assert.assertTrue(elProductName.equals("บัญชีออมทรัพย์ TMB SME One Bank"));
        Assert.assertTrue(elNote.equals("หมายเหตุ:"));
        Assert.assertTrue(eltextInNote.equals("- หน้าสมุดบัญชีเงินฝากแบบอิเล็กทรอนิกส์ (E-Passbook)นี้ ใช้เพื่อแสดงหมายเลขบัญชี สาขา และ ชื่อเจ้าของบัญชีเงินฝาก จากระบบของธนาคารทหารไทยธนชาต จำกัด (มหาชน) เท่านั้น"));
        Assert.assertTrue(eltextInNote2.equals("- เพื่อความถูกต้องของการทำรายการ โปรดตรวจสอบชื่อเจ้าของบัญชีที่แสดงในระบบระหว่างการทำธุรกรรมทางการเงินทุกครั้ง"));
        Assert.assertTrue(elbtnBackMain.equals("Back to main page"));
        Assert.assertTrue(elbtnImage.equals("Image"));
        Assert.assertTrue(elbtnPDFfile.equals("PDF File"));
    }

}
