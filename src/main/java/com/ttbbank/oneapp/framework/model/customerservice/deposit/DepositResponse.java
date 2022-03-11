package com.ttbbank.oneapp.framework.model.customerservice.deposit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositResponse {
    public List<DepositAccountList> deposit_account_lists;
}
