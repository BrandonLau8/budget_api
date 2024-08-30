package com.budgetting.api.plaid.model.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plaid.client.model.AccountBase;
import com.plaid.client.model.Transaction;
import com.plaid.client.model.TransactionsSyncResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends TransactionsSyncResponse{

//    @JsonProperty("transactions_update_status")
//    private String transactionUpdateStatus;

    @JsonProperty("accounts")
    private List<AccountBase> accounts;

    //Transactions that have been added to the Item since cursor ordered by ascending last modified time.
    @JsonProperty("added")
    private List<Transaction> added;

    public TransactionResponse(TransactionsSyncResponse body) {
        this.accounts = body.getAccounts();
        this.added = body.getAdded();
    }


/*    public TransactionResponse(List<AccountBase> accountBase, Collection<AddedTransaction> addedTransaction) {
       this.accounts = accountBase;
       this.addedTransaction = addedTransaction;
    }*/

//    //Transactions that have been modified on the Item since cursor ordered by ascending last modified time.
//    @JsonProperty("added")
//    private ModifiedTransactions modified;

//    @JsonProperty("added")
//    private RemovedTransactions added;
}
