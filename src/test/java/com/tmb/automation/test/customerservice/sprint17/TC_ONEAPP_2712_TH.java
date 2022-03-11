package com.tmb.automation.test.customerservice.sprint17;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.test.customerservice.sprint25.MutualFund_EN;
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

public class TC_ONEAPP_2712_TH extends Base {
	 @Parameters({"DeviceProfile" })
		@BeforeClass
		public void BeforeTest(String deviceProfile) {
			Helper.CONFIG_PROFILE = deviceProfile;		
			appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
			 ExtentListeners.setDriver(appiumDriverMobile);
		}
    public static void scroll() throws Exception {
        Dimension dim = MutualFund_EN.appiumDriverMobile.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        TouchAction ts = new TouchAction(MutualFund_EN.appiumDriverMobile);
        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
//        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
    }
    public static void scrollUPANDDOWN(double start_xd, double start_yd, double end_xd, double end_yd) throws Exception {
        Dimension dim = MutualFund_EN.appiumDriverMobile.manage().window().getSize();
        int start_x = (int) (dim.width * start_xd);
        int start_y = (int) (dim.height * start_yd);
//        int x = width / 2;
        int end_x = (int) (dim.width * end_xd);
        int end_y = (int) (dim.height * end_yd);
        TouchAction ts = new TouchAction(MutualFund_EN.appiumDriverMobile);
        ts.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
//        ts.press(PointOption.point(x, top_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, bottom_y)).release().perform();
    }

    @Test(priority = 0)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_14']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_4']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_4']");
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
                if(jsonObjIndexB.get("account_type").toString().equals("SDA") && jsonObjIndexB.get("account_status").toString().equals("ACTIVE")){
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
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='4']"));
        selectAccount.click();
         Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));

        Assert.assertTrue(elPassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(eltitlePassbook.equals("เลือกบัญชีที่คุณต้องการ"));
        Assert.assertTrue(elAccountNickName.equals("บัญชีออลล์ฟรี"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX013-1"));
        Assert.assertTrue(elBranchName.equals("เซ็นทรัลพลาซา พระราม 9"));
        Assert.assertTrue(account_type.equals("SDA"));
        Assert.assertTrue(account_status.equals("ACTIVE"));
    }

    @Test(priority = 1)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00002() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
    }
    @Test(priority = 2)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00005() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

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
                if(jsonObjIndexB.get("account_type").toString().equals("CDA") && jsonObjIndexB.get("account_status").toString().equals("ACTIVE")){
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
   MobileElement selectAccount13 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='2']"));
        selectAccount13.click();
        Thread.sleep(2000);
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='4']"));
        selectAccount.click();
          Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));

        Assert.assertTrue(elPassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(eltitlePassbook.equals("เลือกบัญชีที่คุณต้องการ"));
        Assert.assertTrue(elAccountNickName.equals("บัญชีฝากประจำทั่วไป 6 เดือน"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX385-3"));
        Assert.assertTrue(elBranchName.equals("พหลโยธิน"));
        Assert.assertTrue(account_type.equals("CDA"));
        Assert.assertTrue(account_status.equals("ACTIVE"));
    }

    @Test(priority = 3)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00003() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));
        scroll();
        scroll();
        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_115']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_15']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_15']");
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

          Thread.sleep(5000);
       
        MobileElement selectAccount15 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='15']"));
        selectAccount15.click();
          Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));

     
        Assert.assertTrue(elPassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(eltitlePassbook.equals("เลือกบัญชีที่คุณต้องการ"));
        Assert.assertTrue(elAccountNickName.equals("บัญชีกระแสรายวัน"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX490-3"));
        Assert.assertTrue(elBranchName.equals("อุบลราชธานี"));
        Assert.assertTrue(account_type.equals("DDA"));
        Assert.assertTrue(account_status.equals("ACTIVE"));
    }


    @Test(priority = 4)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00010() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBack.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));

        JSONObject json2 = (JSONObject)new JSONParser().parse(getAccountSaving().toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("deposit_account_lists");
        System.err.println("length BBB : " +jsonB.size());
        String account_type = "";
        String account_status = "";
        String account_number = "";
        String product_name_th = "";
        for(int i = 0; i < jsonB.size(); i++){
            JSONObject jsonObjIndexB =  (JSONObject)jsonB.get(i);
            if(jsonObjIndexB.get("account_number").toString().equals("3051102857")){
                if(jsonObjIndexB.get("account_type").toString().equals("DDA") && jsonObjIndexB.get("relationship_code").toString().equals("PRIJNT")){
                    account_number = jsonObjIndexB.get("account_number").toString();
                    product_name_th = jsonObjIndexB.get("product_name_th").toString();
                    account_type = jsonObjIndexB.get("account_type").toString();
                    account_status = jsonObjIndexB.get("relationship_code").toString();
                }else {
                    System.err.println("jsonObjIndexB : "+ jsonObjIndexB);
                    account_type = TextColor.redColor(jsonObjIndexB.get("account_type").toString());
                    account_status = TextColor.redColor(jsonObjIndexB.get("account_status").toString());
                }
            }
        }
        System.err.println("product_name_th : "+ product_name_th);
        System.err.println("account_number : "+ account_number);
        System.err.println("accountType : "+ account_type);
        System.err.println("account_status : "+ account_status);

         scroll();
        scroll();
       
        Assert.assertTrue(product_name_th.equals("บัญชีกระแสรายวัน"));
        Assert.assertTrue(account_number.equals("3051102857"));
        Assert.assertTrue(account_type.equals("DDA"));
        Assert.assertTrue(account_status.equals("PRIJNT"));
    }


    @Test(priority = 5)
    public void TS_ONEAPP_2712_TH_VPSelectAcct_SIT_00011() throws Exception {
        Thread.sleep(5000);
        MobileElement btnBackVirtual = appiumDriverMobile.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.widget.Button"));
        btnBackVirtual.click();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-passbook']")));
        MobileElement virtualPassbook = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-passbook']"));
        virtualPassbook.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook_account_list_title_label']")));


        MobileElement PassBook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook-account-list-header-label']");
        String elPassBook = PassBook.getText();
        MobileElement titlePassbook = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='passbook_account_list_title_label']");
        String eltitlePassbook = titlePassbook.getText();
        MobileElement AccountNickName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='productName_14']");
        String elAccountNickName = AccountNickName.getText();
        MobileElement AccountNumber = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='accountNumber_4']");
        String elAccountNumber = AccountNumber.getText();
        MobileElement BranchName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='branchName_4']");
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
                if(jsonObjIndexB.get("account_type").toString().equals("SDA") && jsonObjIndexB.get("account_status").toString().equals("ACTIVE")){
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
   MobileElement selectAccount13 = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='3']"));
        selectAccount13.click();
         Thread.sleep(2000);
        MobileElement selectAccount = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='4']"));
        selectAccount.click();
         Thread.sleep(1000);
        MobileElement View = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='passbook-account-list-input-button-footer']"));
        View.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='passbook-detail-account-name']")));
      
        Assert.assertTrue(elPassBook.equals("หน้าสมุดบัญชี"));
        Assert.assertTrue(eltitlePassbook.equals("เลือกบัญชีที่คุณต้องการ"));
        Assert.assertTrue(elAccountNickName.equals("บัญชีออลล์ฟรี"));
        Assert.assertTrue(elAccountNumber.equals("XXX-X-XX013-1"));
        Assert.assertTrue(elBranchName.equals("เซ็นทรัลพลาซา พระราม 9"));
        Assert.assertTrue(account_type.equals("SDA"));
        Assert.assertTrue(account_status.equals("ACTIVE"));
    }
}
