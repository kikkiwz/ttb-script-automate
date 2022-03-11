package com.tmb.automation.test.pb1.s6107;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FetchAccountPOJO {

	@JsonProperty("product_name_Eng")
	private String productNameEN;
	@JsonProperty("product_name_TH")
	private String productNameTH;
	@JsonProperty("product_code")
	private String productCode;
	@JsonProperty("balance_currency")
	private String balanceCurr;
	@JsonProperty("current_balance")
	private String currentBal;
	@JsonProperty("account_number")
	private String accountNumber;
	@JsonProperty("relationship_code")
	private String relationshipCode;
	@JsonProperty("account_status_code")
	private String accountstatus;
	@JsonProperty("account_status_text")
	private String accountstatustext;
	@JsonProperty("product_group_code")
	private String productGrpCode;
	@JsonProperty("icon_id")
	private String iconId;
	@JsonProperty("sort_order")
	private String sortorder;
	@JsonProperty("allow_transfer_from_account")
	private String flagfromAccount;
	@JsonProperty("allow_transfer_other_account")
	private String otherflagfromAccount;
	@JsonProperty("transfer_own_tmb")
	private List<String> ownmapcode;
	@JsonProperty("transfer_other_tmb")
	private List<String> othermapcode;
	@JsonProperty("personalized_acct_nickname_EN")
	private String accnicknameEN;
	@JsonProperty("personalized_acct_nickname_TH")
	private String accnicknameTH;
	@JsonProperty("account_open_dt")
	private String accountOpendt;
	@JsonProperty("account_name")
	private String accountName;
	@JsonProperty("isHidden")
	private String hidden;
	@JsonProperty("isRegisterPromptpay")
	private String promptPayRegisterFlag;
	@JsonProperty("account_number_display")
	private String accountNumberDisplay;
	@JsonProperty("allow_transfer_to_promptpay")
	private String allowTransferToPromptpay;
	@JsonProperty("waive_fee_for_promptpay")
	private String waiveFeeForPromptpay;
	@JsonProperty("waive_fee_for_promptpay_account")
	private String waiveFeeForPromptpayAccount;

}
