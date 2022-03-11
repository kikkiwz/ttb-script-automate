/*
 * package com.tmb.automation.test.it4it.sprint9;
 * 
 * import java.io.IOException; import java.util.List; import java.util.Map;
 * import java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.JavascriptExecutor;
 * import org.openqa.selenium.WebDriver; import org.openqa.selenium.WebElement;
 * import org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import org.testng.Assert;
 * import org.testng.annotations.AfterTest; import
 * org.testng.annotations.BeforeTest; import org.testng.annotations.Test;
 * 
 * import com.tmb.automation.helper.ExtentListeners; import
 * com.tmb.automation.helper.Helper; import
 * com.tmb.automation.pages.web.CCAdmin_bankinfo; import
 * com.tmb.automation.util.Base;
 * 
 * public class Wb_1824_CreatBankinfo_TC1 extends Base {
 * 
 * public WebDriver driver; Map<String, String> data;
 * 
 * @BeforeTest public void initialize() throws IOException {
 * 
 * // data=getexceldata("login"); // mapData = Helper.testData("group_eribank",
 * this.getClass().getSimpleName()); driver = initializeDriver();
 * ExtentListeners.setDriver(driver); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * 
 * }
 * 
 * @Test public void creatbankinfo() throws InterruptedException
 * 
 * {
 * 
 * mapData = Helper.testData("TestData_it4it_sp11",
 * this.getClass().getSimpleName());
 * 
 * driver.get("https://cc-dev1.tmbbank.local");
 * 
 * driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();
 * Thread.sleep(300); driver.findElement(By.
 * xpath("//a[contains(text(),'Proceed to cc-dev1.tmbbank.local (unsafe)')]")).
 * click(); Thread.sleep(300);
 * 
 * // creat the object to access pages and library Thread.sleep(300);
 * 
 * CCAdmin_bankinfo bankinfo = new CCAdmin_bankinfo(driver);
 * 
 * // entering usrer name and passwpord
 * bankinfo.enter_text(bankinfo.getIn_username(), "f2f149");
 * bankinfo.enter_text(bankinfo.getIn_password(), "P@ss12345");
 * 
 * // login bankinfo.click(bankinfo.getBtn_submit());
 * 
 * Thread.sleep(300); String codevalue = "55"; /// create new bank info
 * bankinfo.click(bankinfo.getBtn_Admin());
 * bankinfo.click(bankinfo.getBtn_Bankinfo());
 * bankinfo.click(bankinfo.getBtn_creatnewbank());
 * bankinfo.enter_text(bankinfo.getIn_banknameEN(),
 * mapData.get("Bankname_Eng"));
 * bankinfo.enter_text(bankinfo.getIn_banknameTH(), "TestB");
 * bankinfo.enter_text(bankinfo.getIn_bankShortname(), "test");
 * bankinfo.enter_text(bankinfo.getIn_bankcd(), codevalue);
 * bankinfo.select_by_value(bankinfo.getSel_promptpayStatus(), "Available");
 * bankinfo.enter_text(bankinfo.getIn_Accountlength(), "10");
 * bankinfo.enter_text(bankinfo.getIn_displayorder(), "2");
 * bankinfo.enter_text(bankinfo.getIn_Effectivedate(), "10102018");
 * bankinfo.enter_text(bankinfo.getIn_Expiredate(), "10102022");
 * bankinfo.click(bankinfo.getBtn_Bankinfo());
 * bankinfo.enter_text(bankinfo.getIn_orfteffectivedate(), "10102018");
 * bankinfo.enter_text(bankinfo.getIn_orftexpiredate(), "10102020");
 * bankinfo.enter_text(bankinfo.getIn_samarteffectivedate(), "10102018");
 * bankinfo.enter_text(bankinfo.getIn_smartexpiredate(), "10102020");
 * bankinfo.click(bankinfo.getBtn_Bankinfo());
 * bankinfo.enter_text(bankinfo.getUpload_chosebanklogo(),
 * "C:\\Users\\Admin\\Documents\\automation-testing\\Automation_Testing\\testdata\\logo_Image\\tmb logo.png"
 * ); Thread.sleep(300); bankinfo.click(bankinfo.getbtn_uploadbanklogo());
 * Thread.sleep(16000); WebDriverWait wait = new WebDriverWait(driver, 20);
 * wait.until(ExpectedConditions.elementToBeClickable(bankinfo.getbtn_savebank()
 * ));
 * 
 * bankinfo.click(bankinfo.getBtn_Bankinfo()); Thread.sleep(1200);
 * bankinfo.click(bankinfo.getbtn_savebank());
 * 
 * String value =
 * driver.findElement(By.xpath("//span[@class='sc-irlOZD jUdyne']")).getText();
 * char a = value.charAt(5); System.out.println("The character is " + a); int
 * pagecount = a;
 * 
 * String code = "//tr[@class='sc-cbDGPM eTEuVf']//td[2]//div" + "[contains(.,'"
 * + codevalue + "')]";
 * 
 * WebElement code_elment = driver.findElement(By.xpath(code));
 * Assert.assertEquals(true, code_elment.isDisplayed());
 * 
 * }
 * 
 * @AfterTest public void aftertest() { driver.close(); }
 * 
 * }
 */