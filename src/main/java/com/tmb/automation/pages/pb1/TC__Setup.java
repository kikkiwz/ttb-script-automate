package com.tmb.automation.pages.pb1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.tmb.automation.helper.Helper;
import com.tmb.automation.util.Base;

public class TC__Setup extends Base{

	@Parameters({"DeviceProfile"})
	@BeforeSuite()
	public void BeforeS(String deviceProfile) {
		Helper.CONFIG_PROFILE = deviceProfile;
		
		String profile = Helper.CONFIG_PROFILE;
		System.out.println("---------------profile---------------" +profile);
		if (profile.equals("android.EM3")) {
			startEmulator(); 
			System.out.println("---------------Test is Executing in Emulator---------------");	} 
		else if (profile.equals("android.RE3")) { 
			System.out.println("---------------Test is Executing in Real Android Device---------------");	} 
		
		else if (profile.equals("ios.SI3")) {
			startEmulator(); 
			System.out.println("---------------Test is Executing in Simulator---------------");	} 
		else if (profile.equals("ios.IP3")) { 
			System.out.println("---------------Test is Executing in iPhone Device---------------");	} 
		
		else {
			System.out.println("---------------Unknown Device Setup---------------");	}
	
		startServer();
	}
	
	@AfterSuite()
	public void AfterS() {
//		stopEmulator();
		stopServer();
	}
}

