package com.tmb.automation.test.customerservice.sprint18;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tmb.automation.helper.ExtentListeners;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.helper.Setting;
import com.tmb.automation.util.Base;
import com.tmb.automation.util.TextColor;
import io.appium.java_client.MobileElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.tmb.automation.api.customerservice.sprint18.ApplicationStatusTracking.AST;
import static com.tmb.automation.test.customerservice.sprint17.Base.OpenService;
import static com.tmb.automation.test.customerservice.sprint17.TC_ONEAPP_2712_TH.scrollUPANDDOWN;

public class TC_ONEAPP_4517_EN extends Base {
	@Parameters({"DeviceProfile" })
	@BeforeClass
	public void BeforeTest(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;		
		appiumDriverMobile=Base.appiumCapabilitiesMobileElement();
		 ExtentListeners.setDriver(appiumDriverMobile);
	}

    @Test(priority = 0)
    public void TS_ONEAPP_4517_EN_ASTCardLoan_SIT_01001() throws Exception {
        OpenService();
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-application-tracking']")));
        MobileElement btnAST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-application-tracking']"));
        btnAST.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));

        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
        String elASTHeader = ASTHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
        String elSectionInprogress = SectionInprogress.getText();
        for(int i = 0; i < 7; i++){
            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        }
        MobileElement Title = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_18']");
        Title.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']")));
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_header_label_id']");
        String elProductName = ProductName.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']");
        String elRefNo = RefNo.getText();
        MobileElement CardType = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_id']");
        String elCardType = CardType.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_value_id']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.TextView[1]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.TextView");
        String elNote2 = Note2.getText();
        MobileElement Note3 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.TextView");
        String elNote3 = Note3.getText();
        MobileElement Note4 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.TextView");
        String elNote4 = Note4.getText();
        System.err.println("get element : " + elProductName);
        System.err.println("get element : " + elRefNo);
        System.err.println("get element : " + elCardType);
        System.err.println("get element : " + elCardTypeDetail);
        System.err.println("get element : " + elNote1);
        System.err.println("get element : " + elNote2);
        System.err.println("get element : " + elNote3);
        System.err.println("get element : " + elNote4);

        Assert.assertTrue(elASTHeader.equals("Application Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));

        JSONObject json2 = (JSONObject)new JSONParser().parse(AST("J5GHh44UJnzhXp+OFwye0NoUojlq4Q9CLuswMFmU111TiJrGvTkEm1sHVOcNkKd1+QXIYFxk1lJbo7HqyUnrNzDKPoDDNkmlkEfVH2InkgzVlm+298xYUlnBuiNuv6z/OyXF9WETh3lX0U1Nqn3ktCW4DT8ObKi2tsZmI5jxekmo8R2oqnHMqT+ktYEaw8YlIQwIgE/bG79lZz2Juu/yUYZJV458Kv4v6YH/rhC0tUCBf0JT6VHRxqnqzxBU8S2fC07D8CodDeS+C8Hc4yZB6gTtIL2H2glyVmeqp2sZDschcd7mGWsLLVOl6k3D/xVzO+EheID226tJf6QHWxPqJg==").toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("in_progress");
        System.err.println("length BBB : " +jsonB.size());
        System.err.println("length BBB : " + elRefNo.toString().substring(8, 19));


        for(int i = 0; i < jsonB.size(); i++) {
            JSONObject jsonObjIndexB = (JSONObject) jsonB.get(i);
            if (jsonObjIndexB.get("reference_no").equals(elRefNo.toString().substring(8, 19))) {
//                System.err.println("length BBB : " + elRefNo.toString().substring(8, 21));
                JSONArray jsonInprogress =  (JSONArray)jsonObjIndexB.get("node_text_en");
//                System.err.println("node" + jsonInprogress.size());
                for(int j = 0; j < jsonInprogress.size(); j++) {
                    if(j == 0){
                        Assert.assertTrue(elNote1.equals(jsonInprogress.get(j)));
                    }else if(j == 1){
                        Assert.assertTrue(elNote2.equals(jsonInprogress.get(j)));
                    }else if(j == 2){
                        Assert.assertTrue(elNote3.equals(jsonInprogress.get(j)));
                    }else {
                        Assert.assertTrue(elNote4.equals(jsonInprogress.get(j)));
                    }
                    System.err.println("node" + jsonInprogress.get(j));
                }
            }
        }
    }

    @Test(priority = 1)
    public void TS_ONEAPP_4517_EN_ASTCardLoan_SIT_01002() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='application_status_tracking_detail_back_btn']"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));

        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
        String elASTHeader = ASTHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
        String elSectionInprogress = SectionInprogress.getText();
        for(int i = 0; i < 5; i++){
            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        }
        MobileElement Title = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_16']");
        Title.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']")));
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_header_label_id']");
        String elProductName = ProductName.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']");
        String elRefNo = RefNo.getText();
        MobileElement CardType = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_id']");
        String elCardType = CardType.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_value_id']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.TextView[1]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.TextView");
        String elNote2 = Note2.getText();
        MobileElement Note3 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.TextView");
        String elNote3 = Note3.getText();
        MobileElement Note4 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.TextView");
        String elNote4 = Note4.getText();
        System.err.println("get element : " + elProductName);
        System.err.println("get element : " + elRefNo);
        System.err.println("get element : " + elCardType);
        System.err.println("get element : " + elCardTypeDetail);
        System.err.println("get element : " + elNote1);
        System.err.println("get element : " + elNote2);
        System.err.println("get element : " + elNote3);
        System.err.println("get element : " + elNote4);
        Assert.assertTrue(elASTHeader.equals("Application Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));

        JSONObject json2 = (JSONObject)new JSONParser().parse(AST("J5GHh44UJnzhXp+OFwye0NoUojlq4Q9CLuswMFmU111TiJrGvTkEm1sHVOcNkKd1+QXIYFxk1lJbo7HqyUnrNzDKPoDDNkmlkEfVH2InkgzVlm+298xYUlnBuiNuv6z/OyXF9WETh3lX0U1Nqn3ktCW4DT8ObKi2tsZmI5jxekmo8R2oqnHMqT+ktYEaw8YlIQwIgE/bG79lZz2Juu/yUYZJV458Kv4v6YH/rhC0tUCBf0JT6VHRxqnqzxBU8S2fC07D8CodDeS+C8Hc4yZB6gTtIL2H2glyVmeqp2sZDschcd7mGWsLLVOl6k3D/xVzO+EheID226tJf6QHWxPqJg==").toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("in_progress");
        System.err.println("length BBB : " +jsonB.size());
        System.err.println("length BBB : " + elRefNo.toString().substring(8, 19));


        for(int i = 0; i < jsonB.size(); i++) {
            JSONObject jsonObjIndexB = (JSONObject) jsonB.get(i);
            if (jsonObjIndexB.get("reference_no").equals(elRefNo.toString().substring(8, 19))) {
//                System.err.println("length BBB : " + elRefNo.toString().substring(8, 21));
                JSONArray jsonInprogress =  (JSONArray)jsonObjIndexB.get("node_text_en");
//                System.err.println("node" + jsonInprogress.size());
                for(int j = 0; j < jsonInprogress.size(); j++) {
                    if(j == 0){
                        Assert.assertTrue(elNote1.equals(jsonInprogress.get(j)));
                    }else if(j == 1){
                        Assert.assertTrue(elNote2.equals(jsonInprogress.get(j)));
                    }else if(j == 2){
                        Assert.assertTrue(elNote3.equals(jsonInprogress.get(j)));
                    }else {
                        Assert.assertTrue(elNote4.equals(jsonInprogress.get(j)));
                    }
                    System.err.println("node" + jsonInprogress.get(j));
                }
            }
        }
    }

    @Test(priority = 2)
    public void TS_ONEAPP_4517_EN_ASTCardLoan_SIT_01003() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='application_status_tracking_detail_back_btn']"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));

        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
        String elASTHeader = ASTHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
        String elSectionInprogress = SectionInprogress.getText();
        for(int i = 0; i < 5; i++){
            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        }
        MobileElement Title = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_17']");
        Title.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']")));
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_header_label_id']");
        String elProductName = ProductName.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']");
        String elRefNo = RefNo.getText();
        MobileElement CardType = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_id']");
        String elCardType = CardType.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_value_id']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.TextView[1]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.TextView");
        String elNote2 = Note2.getText();
        MobileElement Note3 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.TextView");
        String elNote3 = Note3.getText();
        MobileElement Note4 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.TextView");
        String elNote4 = Note4.getText();
        System.err.println("get element : " + elProductName);
        System.err.println("get element : " + elRefNo);
        System.err.println("get element : " + elCardType);
        System.err.println("get element : " + elCardTypeDetail);
        System.err.println("get element : " + elNote1);
        System.err.println("get element : " + elNote2);
        System.err.println("get element : " + elNote3);
        System.err.println("get element : " + elNote4);
        Assert.assertTrue(elASTHeader.equals("Application Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));

        JSONObject json2 = (JSONObject)new JSONParser().parse(AST("J5GHh44UJnzhXp+OFwye0NoUojlq4Q9CLuswMFmU111TiJrGvTkEm1sHVOcNkKd1+QXIYFxk1lJbo7HqyUnrNzDKPoDDNkmlkEfVH2InkgzVlm+298xYUlnBuiNuv6z/OyXF9WETh3lX0U1Nqn3ktCW4DT8ObKi2tsZmI5jxekmo8R2oqnHMqT+ktYEaw8YlIQwIgE/bG79lZz2Juu/yUYZJV458Kv4v6YH/rhC0tUCBf0JT6VHRxqnqzxBU8S2fC07D8CodDeS+C8Hc4yZB6gTtIL2H2glyVmeqp2sZDschcd7mGWsLLVOl6k3D/xVzO+EheID226tJf6QHWxPqJg==").toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("in_progress");
        System.err.println("length BBB : " +jsonB.size());
        System.err.println("length BBB : " + elRefNo.toString().substring(8, 19));


        for(int i = 0; i < jsonB.size(); i++) {
            JSONObject jsonObjIndexB = (JSONObject) jsonB.get(i);
            if (jsonObjIndexB.get("reference_no").equals(elRefNo.toString().substring(8, 19))) {
//                System.err.println("length BBB : " + elRefNo.toString().substring(8, 21));
                JSONArray jsonInprogress =  (JSONArray)jsonObjIndexB.get("node_text_en");
//                System.err.println("node" + jsonInprogress.size());
                for(int j = 0; j < jsonInprogress.size(); j++) {
                    if(j == 0){
                        Assert.assertTrue(elNote1.equals(jsonInprogress.get(j)));
                    }else if(j == 1){
                        Assert.assertTrue(elNote2.equals(jsonInprogress.get(j)));
                    }else if(j == 2){
                        Assert.assertTrue(elNote3.equals(jsonInprogress.get(j)));
                    }else {
                        Assert.assertTrue(elNote4.equals(jsonInprogress.get(j)));
                    }
                    System.err.println("node" + jsonInprogress.get(j));
                }
            }
        }
    }

    @Test(priority = 3)
    public void TS_ONEAPP_4517_EN_ASTCardLoan_SIT_01004() throws Exception {
        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
        MobileElement btnBack = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='application_status_tracking_detail_back_btn']"));
        btnBack.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));

        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
        String elASTHeader = ASTHeader.getText();
        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
        String elSectionInprogress = SectionInprogress.getText();
        for(int i = 0; i < 7; i++){
            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
        }
        MobileElement Title = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_0']");
        Title.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']")));
        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_header_label_id']");
        String elProductName = ProductName.getText();
        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']");
        String elRefNo = RefNo.getText();
        MobileElement CardType = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_id']");
        String elCardType = CardType.getText();
        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_value_id']");
        String elCardTypeDetail = CardTypeDetail.getText();
        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.TextView[1]");
        String elNote1 = Note1.getText();
        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.TextView");
        String elNote2 = Note2.getText();
        MobileElement Note3 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.TextView");
        String elNote3 = Note3.getText();
        MobileElement Note4 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.TextView");
        String elNote4 = Note4.getText();
        MobileElement BottomRemark = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View");
        String elBottomRemark = BottomRemark.getText();
        System.err.println("get element : " + elProductName);
        System.err.println("get element : " + elRefNo);
        System.err.println("get element : " + elCardType);
        System.err.println("get element : " + elCardTypeDetail);
        System.err.println("get element : " + elNote1);
        System.err.println("get element : " + elNote2);
        System.err.println("get element : " + elNote3);
        System.err.println("get element : " + elNote4);

        Assert.assertTrue(elASTHeader.equals("Application Tracking"));
        Assert.assertTrue(elSectionInprogress.equals("In Progress"));

        JSONObject json2 = (JSONObject)new JSONParser().parse(AST("J5GHh44UJnzhXp+OFwye0NoUojlq4Q9CLuswMFmU111TiJrGvTkEm1sHVOcNkKd1+QXIYFxk1lJbo7HqyUnrNzDKPoDDNkmlkEfVH2InkgzVlm+298xYUlnBuiNuv6z/OyXF9WETh3lX0U1Nqn3ktCW4DT8ObKi2tsZmI5jxekmo8R2oqnHMqT+ktYEaw8YlIQwIgE/bG79lZz2Juu/yUYZJV458Kv4v6YH/rhC0tUCBf0JT6VHRxqnqzxBU8S2fC07D8CodDeS+C8Hc4yZB6gTtIL2H2glyVmeqp2sZDschcd7mGWsLLVOl6k3D/xVzO+EheID226tJf6QHWxPqJg==").toString());
        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
        JSONArray jsonB =  (JSONArray)jsonObj2.get("in_progress");
        System.err.println("length BBB : " +jsonB.size());
        System.err.println("length BBB : " + elRefNo.toString().substring(8, 19));


        for(int i = 0; i < jsonB.size(); i++) {
            JSONObject jsonObjIndexB = (JSONObject) jsonB.get(i);
            if (jsonObjIndexB.get("reference_no").equals(elRefNo.toString().substring(8, 19))) {
//                System.err.println("length BBB : " + elRefNo.toString().substring(8, 21));
                JSONArray jsonInprogress =  (JSONArray)jsonObjIndexB.get("node_text_en");
                Assert.assertTrue(elBottomRemark.equals(jsonObjIndexB.get("bottom_remark_en")));
//                System.err.println("node" + jsonInprogress.size());
                for(int j = 0; j < jsonInprogress.size(); j++) {
                    if(j == 0){
                        Assert.assertTrue(elNote1.equals(jsonInprogress.get(j)));
                    }else if(j == 1){
                        Assert.assertTrue(elNote2.equals(jsonInprogress.get(j)));
                    }else if(j == 2){
                        Assert.assertTrue(elNote3.equals(jsonInprogress.get(j)));
                    }else {
                        Assert.assertTrue(elNote4.equals(jsonInprogress.get(j)));
                    }
                    System.err.println("node" + jsonInprogress.get(j));
                }
            }
        }
    }
//
//    @Test(priority = 4)
//    public void TS_ONEAPP_4516_EN_ASTCardLoan_SIT_10008() throws Exception {
//        OpenService();
//        WebDriverWait wait = new WebDriverWait(appiumDriverMobile, 40);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='service-screen-button-application-tracking']")));
//        MobileElement btnAST = appiumDriverMobile.findElement(By.xpath("//*[@resource-id='service-screen-button-application-tracking']"));
//        btnAST.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_tracking_label_type_header_label_id']")));
//
//        MobileElement ASTHeader = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_tracking_label_type_header_label_id']");
//        String elASTHeader = ASTHeader.getText();
//        MobileElement SectionInprogress = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_label_in_progress_id']");
//        String elSectionInprogress = SectionInprogress.getText();
//        for(int i = 0; i < 7; i++){
//            scrollUPANDDOWN(0.5, 0.8, 0.5, 0.2); // down
//        }
//        MobileElement Title = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='title_18']");
//        Title.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']")));
//        MobileElement ProductName = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_header_label_id']");
//        String elProductName = ProductName.getText();
//        MobileElement RefNo = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_card_ref_no_id']");
//        String elRefNo = RefNo.getText();
//        MobileElement CardType = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_id']");
//        String elCardType = CardType.getText();
//        MobileElement CardTypeDetail = (MobileElement) appiumDriverMobile.findElementByXPath("//*[@resource-id='application_status_tracking_detail_product_type_value_id']");
//        String elCardTypeDetail = CardTypeDetail.getText();
//        MobileElement Note1 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View/android.widget.TextView[1]");
//        String elNote1 = Note1.getText();
//        MobileElement Note2 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.widget.TextView");
//        String elNote2 = Note2.getText();
//        MobileElement Note3 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.widget.TextView");
//        String elNote3 = Note3.getText();
//        MobileElement Note4 = (MobileElement) appiumDriverMobile.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.widget.TextView");
//        String elNote4 = Note4.getText();
//        System.err.println("get element : " + elProductName);
//        System.err.println("get element : " + elRefNo);
//        System.err.println("get element : " + elCardType);
//        System.err.println("get element : " + elCardTypeDetail);
//        System.err.println("get element : " + elNote1);
//        System.err.println("get element : " + elNote2);
//        System.err.println("get element : " + elNote3);
//        System.err.println("get element : " + elNote4);
//
//
//        if(true){
//            parentReport = extent.createTest("TS_ONEAPP_4516_EN", "TS_ONEAPP_4516_EN");
//        }
//        childReport = parentReport.createNode("TS_ONEAPP_4516_ASTCard&Loan_SIT_10002");
//        childReport.log(Status.INFO, "<pre>Expected Result :  1. The system should displays Application status tracking details as below\n" +
//                "- Display Back Icon, If pressing to the Back Icon ,the system will display Application Status Tracking Screen.\n" +
//                "- Display Product Name.\n" +
//                "- Display Card face.\n" +
//                "- Display Referent Id.\n" +
//                "- Display Card Type.\n" +
//                "- Display Card Type Detail.\n" +
//                "- Display Progress Indicator and show the latest status.\n" +
//                "- Display All of the Status as sent by the API and show the latest status.\n" +
//                "- The first status will show a start date. Format Date: 1 เม.ย. 63 (TH)  and 1 Apr 20 (EN).\n" +
//                "- The final status if the card status completed, the system will show a completed date. Format Date: 1 เม.ย. 63 (TH)  and 1 Apr 20 (EN).\n" +
//                "- Display Help Center.\n" +
//                "2. The system should display Remark 1 that sent from API in yellow message box under current node\n" +
//                "3. The system should display Remark 2 that sent from API in gray message box above footer.</pre>");
//        childReport.pass("1. The system should display In Progress Application cards correctly under In Progress section.\n" +
//                "- Display Status Icon Color.\n" +
//                "  > Green = In progress\n </pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//        childReport.log(Status.INFO, "<pre>Actual result : Display Product name : " + TextColor.blueColor(elProductName)
//                + "</br>Display Referent Id : " + TextColor.blueColor(elRefNo)
//                + "</br>Display Card Type : " + TextColor.blueColor(elCardType)
//                + "</br>Display Card Type Detail : " + TextColor.blueColor(elCardTypeDetail)
//                + "</br>Display All of the Status as sent by the API and show the latest status : " + TextColor.blueColor(elNote1)
//                + "</br>" + TextColor.blueColor(elNote2) + "</br>" + TextColor.blueColor(elNote3) + "</br>" + TextColor.blueColor(elNote4)
//                + "</pre>");
//        childReport.pass("<pre>2. The system should display Completed Application cards correctly under Completed section.\n" +
//                "- Display Status Icon Color.\n" +
//                "  > Gray = Done</pre>" + TextColor.greenColor(Setting.RESULT_TYPE.PASS.toString()), MediaEntityBuilder.createScreenCaptureFromBase64String(Base.TakeScreen()).build());
//
//        Assert.assertTrue(elASTHeader.equals("Application Tracking"));
//        Assert.assertTrue(elSectionInprogress.equals("In Progress"));
//
//        JSONObject json2 = (JSONObject)new JSONParser().parse(AST("J5GHh44UJnzhXp+OFwye0NoUojlq4Q9CLuswMFmU111TiJrGvTkEm1sHVOcNkKd1+QXIYFxk1lJbo7HqyUnrNzDKPoDDNkmlkEfVH2InkgzVlm+298xYUlnBuiNuv6z/OyXF9WETh3lX0U1Nqn3ktCW4DT8ObKi2tsZmI5jxekmo8R2oqnHMqT+ktYEaw8YlIQwIgE/bG79lZz2Juu/yUYZJV458Kv4v6YH/rhC0tUCBf0JT6VHRxqnqzxBU8S2fC07D8CodDeS+C8Hc4yZB6gTtIL2H2glyVmeqp2sZDschcd7mGWsLLVOl6k3D/xVzO+EheID226tJf6QHWxPqJg==").toString());
//        JSONObject jsonObj2 =  (JSONObject)json2.get("data");
//        JSONArray jsonB =  (JSONArray)jsonObj2.get("in_progress");
//        System.err.println("length BBB : " +jsonB.size());
//        System.err.println("length BBB : " + elRefNo.toString().substring(8, 19));
//
//
//        for(int i = 0; i < jsonB.size(); i++) {
//            JSONObject jsonObjIndexB = (JSONObject) jsonB.get(i);
//            if (jsonObjIndexB.get("reference_no").equals(elRefNo.toString().substring(8, 19))) {
////                System.err.println("length BBB : " + elRefNo.toString().substring(8, 21));
//                JSONArray jsonInprogress =  (JSONArray)jsonObjIndexB.get("node_text_en");
////                System.err.println("node" + jsonInprogress.size());
//                for(int j = 0; j < jsonInprogress.size(); j++) {
//                    if(j == 0){
//                        Assert.assertTrue(elNote1.equals(jsonInprogress.get(j)));
//                    }else if(j == 1){
//                        Assert.assertTrue(elNote2.equals(jsonInprogress.get(j)));
//                    }else if(j == 2){
//                        Assert.assertTrue(elNote3.equals(jsonInprogress.get(j)));
//                    }else {
//                        Assert.assertTrue(elNote4.equals(jsonInprogress.get(j)));
//                    }
//                    System.err.println("node" + jsonInprogress.get(j));
//                }
//            }
//        }
//    }
}
