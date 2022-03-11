package com.ttbbank.oneapp.framework.model.customerservice.deposit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositAccountList {
    public double account_balance;
    public String account_name_en;
    public String account_name_th;
    public String account_nickname;
    public String account_number;
    public String account_type;
}
