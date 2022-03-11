package com.tmb.automation.test.pb1.UI.T3350;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.pages.pb1.PB1LoginAndroid_PO;
import com.tmb.automation.pages.pb1.PB1PinAndroid;
import com.tmb.automation.pages.pb1.transfer.PB1TransferAndroidPO;
import com.tmb.automation.util.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/* Android Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class TC04_FromTDToOwnTTBTest extends Base {

	@Parameters({ "DeviceProfile" })
	@BeforeMethod(groups = { "android", "PB1" })
	public void BeforeTest(String deviceProfile) throws InterruptedException, IOException {
		Helper.CONFIG_PROFILE = deviceProfile;
		mapData = Helper.getExcelData("TestData_pb1", "UIAutomation", "Account");
		Base.appiumCapabilities();
		PB1PinAndroid.Login(); // Call login method
	}

	@AfterMethod(groups = { "android", "PB1" })
	public void teardown() {
		System.out.println("///////////////Method Completed////////////");
	}

	@Test(groups = { "android", "PB1" }, description = "TransferFromTDToOwnTTBTest")
	public void Test001() throws InterruptedException, IOException {
		log("------------Start--- : " + this.getClass().getSimpleName());

		PB1TransferAndroidPO pb1 = new PB1TransferAndroidPO(appiumDriver);
		PB1LoginAndroid_PO ps = new PB1LoginAndroid_PO(appiumDriver);

		ps.Service().click();
		pb1.GoToNative().click();
		pb1.OwnTTB().click();

		pb1.OwnTTBAc().click();
		Thread.sleep(2000);

		TouchAction action = new TouchAction(appiumDriver);
		String TDAC = map("TD");
		System.out.println("-------TDAC-------- : " + TDAC);

		for (int i = 0; i < 15; i++) {
			String FromAc = pb1.FromAc().getText();
			System.out.println("-------FromAc-------- : " + FromAc);
			Thread.sleep(2000);

			if (FromAc.equals(TDAC)) {
				i = 16;
				break;
			} else {
				action.press(PointOption.point(1000, 600)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(100, 600)).release().perform();
				Thread.sleep(2000);
			}
		}

		String Note = "TD Transfer";
		pb1.Note().sendKeys(Note);
		Thread.sleep(2000);

		action.press(PointOption.point(200, 950)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(200, 450)).release().perform();
		Thread.sleep(2000);

		pb1.category().click();
		Thread.sleep(2000);

		pb1.TransferNext().click();

		String ReviewFromAc = pb1.ReviewFromAc().getText();
		System.out.println("-------ReviewFromAc-------- : " + ReviewFromAc);

		String ReviewToAc = pb1.ReviewToAc().getText();
		System.out.println("-------ReviewToAc-------- : " + ReviewToAc);

		String ReviewPrincipalTD = pb1.PrincipalTD().getText();
		System.out.println("-------ReviewPrincipalTD-------- : " + ReviewPrincipalTD);

		String ReviewPenaltyTD = pb1.PenaltyTD().getText();
		System.out.println("-------ReviewPenaltyTD-------- : " + ReviewPenaltyTD);

		String ReviewInterestTD = pb1.InterestTD().getText();
		System.out.println("-------ReviewInterestTD-------- : " + ReviewInterestTD);

		String ReviewTaxTD = pb1.TaxTD().getText();
		System.out.println("-------ReviewTaxTD-------- : " + ReviewTaxTD);

		String ReviewNetTD = pb1.NetTD().getText();
		System.out.println("-------ReviewNetTD-------- : " + ReviewNetTD);

		String ReviewFeeTD = pb1.ReviewFeeTD().getText();
		System.out.println("-------ReviewFeeTD-------- : " + ReviewFeeTD);

		Thread.sleep(2000);
		pb1.TransferConfirm().click();
		Thread.sleep(2000);

		String SuccessFromAc = pb1.SuccessFromAc().getText();
		System.out.println("-------SuccessFromAc-------- : " + SuccessFromAc);
		Assert.assertEquals(SuccessFromAc, ReviewFromAc, "From Ac validated");

		String SuccessToAc = pb1.SuccessToAc().getText();
		System.out.println("-------SuccessToAc-------- : " + SuccessToAc);
		Assert.assertEquals(SuccessToAc, ReviewToAc, "To Ac validated");

		String SuccessNote = pb1.SuccessNote().getText();
		System.out.println("-------SuccessNote-------- : " + SuccessNote);
		String SuccessNote1[] = SuccessNote.split(": ");
		String SuccessNote2 = SuccessNote1[1];
		System.out.println("-------SuccessNote2-------- : " + SuccessNote2);
		Assert.assertEquals(SuccessNote1[1], Note, "Note validated");

		String SuccessCategory = pb1.SuccessCategory().getText();
		System.out.println("-------SuccessCategory-------- : " + SuccessCategory);

		String SuccessPrincipalTD = pb1.SuccessPrincipalTD().getText();
		System.out.println("-------SuccessPrincipalTD-------- : " + SuccessPrincipalTD);
		Assert.assertEquals(SuccessPrincipalTD, ReviewPrincipalTD, "PrincipalTD validated");

		String SuccessPenaltyTD = pb1.SuccessPenaltyTD().getText();
		System.out.println("-------SuccessPenaltyTD-------- : " + SuccessPenaltyTD);
		Assert.assertEquals(SuccessPenaltyTD, ReviewPenaltyTD, "PenaltyTD validated");

		String SuccessInterestTD = pb1.SuccessInterestTD().getText();
		System.out.println("-------SuccessInterestTD-------- : " + SuccessInterestTD);
		Assert.assertEquals(SuccessInterestTD, ReviewInterestTD, "InterestTD validated");

		String SuccessTaxTD = pb1.SuccessTaxTD().getText();
		System.out.println("-------SuccessTaxTD-------- : " + SuccessTaxTD);
		Assert.assertEquals(SuccessTaxTD, ReviewTaxTD, "TaxTD validated");

		String SuccessNetTD = pb1.SuccessNetTD().getText();
		System.out.println("-------SuccessNetTD-------- : " + SuccessNetTD);
		Assert.assertEquals(SuccessNetTD, ReviewNetTD, "NetTD validated");

		String SuccessFeeTD = pb1.SuccessFeeTD().getText();
		System.out.println("-------SuccessFeeTD-------- : " + SuccessFeeTD);
		Assert.assertEquals(SuccessFeeTD, ReviewFeeTD, "FeeTD validated");

		String Reference = pb1.Reference().getText();
		System.out.println("-------Reference-------- : " + Reference);
		String Reference1[] = Reference.split(": ");
		String Reference2 = Reference1[1];
		System.out.println("-------Reference2-------- : " + Reference2);

		action.press(PointOption.point(200, 950)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(200, 250)).release().perform();

		Thread.sleep(3000);
		System.out.println("///////////////Step Completed////////////");
	}

}
