package com.budgetting.api;

import com.budgetting.api.plaid.PlaidProperties;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthInterceptor implements Interceptor {
    private final PlaidProperties plaidProperties;

    @Autowired
    public AuthInterceptor(PlaidProperties plaidProperties) {
        this.plaidProperties = plaidProperties;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request originalRequest = chain.request();

        Request newRequest = originalRequest.newBuilder()
                .header("PLAID-CLIENT-ID", plaidProperties.getClientId())
                .header("PLAID-SECRET", plaidProperties.getSecret())
                .build();

        return chain.proceed(newRequest);
    }
}
