package com.tmb.automation.pages.pb1;

import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tmb.automation.util.Base;

/* Android Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class PB1PinAndroid extends Base {
	
	@BeforeMethod()
	public void BeforeTest( ) {
		Base.appiumCapabilities();
	}

	@Test(description="Login")
	public static void Login() throws InterruptedException, IOException{

		PB1LoginAndroid_PO ps=new PB1LoginAndroid_PO(appiumDriver); 
		Thread.sleep(2000);

		ps.Accounts().click();		
			
		ps.Pin0().click();
		ps.Pin1().click();
		ps.Pin0().click();
		ps.Pin2().click();
		ps.Pin0().click();
		ps.Pin3().click();
		
		Thread.sleep(2000);
		ps.Home().click();
		
		Thread.sleep(2000);
		System.out.println("///////////////Pin Completed////////////");
	}

	@Test(description="LoginTransfer")
	public static void LoginTransfer() throws InterruptedException, IOException{

		PB1LoginAndroid_PO ps=new PB1LoginAndroid_PO(appiumDriver); 
		Thread.sleep(2000);
		
		ps.TPin0().click();
		ps.TPin1().click();
		ps.TPin0().click();
		ps.TPin2().click();
		ps.TPin0().click();
		ps.TPin3().click();
		
		Thread.sleep(2000);
		System.out.println("///////////////Transfer Pin Completed////////////");
	}

}
