package com.budgetting.api.plaid;

import com.plaid.client.ApiClient;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class PlaidConfig {

//    @Value("${plaid.clientId}")
//    private String plaidClientId;
//
//    @Value("${plaid.secret}")
//    private String plaidSecret;

    @Bean
    public ApiClient apiClient(PlaidProperties plaidProperties) {
        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", plaidProperties.getClientId());
        apiKeys.put("secret", plaidProperties.getSecret());

        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Sandbox); // Use ApiClient.Sandbox for sandbox environment
        return apiClient;
    }
}