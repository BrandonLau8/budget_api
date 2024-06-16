package com.budgetting.api.plaid;

import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@Service
public class PlaidService {

    private final PlaidApi plaidApi;

    @Autowired
    public PlaidService(ApiClient apiClient) {
        this.plaidApi = apiClient.createService(PlaidApi.class);
    }

    public LinkToken createLinkToken() throws IOException {
        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                .clientUserId("clientUserId");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Plaid Test App")
                .products(Arrays.asList(Products.AUTH))
                .countryCodes(Arrays.asList(CountryCode.US))
                .language("en")
                .webhook("https://example.com/webhook")
                .linkCustomizationName("default")
                .androidPackageName("com.plaid.linksample");

        Response<LinkTokenCreateResponse> response = plaidApi.linkTokenCreate(request).execute();

        if (response.isSuccessful()) {
//            return response.body().getLinkToken();
            LinkToken linkToken= new LinkToken(response.body().getLinkToken());
            System.out.println(linkToken);
            return linkToken;
        } else {
            throw new IOException("Failed to create Link token: " + response.errorBody().string());
        }
    }

    public String exchangePublicToken(String publicToken) throws IOException {
        ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest().publicToken(publicToken);
        Response<ItemPublicTokenExchangeResponse> response = plaidApi.itemPublicTokenExchange(request).execute();

        if (response.isSuccessful()) {
            return response.body().getAccessToken();
        } else {
            throw new IOException("Failed to exchange public token: " + response.errorBody().string());
        }
    }
}
