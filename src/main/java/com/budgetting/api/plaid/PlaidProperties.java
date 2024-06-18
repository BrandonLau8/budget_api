package com.budgetting.api.plaid;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class PlaidProperties {

    private final String clientId;
    private final String secret;

    public PlaidProperties(Dotenv dotenv) {
        this.clientId = dotenv.get("PLAID_CLIENT_ID");
        this.secret = dotenv.get("PLAID_SECRET");
    }
}
