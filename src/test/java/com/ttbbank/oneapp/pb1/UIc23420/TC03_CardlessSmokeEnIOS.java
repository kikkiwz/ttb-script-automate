package com.ttbbank.oneapp.pb1.UIc23420;

import com.tmb.automation.pages.pb1.OpenReport;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.pb1.PB1Method;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC03_CardlessSmokeEnIOS extends BaseScenario {

	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
	}

	@Test(groups = {"ios", "PB1"}, description="CardlessSmoke IOS")
	public void cardlessSmoke() throws InterruptedException, IOException {
		log("Start TestCase- " +this.getClass().getSimpleName());
		System.out.println("Start TestCase- " +this.getClass().getSimpleName());
		
		PB1Method pb1 = new PB1Method();
		pb1.setTtbTestContext(getTtbTestContext());
		pb1.ActiveOneAppPB1();
		pb1.EnglishLanguage();
		
		TtbTestContext ttbTestContext = getTtbTestContext();
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).click();
//		enterPin();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_CARDLESS_TITLE);
		String Language = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_TITLE).getText();		
		System.out.println("Cardless Title for store Language-- " + Language);
		Thread.sleep(1000);

		String AccountType = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AC_TYPEA).getText();		
		System.out.println("AccountType-- " + AccountType);
		String FromAccount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FROM_ACA).getText();		
		System.out.println("FromAccount-- " + FromAccount);
		String AccountBalance = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_BALANCEA).getText();		
		System.out.println("AccountBalance-- " + AccountBalance);

		System.out.println("Amount helper1-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXTA).getText());
		Thread.sleep(1000);

		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("222");
		System.out.println("EnterAmount1-- 222.00");
		String EnterAmountError1 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError1-- "+ EnterAmountError1);
		Thread.sleep(1000);
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("20200");
		System.out.println("EnterAmount1-- 20200.00");
		String EnterAmountError2 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError2-- "+ EnterAmountError2);
		Thread.sleep(2000);

		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("18000.00");
		System.out.println("EnterAmount3-- 18000.00");
		String EnterAmountError3 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError3-- "+ EnterAmountError3);
		Thread.sleep(2000);
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_KEYPAD_DONE_EN).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT500).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_NEXT).click();
		
		System.out.println("Confirmation Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_TITLE).getText());
		Thread.sleep(1000);
		
		System.out.println("Withdraw Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_WITHDRAW_TITLE).getText());
		String ConfirmAccountType = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_AC_TYPE).getText();		
		System.out.println("ConfirmAccountType-- " + ConfirmAccountType);
		
		String ConfirmFromAccount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_FROM).getText();		
		System.out.println("ConfirmFromAccount-- " + ConfirmFromAccount);
		
		String TransferAmount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_AMOUNT).getText();		
		System.out.println("TransferAmount-- " + TransferAmount);
		OpenReport.reportBase("Confirm Details Screen");
		
		Thread.sleep(2000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_GENERATE).click();
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_CARDLESS_CONFIRM_PIN_TITLE);
		String PinTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_PIN_TITLE).getText();		
		
		System.out.println("Pin Confirm Title-- " + PinTitle);
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN0).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN1).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN0).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN2).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN0).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN3).click();
		Thread.sleep(5000);
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_CARDLESS_CODE_SUBHEADER);
		System.out.println("Code Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_TITLE).getText());
		Thread.sleep(1000);
		
		String Code = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE).getText();		
		System.out.println("Code-- " + Code);
		Assert.assertNotNull(Code);
		
		String Timer = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_TIMER).getText();		
		System.out.println("Timer-- " + Timer);
		
		String WithdrawAccountType = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_ACCOUNT_TYPE).getText();		
		System.out.println("WithdrawAccountType-- " + WithdrawAccountType);
		
		String CodeAmount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_NO).getText();		
		System.out.println("CodeAmount-- " + CodeAmount);
		
		String GenerateTime = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_GENERATE_TIME).getText();		
		System.out.println("GenerateTime-- " + GenerateTime);
		
		String ExpiryTime = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_EXPIRY_TIME).getText();		
		System.out.println("ExpiryTime-- " + ExpiryTime);
		OpenReport.reportBase("Generate Code Screen");

		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_CARDLESS_CODE_DONE);
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_DONE).click();
		System.out.println("Back to Home Page");

		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_DEACTIVE).click();
		OpenReport.reportBase("Deactivate Pin Message");
		
		Thread.sleep(2000);
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN_OK).click();
		
		Thread.sleep(4000);
		String DeactiveTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_DEACTIVE_TITLE).getText();		
		System.out.println("DeactiveTitle-- " + DeactiveTitle);
		OpenReport.reportBase("Deactivate Pin Screen");
		
//		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_DEACTIVE_DONE).click();

		System.out.println("Done-- ");
		Thread.sleep(2000);
	}

}
