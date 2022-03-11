package com.ttbbank.oneapp.pb1.UIc25481;

import com.tmb.automation.pages.pb1.OpenReport;
import com.ttbbank.oneapp.framework.BaseScenario;
import com.ttbbank.oneapp.framework.OneAppElementKeys;
import com.ttbbank.oneapp.framework.TtbTestContext;
import com.ttbbank.oneapp.framework.utils.pb1.PB1Method;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC12_CardlessFromHomeThIOS extends BaseScenario {

	@Parameters("DeviceProfile")
	@BeforeTest(alwaysRun = true)
	public void BeforeTest(String deviceProfile) {
		testWithDeviceProfile(deviceProfile);
	}

	@Test(groups = {"ios", "PB1"}, description="CardlessFromHome IOS")
	public void cardlessFromHome() throws InterruptedException, IOException {
		log("Start TestCase- " +this.getClass().getSimpleName());
		System.out.println("Start TestCase- " +this.getClass().getSimpleName());
		
		PB1Method pb1 = new PB1Method();
		pb1.setTtbTestContext(getTtbTestContext());
		pb1.ActiveOneAppPB1();
		pb1.ThaiLanguage();
		
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

		String EnterAmountError = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXTA).getText();
		System.out.println("Amount helper1-- "+ EnterAmountError);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(EnterAmountError, "The amount must be divisible by 100.");
		} else {
			Assert.assertEquals(EnterAmountError, "ต้องเป็นจำนวนที่หารด้วย 100 ลงตัว");
		}

		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("222");
		System.out.println("EnterAmount1-- 222.00");
		String EnterAmountError1 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError1-- "+ EnterAmountError1);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(EnterAmountError1, "The amount must not exceed more than 20,000 Baht and must be divisible by 100");
		} else {
			Assert.assertEquals(EnterAmountError1, "คุณสามารถถอนเงินได้ครั้งละ 100 ถึง 20,000 บาท");
		}
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("20200");
		System.out.println("EnterAmount2-- 20200.00");
		String EnterAmountError2 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError2-- "+ EnterAmountError2);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(EnterAmountError2, "The amount must not exceed more than 20,000 Baht and must be divisible by 100");
			} else {
			Assert.assertEquals(EnterAmountError2, "คุณสามารถถอนเงินได้ครั้งละ 100 ถึง 20,000 บาท");
		}

		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).clear();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_FIELD).sendKeys("18000.00");
		System.out.println("EnterAmount3-- 18000.00");
		String EnterAmountError3 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_FIELD_HELP_TEXT1A).getText();
		System.out.println("EnterAmountError3-- "+ EnterAmountError3);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(EnterAmountError3, "Insufficient money to withdraw.");
			} else {
			Assert.assertEquals(EnterAmountError3, "จำนวนเงินไม่เพียงพอต่อการถอน");
		}
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_KEYPAD_DONE_EN).click();

		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT100).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT300).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT500).click();
		
		Thread.sleep(1000);
		Dimension size = ttbTestContext.getDriver().manage().window().getSize();
		int Height = size.getHeight();
	    int Width = size.getWidth();
        System.out.println("ScreenSize- "+size +", Width- "+ Width +", Height- " + Height);
		
		@SuppressWarnings("rawtypes")
		TouchAction action = new TouchAction(ttbTestContext.getDriver());
		action.press(PointOption.point(Width-500, Height-500))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(Width-500, 500)).release().perform();
		Thread.sleep(1000);
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT900).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT1000).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT2000).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT3000).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT4000).click();
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_SELECT_AMOUNT5000).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_NEXT).click();
		
		System.out.println("Confirmation Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_TITLE).getText());
		Thread.sleep(1000);
		System.out.println("Withdraw Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_WITHDRAW_TITLE).getText());
		String ConfirmAccountType = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_AC_TYPE).getText();		
		System.out.println("ConfirmAccountType-- " + ConfirmAccountType);
		Assert.assertEquals(AccountType, ConfirmAccountType);
		
		String ConfirmFromAccount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_FROM).getText();		
		System.out.println("ConfirmFromAccount-- " + ConfirmFromAccount);
		Assert.assertEquals(FromAccount, ConfirmFromAccount);
		
		System.out.println("Amount Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_AMOUNT_TITLE).getText());
		String TransferAmount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_AMOUNT).getText();		
		System.out.println("TransferAmount-- " + TransferAmount);
		Assert.assertEquals("5,000.00", TransferAmount);
		
		String ConfirmationBanner1  = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_BANNER1).getText();		
		System.out.println("ConfirmationBanner1-- " + ConfirmationBanner1);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(ConfirmationBanner1, "You will receive the withdrawal PIN to withdraw cash at any ttb ATM machine.");
		} else {
			Assert.assertEquals(ConfirmationBanner1, "คุณจะได้รับรหัส เพื่อนำไปถอนเงินสดที่ตู้ ATM ของทีทีบีได้ทุกแห่ง");
		}
		
		String ConfirmationBanner2 = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CONFIRM_BANNER2).getText();		
		System.out.println("ConfirmationBanner2-- " + ConfirmationBanner2);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(ConfirmationBanner2, "The code can only be used once and will expire in 30 minutes.");
		} else {
			Assert.assertEquals(ConfirmationBanner2, "รหัสมีอายุ 30 นาที และใช้ได้เพียงครั้งเดียว");
		}
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
		System.out.println("Pin Title-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_PIN_TITLE).getText());
		String Code = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE).getText();		
		System.out.println("Code-- " + Code);
		Assert.assertNotNull(Code);
		
		String Timer = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_TIMER).getText();		
		System.out.println("Timer-- " + Timer);
		Assert.assertNotNull(Timer);
		
		String SubTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_SUBHEADER).getText();		
		System.out.println("SubTitle-- " + SubTitle);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(SubTitle, "Can be used only once at ATM machine. Withdrawal PIN will expire in 30 minutes.");
		} else {
			Assert.assertEquals(SubTitle, "รหัสมีอายุ 30 นาที และใช้ได้เพียงครั้งเดียวที่ตู้ ATM ทีทีบี ทุกแห่ง");
		}
		
		System.out.println("Withdraw-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_WITHDRAW_FROM).getText());
		String WithdrawAccountType = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_ACCOUNT_TYPE).getText();		
		System.out.println("WithdrawAccountType-- " + WithdrawAccountType);
		Assert.assertEquals(ConfirmAccountType, WithdrawAccountType);
		
		System.out.println("CodeTitle-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT).getText());
		String CodeAmount = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_AMOUNT_NO).getText();		
		System.out.println("CodeAmount-- " + CodeAmount);
		Assert.assertEquals("5000.00", CodeAmount);
		
		System.out.println("Generate-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_GENERATE).getText());
		String GenerateTime = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_GENERATE_TIME).getText();		
		System.out.println("GenerateTime-- " + GenerateTime);
		Assert.assertNotNull(GenerateTime);
		
		System.out.println("Expiry-- "+ ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_EXPIRY).getText());
		String ExpiryTime = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_EXPIRY_TIME).getText();		
		System.out.println("ExpiryTime-- " + ExpiryTime);
		Assert.assertNotNull(GenerateTime);
		OpenReport.reportBase("Generate Code Screen");
		
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_CARDLESS_CODE_DONE);
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_DONE).click();
		System.out.println("Back to Home Page");
				  
		ttbTestContext.waitUntilVisible(OneAppElementKeys.PB1_WITHDRAW);
		ttbTestContext.findElement(OneAppElementKeys.PB1_WITHDRAW).click();
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_CODE_DEACTIVE).click();
		
		String PinExpireTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN_EXPIRE_TITLE_HOME).getText();		
		System.out.println("PinExpireTitle-- " + PinExpireTitle);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(PinExpireTitle, "Are you sure to deactivate this withdrawal PIN?");
		} else {
			Assert.assertEquals(PinExpireTitle, "คุณต้องการออกจากขั้นตอนการสร้างรหัส PIN ถอนเงินใช่หรือไม่?");
		}
		Thread.sleep(2000);
		OpenReport.reportBase("Deactivate Pin Message");
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_PIN_OK).click();
		
		Thread.sleep(4000);
		String DeactiveTitle = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_DEACTIVE_TITLE).getText();		
		System.out.println("DeactiveTitle-- " + DeactiveTitle);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(DeactiveTitle, "The withdrawal PIN is deactivated.");
		} else {
			Assert.assertEquals(DeactiveTitle, "รหัสถอนเงินสดได้ถูกยกเลิกแล้ว");
		}
		
		String DeactiveMessage = ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_DEACTIVE_MESSAGE).getText();		
		System.out.println("DeactiveMessage-- " + DeactiveMessage);
		if (Language.equals("Cardless Withdrawal")) {
			Assert.assertEquals(DeactiveMessage, "You can now generate a new withdrawal PIN");
		} else {
			Assert.assertEquals(DeactiveMessage, "คุณสามารถขอรับรหัสถอนเงินใหม่อีกครั้งได้ทันที");
		}
		Thread.sleep(2000);
		OpenReport.reportBase("Deactivate Pin Screen");
		
		ttbTestContext.findElement(OneAppElementKeys.PB1_CARDLESS_DEACTIVE_DONE).click();
		
		System.out.println("Done-- ");
		Thread.sleep(2000);
	}

}
