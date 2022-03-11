package com.tmb.automation.test.pb1.UI.T9257;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

public class TC07_OtherBankNoPinTest extends Base {

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

	@DataProvider
	public Object[][] getExcelData() throws IOException {
		Object Data[][] = Helper.testadataDataprovider("TestData_pb1", "OtherBank");
		return Data;
	}

	@Test(groups = { "android", "PB1" }, dataProvider = "getExcelData", description = "Other Bank Transfer")
	public void Test001(String aa1, String bb1, String cc1) throws InterruptedException, IOException {
		log("------------Start--- : "+this.getClass().getSimpleName());
		
		PB1TransferAndroidPO pb1=new PB1TransferAndroidPO(appiumDriver); 
		PB1LoginAndroid_PO ps=new PB1LoginAndroid_PO(appiumDriver);

		ps.Service().click();
		pb1.GoToNative().click();
		pb1.Other().click();
			
		pb1.OtherAc().click();
		Thread.sleep(2000);

		String toAccountNo = aa1; // Get data from DataProvider
		String toBankCode = bb1;
		System.out.println("--------------toAccountNo-----------" + toAccountNo);
		System.out.println("--------------toBankCode------------" + toBankCode);
		log("------------toAccountNo--- : " + toAccountNo);
		log("------------toBankCode--- : " + toBankCode);

		if (toBankCode.equals("02")) {
			pb1.SelectBBL().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("04")) {
			pb1.SelectKBank().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("14")) {
			pb1.SelectSCB().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("25")) {
			pb1.SelectBAY().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("06")) {
			pb1.SelectKTB().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("69")) {
			pb1.SelectKKP().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("24")) {
			pb1.SelectUOBT().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("31")) {
			pb1.SelectHSBC().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("17")) {
			pb1.SelectCITI().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("18")) {
			pb1.SelectSMBC().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("30")) {
			pb1.SelectGSB().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("32")) {
			pb1.SelectDEUTSHE().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("34")) {
			pb1.SelectBAAC().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("39")) {
			pb1.SelectMHBK().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("65")) {
			pb1.SelectTBANK().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("67")) {
			pb1.SelectTISCO().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("70")) {
			pb1.SelectICBC().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("71")) {
			pb1.SelectTCRB().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("73")) {
			pb1.SelectLHBank().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("52")) {
			pb1.SelectBOC().click();
			Thread.sleep(2000);
		} else if (toBankCode.equals("79")) {
			pb1.SelectANZ().click();
			Thread.sleep(2000);
		} else {
			System.out.println("----------- Wrong Bank Code, Try again with correct Bank Code ---------");
		}

		TouchAction action = new TouchAction(appiumDriver);
		String sdaAC = map("SDA");
		System.out.println("-------sdaAC-------- : " + sdaAC);

		for (int i = 0; i < 10; i++) {
			String FromAc = pb1.FromAc().getText();
			System.out.println("-------FromAc-------- : " + FromAc);
			Thread.sleep(2000);

			if (FromAc.equals(sdaAC)) {
				i = 11;
				break;
			} else {
				action.press(PointOption.point(1000, 600)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
						.moveTo(PointOption.point(100, 600)).release().perform();
				Thread.sleep(2000);
			}
		}

		String OldBalance = pb1.OldBalance().getText();
		System.out.println("-------OldBalance-------- : " + OldBalance);
		String OldBalance1 = OldBalance.replaceAll(",", "");
		System.out.println("-------OldBalance1-------- : " + OldBalance1);
		Thread.sleep(2000);

		pb1.EnterAc().sendKeys(toAccountNo);
		Thread.sleep(2000);
		appiumDriver.hideKeyboard();

		pb1.AmountField().click();
		pb1.TypeAmount().sendKeys("13.13");
		Thread.sleep(2000);
		appiumDriver.hideKeyboard();

		Thread.sleep(2000);
		action.press(PointOption.point(200, 950)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(200, 400)).release().perform();
		Thread.sleep(2000);

		String Note = "Personal Note";
		pb1.Note().sendKeys(Note);
		appiumDriver.hideKeyboard();

		pb1.category().click();

		pb1.TransferNext().click();

		String ReviewFromAc = pb1.ReviewFromAc().getText();
		System.out.println("-------ReviewFromAc-------- : " + ReviewFromAc);

		String ReviewToAc = pb1.ReviewToAc().getText();
		System.out.println("-------ReviewToAc-------- : " + ReviewToAc);

		String ReviewAmount = pb1.ReviewAmount().getText();
		System.out.println("-------ReviewAmount-------- : " + ReviewAmount);

		String ReviewFee = pb1.ReviewFee().getText();
		System.out.println("-------ReviewFee-------- : " + ReviewFee);
		Thread.sleep(2000);

		pb1.TransferConfirm().click();
		Thread.sleep(2000);

		try {
			PB1PinAndroid.LoginTransfer(); // Call login method
			System.out.println("-------Pin Login Enable------");
		} catch (Exception e) {
			System.out.println("-------Pin Login ByPass------");
		}

		Thread.sleep(2000);

		String SuccessFromAc = pb1.SuccessFromAc().getText();
		System.out.println("-------SuccessFromAc-------- : " + SuccessFromAc);
		Assert.assertEquals(SuccessFromAc, ReviewFromAc, "From Ac validated");

		String SuccessToAc = pb1.SuccessToAc().getText();
		System.out.println("-------SuccessToAc-------- : " + SuccessToAc);
		Assert.assertEquals(SuccessToAc, ReviewToAc, "To Ac validated");

		String SuccessAmount = pb1.SuccessAmount().getText();
		System.out.println("-------SuccessAmount-------- : " + SuccessAmount);
		Assert.assertEquals(SuccessAmount, ReviewAmount, "Amount validated");

		String SuccessFee = pb1.SuccessFee().getText();
		System.out.println("-------SuccessFee-------- : " + SuccessFee);
		Assert.assertEquals(SuccessFee, ReviewFee, "Fee validated");

		String SuccessNote = pb1.SuccessNote().getText();
		System.out.println("-------SuccessNote-------- : " + SuccessNote);
		String SuccessNote1[] = SuccessNote.split(": ");
		String SuccessNote2 = SuccessNote1[1];
		System.out.println("-------SuccessNote2-------- : " + SuccessNote2);
		Assert.assertEquals(SuccessNote1[1], Note, "Note validated");

		String SuccessCategory = pb1.SuccessCategory().getText();
		System.out.println("-------SuccessCategory-------- : " + SuccessCategory);

		String Reference = pb1.Reference().getText();
		System.out.println("-------Reference-------- : " + Reference);
		String Reference1[] = Reference.split(": ");
		String Reference2 = Reference1[1];
		System.out.println("-------Reference2-------- : " + Reference2);

		action.press(PointOption.point(200, 950)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(200, 250)).release().perform();

		String RemainingBal = pb1.RemainingBal().getText();
		System.out.println("-------RemainingBal-------- : " + RemainingBal);
		String RemainingBal1 = RemainingBal.replaceAll(",", "");
		System.out.println("-------RemainingBal1-------- : " + RemainingBal1);
		String RemainingBal2[] = RemainingBal1.split(": ");
		String RemainingBal3 = RemainingBal2[1].trim();
		System.out.println("-------RemainingBal3-------- : " + RemainingBal3);

		Double OldBalanceNew = Double.parseDouble(OldBalance1);
		Double SuccessFeeNew = Double.parseDouble(SuccessFee);
		Double SuccessAmountNew = Double.parseDouble(SuccessAmount);
		Double newBal = Double.valueOf(OldBalanceNew - SuccessFeeNew - SuccessAmountNew);
		String newBal1 = String.format("%.2f", newBal);
		System.out.println("/////////////newBal1//////////- " + newBal1);
		Assert.assertEquals(RemainingBal3, newBal1, "New Balance validated");

		Thread.sleep(3000);
		System.out.println("///////////////Step Completed////////////");
	}

}
