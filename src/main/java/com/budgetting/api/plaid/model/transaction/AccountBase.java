package com.budgetting.api.plaid.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plaid.client.model.TransactionsSyncResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class AccountBase extends com.plaid.client.model.AccountBase {
    @JsonProperty("account_id")
    private String accountId;

//    @JsonProperty("balances")
//    private Balances balances;

    @JsonProperty("name")
    private String name;

//    @JsonProperty("subtype")
//    private String subtype;
//
//    @JsonProperty("type")
//    private String type;

//    public AccountBase(com.plaid.client.model.AccountBase accountBase) {
//        this.accountId = accountBase.getAccountId();
//        this.name = accountBase.getName();
//    }
}
