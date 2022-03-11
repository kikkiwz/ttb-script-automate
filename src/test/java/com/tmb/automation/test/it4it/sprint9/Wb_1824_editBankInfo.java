/*
 * package com.tmb.automation.test.it4it.sprint9;
 * 
 * import java.io.IOException; import java.util.Map; import
 * java.util.concurrent.TimeUnit;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.testng.Assert; import org.testng.annotations.AfterTest; import
 * org.testng.annotations.BeforeTest; import org.testng.annotations.Test;
 * 
 * import com.tmb.automation.helper.Helper; import
 * com.tmb.automation.pages.web.CCAdmin_bankinfo; import
 * com.tmb.automation.pages.web.editbank_info_page; import
 * com.tmb.automation.util.Base;
 * 
 * public class Wb_1824_editBankInfo extends Base {
 * 
 * public WebDriver driver; Map<String, String> data;
 * 
 * @BeforeTest public void initialize() throws IOException {
 * 
 * driver = initializeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * 
 * }
 * 
 * @Test public void editbankinfo() throws InterruptedException {
 * 
 * 
 * 
 * 
 * //
 * ////////////////////////////////////////////TestData/////////////////////////
 * ////////////////////////////////////////////////// mapData =
 * Helper.testData("TestData_it4it_sp11", this.getClass().getSimpleName());
 * String username = mapData.get("username"); String password =
 * mapData.get("password"); String update_shortname =
 * mapData.get("bankshortname"); String bnakcodetosearch =
 * mapData.get("bankcode"); String displayorder = mapData.get("displayorder");
 * 
 * CCAdmin_bankinfo bankinfo = new CCAdmin_bankinfo(driver);
 * 
 * /////////////////// Login//////////////////////////////////////////
 * driver.get("https://cc-dev1.tmbbank.local");
 * driver.findElement(By.xpath("//button[contains(text(),'     ')]")).click();
 * Thread.sleep(300); driver.findElement(By.
 * xpath("//a[contains(text(),'Proceed to cc-dev1.tmbbank.local (unsafe)')]")).
 * click(); Thread.sleep(300); bankinfo.enter_text(bankinfo.getIn_username(),
 * username); bankinfo.enter_text(bankinfo.getIn_password(), password);
 * bankinfo.click(bankinfo.getBtn_submit());
 * 
 * ///////////////////////////////////////////////////
 * Bankinfopage///////////////////////////////////////////////////////
 * Thread.sleep(300); bankinfo.click(bankinfo.getBtn_Admin());
 * bankinfo.click(bankinfo.getBtn_Bankinfo());
 * 
 * editbank_info_page editbank = new editbank_info_page(driver);
 * editbank.click(editbank.getSort_bankcode()); // String bnakcodetosearch="02";
 * 
 * String shortnamexpath = "//td[@role='cell'][2]//div[contains(.,'" +
 * bnakcodetosearch + "')]//..//..//td[3]//div[1]"; String oldshortname =
 * driver.findElement(By.xpath(shortnamexpath)).getText(); String xpathtoedit =
 * "//td[@role='cell'][2]//div[contains(.,'" + bnakcodetosearch +
 * "')]//..//..//td[9]//div//img";
 * driver.findElement(By.xpath(xpathtoedit)).click();
 * 
 * ///////////////////////////////////////////
 * editbankpage/////////////////////////////////////////////////////////////////
 * /////////////
 * 
 * System.out.println("the old name is " + oldshortname);
 * editbank.enter_text(editbank.getIn_Bankshortname(), update_shortname);
 * editbank.enter_text(editbank.getIn_displayorder(), displayorder);
 * editbank.click(editbank.getbtn_savebank());
 * 
 * //////////////////////// /////////////////////////////bankinfo page to
 * validate the
 * changes///////////////////////////////////////////////////////////
 * bankinfo.click(bankinfo.getBtn_Admin());
 * bankinfo.click(bankinfo.getBtn_Bankinfo());
 * 
 * String newshortname = driver.findElement(By.xpath(shortnamexpath)).getText();
 * 
 * Assert.assertEquals(newshortname, update_shortname,
 * "the short name is not updated ");
 * 
 * }
 * 
 * @AfterTest public void aftertest() { driver.close(); }
 * 
 * }
 */