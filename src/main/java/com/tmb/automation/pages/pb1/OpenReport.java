package com.tmb.automation.pages.pb1;

import java.io.IOException;
import org.testng.annotations.Test;

/* This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class OpenReport {
	
	@Test(groups = {"android", "iOS", "PB1"}, description="Report")
	public static void openReport() {
		System.out.println("Report Generated........");
	} 

	public static void reportAPI(String response) throws InterruptedException, IOException{
		System.out.println("Report Added........");
		Thread.sleep(1000);
	}
	
	public static void reportString(String message) throws InterruptedException, IOException{
		System.out.println("Report Added........");
		Thread.sleep(1000);
	}
	
	public static void reportBase(String Details) throws InterruptedException, IOException{
		System.out.println("Report Added........");
		Thread.sleep(1000);
	}
	
	public static void ReportBase(String Details) throws InterruptedException, IOException{
		System.out.println("Report Added........");
		Thread.sleep(1000);
	}
	
}
