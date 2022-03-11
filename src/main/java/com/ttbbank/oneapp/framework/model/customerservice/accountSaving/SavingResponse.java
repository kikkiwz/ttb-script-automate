package com.ttbbank.oneapp.framework.model.customerservice.accountSaving;

import java.util.List;

public class SavingResponse {
    public String total_available_balance;
    public List<DepositAccountList> deposit_account_lists;
    public List<ProductGroupFlag> product_group_flag;
    public List<String> mutual_fund_accounts;
    public List<LoanAccount> loan_accounts;
    public List<Object> hp_accounts;
}
