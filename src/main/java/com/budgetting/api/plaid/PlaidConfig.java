package com.budgetting.api.plaid;

import com.budgetting.api.AuthInterceptor;
import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@Configuration
public class PlaidConfig {

//    @Value("${plaid.clientId}")
//    private String plaidClientId;
//
//    @Value("${plaid.secret}")
//    private String plaidSecret;


    @Bean
    public OkHttpClient okHttpClient(AuthInterceptor authInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build();
    }

    @Bean
    public PlaidApi plaidApi(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.23:8080") // Use the appropriate base URL for sandbox or production
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(PlaidApi.class);
    }

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