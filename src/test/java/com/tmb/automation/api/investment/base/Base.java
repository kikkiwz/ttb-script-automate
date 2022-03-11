package com.tmb.automation.api.investment.base;

import com.tmb.automation.api.investment.model.BaseApiModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Base extends ReportInvestment {
    public RequestSpecification httpRequest = RestAssured.given().relaxedHTTPSValidation();
    public static Response responseBody;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest(alwaysRun = true)
    public void BeforeClass() throws MalformedURLException {

        File file = null;
        switch (Setting.BROWSER) {
            case IE:
                browserIe(file);
                break;
            case CHROME:
                browserChrome(file);
                break;
            case FIREFOX:
                break;
            case MICROSOFT_EDGE:
                break;
            case SAFARI:
                break;
            case OPERA:
                break;
//            default:
//                browserIe(file);
//                break;
        }
        if (Setting.BROWSER == Setting.BROWSER_TYPE.NON) return;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    private void browserIe(File file) {
        file = new File(Setting.IE_DRIVER);
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        InternetExplorerOptions capabilityIE = new InternetExplorerOptions();
        capabilityIE.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new InternetExplorerDriver(capabilityIE);
    }

    private void browserChrome(File file) {
        file = new File(Setting.CH_DRIVER);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(capability);
    }

    @AfterTest
    public void AfterClass() {
        extent.flush();
        if (Setting.BROWSER == Setting.BROWSER_TYPE.NON) return;
        driver.quit();
    }


//    @BeforeSuite
//    public void setup() {
//        httpRequest = RestAssured.given().relaxedHTTPSValidation();
//    }

    public void addHeader() {
        httpRequest.header("X-Correlation-ID", UUID.randomUUID());
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Authorization", "Bearer " + Setting.TOKEN);
    }


    public void validateResponseStatus(BaseApiModel responseModel, String code, String message, String service, String description) {
        Assert.assertTrue(responseModel.status.code.equals(code));
        Assert.assertTrue(responseModel.status.message.toLowerCase().equals(message.toLowerCase()));
        Assert.assertTrue(responseModel.status.service.toLowerCase().equals(service.toLowerCase()));
        Assert.assertTrue(responseModel.status.description.toLowerCase().equals(description.toLowerCase()));
    }

}
