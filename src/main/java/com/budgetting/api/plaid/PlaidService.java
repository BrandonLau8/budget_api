package com.budgetting.api.plaid;

import com.budgetting.api.plaid.model.AccessToken;
import com.budgetting.api.plaid.model.LinkToken;
import com.budgetting.api.plaid.model.PublicTokenResponse;
import com.budgetting.api.plaid.model.transaction.AddedTransaction;
import com.budgetting.api.plaid.model.transaction.TransactionResponse;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class PlaidService {

    private final PlaidApi plaidApi;

    @Autowired
    public PlaidService(ApiClient apiClient) {
        this.plaidApi = apiClient.createService(PlaidApi.class);
    }

    public LinkToken createLinkToken() throws IOException {
        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser().clientUserId("clientUserId");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Plaid Test App")
                .products(Arrays.asList(Products.TRANSACTIONS))
                .countryCodes(Arrays.asList(CountryCode.US)).language("en")
                .webhook("https://example.com/webhook")
                .linkCustomizationName("default")
                .androidPackageName("com.budgetapp.budgetapp");

        Response<LinkTokenCreateResponse> response = plaidApi.linkTokenCreate(request).execute();

        if (response.isSuccessful()) {
//            return response.body().getLinkToken();
            LinkToken linkToken = new LinkToken(response.body().getLinkToken());
            System.out.println(linkToken);
            return linkToken;
        } else {
            throw new IOException("Failed to create Link token: " + response.errorBody().string());
        }
    }

//    public AccessToken createPublicToken() throws IOException, InterruptedException {
//        SandboxPublicTokenCreateRequest createRequest = new SandboxPublicTokenCreateRequest()
//                .institutionId("ins_109508")
//                .initialProducts(Arrays.asList(Products.TRANSACTIONS))
//                .options(new SandboxPublicTokenCreateRequestOptions()
//                        .webhook("https://example.com/webhook")
//                        .overrideUsername("user_transactions_dynamic")
//                        .overridePassword("blah"));
//
//        Response<SandboxPublicTokenCreateResponse> createResponse = plaidApi
//                .sandboxPublicTokenCreate(createRequest)
//                .execute();
//
//        // The generated public_token can now be
//// exchanged for an access_token
//        ItemPublicTokenExchangeRequest exchangeRequest = new ItemPublicTokenExchangeRequest()
//                .publicToken(createResponse.body().getPublicToken());
//        Response<ItemPublicTokenExchangeResponse> response = plaidApi
//                .itemPublicTokenExchange(exchangeRequest)
//                .execute();
//
//        AccessToken accessToken = new AccessToken(response.body());
//        return accessToken;
//    }

    public AccessToken exchangePublicToken(String token) throws IOException {
        ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest().publicToken(token);
        Response<ItemPublicTokenExchangeResponse> response = plaidApi.itemPublicTokenExchange(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            AccessToken accessToken = new AccessToken(response.body());
            System.out.println(response.body().getAccessToken());
            return accessToken;
        } else {
            throw new IOException("Failed to exchange public token: " + response.errorBody().string());
        }
    }

    public TransactionsSyncResponse syncTransaction(String accessToken) throws IOException {

        // Provide a cursor from your database if you've previously
        // recieved one for the item leave null if this is your
        // first sync call for this item. The first request will return a cursor.
//        String cursor = database.getLatestCursorOrNull(itemId);
        String cursor = "";

        // New transaction updates since "cursor"
        List<Transaction> added = new ArrayList<>();

        boolean hasMore = true;
        TransactionsSyncRequestOptions options = new TransactionsSyncRequestOptions().includePersonalFinanceCategory(true);

//        TransactionResponse finalResponse = new TransactionResponse();

// Iterate through each page of new transaction updates for item
//        while (hasMore) {
            TransactionsSyncRequest request = new TransactionsSyncRequest()
                    .accessToken(accessToken)
                    .cursor(cursor)
                    .options(options)
                    .count(2);

        retrofit2.Response<TransactionsSyncResponse> retrofitResponse = plaidApi.transactionsSync(request).execute();
        TransactionsSyncResponse response = retrofitResponse.body();
//            TransactionsSyncResponse response = plaidApi.transactionsSync(request).execute().body();

            // Add this page of results
            assert response != null;
            added.addAll(response.getAdded());

            hasMore = response.getHasMore();
            // Update cursor to the next cursor
            cursor = response.getNextCursor();

//            System.out.println(response);
            System.out.println(response);
//
//            finalResponse.setAdded(response.body().getAdded());
//
//            finalResponse.setAccounts(response.body().getAccounts());
//        }

//        System.out.println(finalResponse);

        // Create and return TransactionResponse with collected data
        return response;

    }

//    public TransactionsGetResponse getTransaction(String accessToken) throws IOException {
//        LocalDate startDate = LocalDate.now().minusDays(30);
//        LocalDate endDate = LocalDate.now();
//        TransactionsGetRequestOptions options = new TransactionsGetRequestOptions()
//                .includePersonalFinanceCategory(true);
//// Pull transactions for a date range
//
//        TransactionsGetRequest request = new TransactionsGetRequest()
//                .accessToken(accessToken)
//                .startDate(startDate)
//                .endDate(endDate)
//                .options(options);
//        Response<TransactionsGetResponse>
//                response = plaidApi.transactionsGet(request).execute();
//
//        List<Transaction> transactions = new ArrayList <Transaction>();
//        transactions.addAll(response.body().getTransactions());
//
//        return response.body();
//    }
}

