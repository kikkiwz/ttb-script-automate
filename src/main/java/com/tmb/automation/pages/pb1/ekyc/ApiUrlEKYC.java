package com.tmb.automation.pages.pb1.ekyc;

/* API Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class ApiUrlEKYC {

	public final static String oneappD = "4Od1045RewUrGux8aj1oXzzrXOonyG7oOSIhERTL27W2tYIkDON6PXlIHGkv26I2";
	public final static String grantT = "password";
	public final static String scopE = "mobile";
	public final static String userN = "eJU0g94pt/M/Abt2sGO+knpCX+PRgXCR25Z9mj59mL1o7fwzUp8zQriBXs4LgEfA0hc+vYg/oaTto0Wl75nuqEPD0yI6/Io7PPoj/RobM8cjDY/U7qFZ9ISdMcpPJ3B8+t5fQ/QBsQ6h023Qlf60gTggsLNkUK6r+KnH1UeLWg/EGznsM3jaDaA2K0glVnJs5tzYmupo7WBjPPpkk9EC4TGN+se1z5L5im7nEZQHSx87ESwNSQH+zQJoXEjNt3JrOQMCbuMS3fQiwhO4je3wPWKgzAgM74diyRadM+V8JkCnCppQ+aBLYrmL6Oj3aIx+PhH3V2kZMMGB0s6SItDedg==";
	public final static String passW = "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
	public final static String loginApi = "apis/auth/token";	
	
	public final static String CommonEKYC = "apis/mobile/prelogin/internal/common/config?search=ekyc_module";
	public final static String CommonServiceHour = "apis/mobile/prelogin/internal/common/config?search=service_hour";
	public final static String EKYCScan = "apis/customer/ekyc/scan";
	public final static String CustomerProfile = "apis/customer/ekyc/profile/validation";
	public final static String SelectProduct = "apis/products/filter/1";
	public final static String FatcsScreen = "apis/customer/ekyc/fatca/validation";
	public final static String VerifyNDID = "apis/accounts/ekyc/bank/list";
	public final static String DataList = "apis/customer/ekyc/list";
	public final static String NDIDRequest = "apis/accounts/ekyc/bank/transaction";
	public final static String ActivityLog = "apis/customer/prelogin/activityLog";
	public final static String CreateProspect = "apis/customer/ekyc/prospect/create-prospect";
	public final static String UpdateProspect = "apis/customer/ekyc/prospect/update-prospect";
	public final static String SearchProspect = "apis/customer/ekyc/search/prospect";
	public final static String VerifyStatus = "apis/customer/ekyc/status";
	public final static String Biomatric = "apis/customers/ekyc/verify/biometric";
	public final static String PinSetup ="apis/auth/prelogin/pin/validate";
	public final static String AdderssList ="apis/customer/ekyc/address";
	public final static String CallRisk ="apis/customer/ekyc/risk/calculate";
	public final static String CancelRequest = "apis/customer/ekyc/close";
	public final static String OpenAccount ="apis/customer/ekyc/create/account";
	public final static String ChangeIdentifier ="apis/customer/ekyc/prospect/update-prospect-accept";
	
}
