package com.tmb.automation.autoloan;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AutoLoanAccountDetails_iOS_TH {


    public JsonPath accountDetail;
    private ChromeOptions chromeOptions = new ChromeOptions();
    private WebDriver driver ;
    private  String token;
    @BeforeTest
    public void initial() throws InterruptedException, IOException {
        token = AutoloanUtility.genToken("eyJzZXJ2aWNlVHlwZSI6IkFMMDEwMCIsInRpbWVTdGFtcCI6MTYxNDA3OTk0NDk1OCwiYWNjb3VudE51bWJlciI6IjI2NjAwODI5NCIsIm5pY2tOYW1lIjoiSGlyZVB1cmNoYXNlLTgyOTQifQ==");
        String URL = AutoloanUtility.redirectURL(token);
        String filepath = System.getProperty("user.dir") + "/src/main/resources/" + "chromedriver_87" + ".exe";
        System.out.println(filepath);
        System.setProperty("webdriver.chrome.driver", filepath);
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone X");
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        driver = new ChromeDriver(chromeOptions);



        //driver = initializeDriver("chromedriver_87");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);
        driver.getTitle();
        Thread.sleep(3000);
        String Header = driver.findElement(By.xpath("//h1[contains(.,'Auto Loan')]")).getText();

    }

    @Test(description = "Check Auto loan header and back button", priority = 1)
    private void CheckHeader() throws InterruptedException, IOException {

        Thread.sleep(3000);
        String Header = driver.findElement(By.xpath("//h1[contains(.,'Auto Loan')]")).getText();
        Assert.assertEquals(Header, "Auto Loan");
        Boolean BackBTN = driver.findElement(By.xpath("//button[@class='sc-TmcTc cJbABh']")).isDisplayed();
        Assert.assertTrue(BackBTN);
    }

    @Test(description = "Check Progress bar ", priority = 2)
    private void ProgressBar() throws InterruptedException, IOException {


        accountDetail = AutoloanUtility.JsonAccountDetail(token);

        String term = accountDetail.getString("data.response.hpAccountDetail.termspaid");
        System.out.println("Term is " + term);
        String TotalTerm = accountDetail.getString("data.response.hpAccountDetail.totalterms");
        String PaidPeriodValue = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[1]")).getText();
        String PaidPeriodBE = term.replace("0", "") + " period\n" + "No. of Terms Paid";
        Assert.assertEquals(PaidPeriodValue, PaidPeriodBE);
        String TotalTermValue = driver.findElement((By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[3]"))).getText();
        String TotalTermBE = TotalTerm.replace("0", "") + " period\n" + "No. of Total Terms";
        Assert.assertEquals(TotalTermValue, TotalTermBE);
        Boolean ProgressBarDisplayed = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[1]/div/div/div[2]")).isDisplayed();
        Assert.assertTrue(ProgressBarDisplayed);

    }

    @Test(description = "Check Car picture ", priority = 4)
    private void CarPic() throws InterruptedException, IOException {
        Boolean CarPicture = driver.findElement(By.id("al-blue-car-img")).isDisplayed();
        Assert.assertTrue(CarPicture);
    }

    @Test(description = "Check label and value for account detail")
    private void CheckHPAccountdetail() throws InterruptedException, IOException {
        accountDetail = AutoloanUtility.JsonAccountDetail(token);
        Thread.sleep(5000);
        String osbalance = accountDetail.getString("data.response.hpAccountDetail.osbalance");
        Boolean CarLogo = driver.findElement(By.id("al-black-car-img")).isDisplayed();
        Assert.assertTrue(CarLogo);
        String BalanceValue = driver.findElement(By.id("al-remaining-balance-label")).getText();
        String BalanceBE = BalanceValue.substring(0, BalanceValue.length() - 1).replace(",", "").trim();
        Assert.assertEquals(osbalance, BalanceBE);
        String AccountNoValue = driver.findElement(By.id("al-hp-label")).getText();
        String AccountFE = AccountNoValue.replace("-", "").trim();
        System.out.println(AccountFE);
        String contract = accountDetail.getString("data.response.hpAccountDetail.contract");
        Assert.assertEquals(contract, AccountFE);
        String BalanceLabel = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]")).getText();
        Assert.assertEquals(BalanceLabel, "Balance Remaining");
        String HPDetail = driver.findElement(By.id("al-hp-detail-label")).getText();
        Assert.assertEquals(HPDetail, "Hire Purchase Detail");

    }

}
