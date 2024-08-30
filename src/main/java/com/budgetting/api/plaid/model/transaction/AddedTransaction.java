package com.budgetting.api.plaid.model.transaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.plaid.client.model.Location;
import com.plaid.client.model.PaymentMeta;
import com.plaid.client.model.Transaction;
import com.plaid.client.model.TransactionsSyncResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class AddedTransaction extends Transaction{

    @JsonProperty("account_id")
    private String accountId;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("iso_currency_code")
    private String isoCurrencyCode;

    @JsonProperty("date")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonProperty("name")
    private String name;

    private Location location;

    private PaymentMeta payment_meta;

    private Boolean pending;

    private String transactionId;

    private PaymentChannelEnum payment_channel;

    private String personal_finance_category_icon_url;

    public AddedTransaction(Transaction transaction) {
        this.accountId = transaction.getAccountId();
        this.amount = transaction.getAmount();
        this.isoCurrencyCode = transaction.getIsoCurrencyCode();
        this.date = transaction.getDate();
        this.name = transaction.getName();
        this.location = transaction.getLocation();
        this.payment_meta= transaction.getPaymentMeta();
        this.pending = transaction.getPending();
        this.transactionId = transaction.getTransactionId();
        this.payment_channel = transaction.getPaymentChannel();
        this.personal_finance_category_icon_url = transaction.getPersonalFinanceCategoryIconUrl();
    }
}
