package com.tmb.automation.pages.pb1.transfer;

/* API Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class ApiUrl {

	public final static String PinUser = "WfR5cuIdLh/GY9d9LME+SpKawy+LUToauMWCF+F87GGLCka6IlTP1Q7qnOVmYxl0jZGusmFNK/bICIUJA1ro2AhQXYaTKgs5mOJEO0DDEYla7vvXaLYZP1l2E57Yyk5r/iIxP/EdhuV6wIi/wmeGDM6jWgwtI9SisCq5Mcf1rvXHpBb6Dz/K9ppUrkGeyh24QdHoGxsPhi98mE8XB9jy5bWFf2fUtCNZzsFY5oLj+9PcHv+t9iS1H11SNN6nqJvCErlAGRIRoV5LxEOVuZ2rh8AO4Dy4CDUpCE8EPVRlvwbMndgiCaOGc3NAt5fs0Dbh+HZ8w0K8mQiTdx7lrRyVfA==";
	
	public final static String loginApi = "apis/auth/token";
	public final static String bankListApi = "apis/payment/transfer/bankInfo";
	public final static String categoryListApi = "apis/payment/category";
	public final static String dailyLimitApi = "apis/payment/transactionLimit";
	public final static String accountDetailsApi = "apis/customer/accounts/details";
	public final static String accountListApi = "apis/customer/accounts/list";
	public final static String verifyPinApi = "apis/auth/verify/pin";					
	public final static String financialActivity = "apis/payment/financial/activities";
	
	public final static String ownttbApi = "apis/payment/transfer/validate";
	public final static String tdttbApi = "apis/payment/transfer/tdvalidate";
	public final static String ownttbConfirmApi = "apis/payment/transfer/confirm";
	public final static String promptApi = "apis/payment/transfer/promptvalidate";
	public final static String promptConfirmApi = "apis/payment/transfer/promptconfirm";
	
	public final static String OwnTTBProxy = "0";
	public final static String OtherTTBProxy= "1";
	public final static String OtherBankProxy = "0";
	public final static String CitizenProxy = "1";
	public final static String MobileProxy = "2";


}
