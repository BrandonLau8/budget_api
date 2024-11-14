package com.budgetting.api.plaid;

import com.budgetting.api.plaid.model.AccessToken;
import com.budgetting.api.plaid.model.LinkToken;
import com.budgetting.api.plaid.model.PublicTokenResponse;
import com.budgetting.api.plaid.model.transaction.AddedTransaction;
import com.budgetting.api.plaid.model.transaction.TransactionResponse;
import com.plaid.client.model.Transaction;
import com.plaid.client.model.TransactionsGetResponse;
import com.plaid.client.model.TransactionsSyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://192.168.1.23:8080", "https://sandbox.plaid.com"})
@RestController
public class PlaidController {

    private final PlaidService plaidService;

    @Autowired
    public PlaidController(PlaidService plaidService) {
        this.plaidService = plaidService;
    }

    @PostMapping("/link/token/create")
    public ResponseEntity<LinkToken> createLinkToken() throws IOException {
        return plaidService.createLinkToken();
    }

//    @PostMapping("/sandbox/public_token/create")
//    public AccessToken createPublicToken() throws IOException, InterruptedException {
//        return plaidService.createPublicToken();
//    }

    @PostMapping("/item/public_token/exchange")
    public AccessToken exchangePublicToken(@RequestParam String public_token) throws IOException {
        return plaidService.exchangePublicToken(public_token);
    }

    @PostMapping("/transactions/sync")
    public ResponseEntity<TransactionsSyncResponse> syncTransaction(@RequestParam String access_token) throws IOException {
        return new ResponseEntity<>(plaidService.syncTransaction(access_token), HttpStatus.OK);
    }

//    @PostMapping("/transactions/get")
//    public TransactionsGetResponse getTransaction(@RequestParam String access_token) throws IOException {
//        return plaidService.getTransaction(access_token);
//    }
}
