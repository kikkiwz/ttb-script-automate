package com.tmb.automation.pages.pb1.transfer;

import org.openqa.selenium.WebElement;
import com.tmb.automation.util.AppiumLibrary;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.FindBy;

/* Android Automation
 * This Automation script is created by TCS for TMB Bank for OneApp 
 * @author DK-Vendor256  */

public class PB1TransferAndroidPO extends AppiumLibrary {
	public AppiumDriver<WebElement> appiumDriver;

	public PB1TransferAndroidPO (AppiumDriver<WebElement> appiumDriver) {
		super((AppiumDriver<WebElement>) appiumDriver);
		this.appiumDriver=appiumDriver;
	}

//Discover Screen//////////////////////////////////////////////////////////////
	@FindBy(xpath="(//*[@resource-id='00'])")
	WebElement GoToNative;
	public WebElement GoToNative() {
		return GoToNative; }

//Transfer Landing//////////////////////////////////////////////////////////////
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/icon_back_navigation'])[1]")
	WebElement TLBack;
	public WebElement TLBack() {
		return TLBack; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/label'])[1]")
	WebElement OwnTTB;
	public WebElement OwnTTB() {
		return OwnTTB; }

	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/label'])[2]")
	WebElement Other;
	public WebElement Other() {
		return Other; }
	
	@FindBy(xpath="(//*[@class='android.widget.TextView'])[3]")
	WebElement PromptPay;
	public WebElement PromptPay() {
		return PromptPay; }

//TransferPage//////////////////////////////////////////////////////////////
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/menu_name'])[1]")
	WebElement OwnTTBAc;
	public WebElement OwnTTBAc() {
		return OwnTTBAc; }

	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/menu_name'])[2]")
	WebElement OtherAc;
	public WebElement OtherAc() {
		return OtherAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/menu_name'])[3]")
	WebElement PromptPayAc;
	public WebElement PromptPayAc() {
		return PromptPayAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_selected_to_account'])[1]")
	WebElement ToOwnTTB;
	public WebElement ToOwnTTB() {
		return ToOwnTTB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_no'])[1]")
	WebElement FromAc;
	public WebElement FromAc() {
		return FromAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_current_balance'])")
	WebElement OldBalance;
	public WebElement OldBalance() {
		return OldBalance; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/label'])[1]")
	WebElement SelectToAc;
	public WebElement SelectToAc() {
		return SelectToAc; }

	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_no'])[2]")
	WebElement SelectToAcNo;
	public WebElement SelectToAcNo() {
		return SelectToAcNo; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/to_account_layout'])[1]")
	WebElement SelectOtherToAcNo;
	public WebElement SelectOtherToAcNo() {
		return SelectOtherToAcNo; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[1]")
	WebElement SelectOtherTTB;
	public WebElement SelectOtherTTB() {
		return SelectOtherTTB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[2]")
	WebElement SelectBBL;
	public WebElement SelectBBL() {
		return SelectBBL; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[3]")
	WebElement SelectKBank;
	public WebElement SelectKBank() {
		return SelectKBank; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[4]")
	WebElement SelectSCB;
	public WebElement SelectSCB() {
		return SelectSCB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[5]")
	WebElement SelectBAY;
	public WebElement SelectBAY() {
		return SelectBAY; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[6]")
	WebElement SelectKTB;
	public WebElement SelectKTB() {
		return SelectKTB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[7]")
	WebElement SelectKKP;
	public WebElement SelectKKP() {
		return SelectKKP; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[8]")
	WebElement SelectUOBT;
	public WebElement SelectUOBT() {
		return SelectUOBT; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[9]")
	WebElement SelectHSBC;
	public WebElement SelectHSBC() {
		return SelectHSBC; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[10]")
	WebElement SelectCITI;
	public WebElement SelectCITI() {
		return SelectCITI; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[11]")
	WebElement SelectSMBC;
	public WebElement SelectSMBC() {
		return SelectSMBC; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[12]")
	WebElement SelectGSB;
	public WebElement SelectGSB() {
		return SelectGSB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[13]")
	WebElement SelectDEUTSHE;
	public WebElement SelectDEUTSHE() {
		return SelectDEUTSHE; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[14]")
	WebElement SelectBAAC;
	public WebElement SelectBAAC() {
		return SelectBAAC; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[15]")
	WebElement SelectMHBK;
	public WebElement SelectMHBK() {
		return SelectMHBK; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[16]")
	WebElement SelectTBANK;
	public WebElement SelectTBANK() {
		return SelectTBANK; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[17]")
	WebElement SelectTISCO;
	public WebElement SelectTISCO() {
		return SelectTISCO; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[18]")
	WebElement SelectICBC;
	public WebElement SelectICBC() {
		return SelectICBC; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[19]")
	WebElement SelectTCRB;
	public WebElement SelectTCRB() {
		return SelectTCRB; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[20]")
	WebElement SelectLHBank;
	public WebElement SelectLHBank() {
		return SelectLHBank; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[21]")
	WebElement SelectBOC;
	public WebElement SelectBOC() {
		return SelectBOC; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_bank_name'])[22]")
	WebElement SelectANZ;
	public WebElement SelectANZ() {
		return SelectANZ; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/edt_account_no']")
	WebElement EnterAc;
	public WebElement EnterAc() {
		return EnterAc; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/edt_promptpay_no']")
	WebElement EnterPromptPayNo;
	public WebElement EnterPromptPayNo() {
		return EnterPromptPayNo; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/layout_amount']")
	WebElement AmountField;
	public WebElement AmountField() {
		return AmountField; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/edt_amount']")
	WebElement TypeAmount;
	public WebElement TypeAmount() {
		return TypeAmount; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/rest_entry_layout']")
	WebElement clickOnPage;
	public WebElement clickOnPage() {
		return clickOnPage; }
	
	@FindBy(xpath="//*[@resource-id='com.ttbbank.oneapp.vit:id/edt_note']")
	WebElement Note;
	public WebElement Note() {
		return Note; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/pill_category'])[2]")
	WebElement category;
	public WebElement category() {
		return category; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/btn_next'])")
	WebElement TransferNext;
	public WebElement TransferNext() {
		return TransferNext; }
	
//Review//////////////////////////////////////////////////////////////
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_from_no'])")
	WebElement ReviewFromAc;
	public WebElement ReviewFromAc() {
		return ReviewFromAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_to_no'])")
	WebElement ReviewToAc;
	public WebElement ReviewToAc() {
		return ReviewToAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_amount'])")
	WebElement ReviewAmount;
	public WebElement ReviewAmount() {
		return ReviewAmount; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_fee'])")
	WebElement ReviewFee;
	public WebElement ReviewFee() {
		return ReviewFee; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/btn_confirm'])")
	WebElement TransferConfirm;
	public WebElement TransferConfirm() {
		return TransferConfirm; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/cancel'])")
	WebElement Cancel;
	public WebElement Cancel() {
		return Cancel; }

//Success//////////////////////////////////////////////////////////////	
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_from_no'])")
	WebElement SuccessFromAc;
	public WebElement SuccessFromAc() {
		return SuccessFromAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_account_to_no'])")
	WebElement SuccessToAc;
	public WebElement SuccessToAc() {
		return SuccessToAc; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_amount'])")
	WebElement SuccessAmount;
	public WebElement SuccessAmount() {
		return SuccessAmount; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_fee'])")
	WebElement SuccessFee;
	public WebElement SuccessFee() {
		return SuccessFee; }

	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/note_tv'])")
	WebElement SuccessNote;
	public WebElement SuccessNote() {
		return SuccessNote; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/category_tv'])")
	WebElement SuccessCategory;
	public WebElement SuccessCategory() {
		return SuccessCategory; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/tv_reference_id'])")
	WebElement Reference;
	public WebElement Reference() {
		return Reference; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_remaining_balance'])")
	WebElement RemainingBal;
	public WebElement RemainingBal() {
		return RemainingBal; }
				
//	@FindBy(xpath="(//*[@text='Back home'])")
//	@FindBy(xpath="(//*[@class='android.widget.TextView'])")
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/btn_back_home'])")
	WebElement BackHome;
	public WebElement BackHome() {
		return BackHome; }
	
	@FindBy(xpath="(//*[@text='Transfer more'])")
	WebElement More;
	public WebElement More() {
		return More; }
	

//TD Page//////////////////////////////////////////////////////////////	
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/tv_maturity_date'])")
	WebElement MaturityTD;
	public WebElement MaturityTD() {
		return MaturityTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/content_layout'])[1]")
	WebElement MaturityDateTD1;
	public WebElement MaturityDateTD1() {
		return MaturityDateTD1; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/content_layout'])[2]")
	WebElement MaturityDateTD2;
	public WebElement MaturityDateTD2() {
		return MaturityDateTD2; }
		
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/content_layout'])[3]")
	WebElement MaturityDateTD3;
	public WebElement MaturityDateTD3() {
		return MaturityDateTD3; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/content_layout'])[4]")
	WebElement MaturityDateTD4;
	public WebElement MaturityDateTD4() {
		return MaturityDateTD4; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/content_layout'])[5]")
	WebElement MaturityDateTD5;
	public WebElement MaturityDateTD5() {
		return MaturityDateTD5; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_maturity_amount'])[1]")
	WebElement MaturityAmoutTD1;
	public WebElement MaturityAmoutTD1() {
		return MaturityAmoutTD1; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_maturity_amount'])[2]")
	WebElement MaturityAmoutTD2;
	public WebElement MaturityAmoutTD2() {
		return MaturityAmoutTD2; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_maturity_amount'])[3]")
	WebElement MaturityAmoutTD3;
	public WebElement MaturityAmoutTD3() {
		return MaturityAmoutTD3; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_maturity_amount'])[4]")
	WebElement MaturityAmoutTD4;
	public WebElement MaturityAmoutTD4() {
		return MaturityAmoutTD4; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_principle_amount'])")
	WebElement PrincipalTD;
	public WebElement PrincipalTD() {
		return PrincipalTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_penalty_amount'])")
	WebElement PenaltyTD;
	public WebElement PenaltyTD() {
		return PenaltyTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_interest'])")
	WebElement InterestTD;
	public WebElement InterestTD() {
		return InterestTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_tax_amount'])")
	WebElement TaxTD;
	public WebElement TaxTD() {
		return TaxTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_tax_net_amount'])")
	WebElement NetTD;
	public WebElement NetTD() {
		return NetTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_td_fee'])")
	WebElement ReviewFeeTD;
	public WebElement ReviewFeeTD() {
		return ReviewFeeTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_principle_amount'])")
	WebElement SuccessPrincipalTD;
	public WebElement SuccessPrincipalTD() {
		return SuccessPrincipalTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_penalty_amount'])")
	WebElement SuccessPenaltyTD;
	public WebElement SuccessPenaltyTD() {
		return SuccessPenaltyTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_interest'])")
	WebElement SuccessInterestTD;
	public WebElement SuccessInterestTD() {
		return SuccessInterestTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_tax_amount'])")
	WebElement SuccessTaxTD;
	public WebElement SuccessTaxTD() {
		return SuccessTaxTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_tax_net_amount'])")
	WebElement SuccessNetTD;
	public WebElement SuccessNetTD() {
		return SuccessNetTD; }
	
	@FindBy(xpath="(//*[@resource-id='com.ttbbank.oneapp.vit:id/txt_td_fee'])")
	WebElement SuccessFeeTD;
	public WebElement SuccessFeeTD() {
		return SuccessFeeTD; }

}

