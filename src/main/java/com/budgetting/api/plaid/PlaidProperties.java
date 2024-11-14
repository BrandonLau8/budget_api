package com.budgetting.api.plaid;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class PlaidProperties {

    @Value("${PLAID_CLIENT_ID}")
    private final String clientId;

    @Value("${PLAID_SECRET}")
    private final String secret;

//    public PlaidProperties(Dotenv dotenv) {
//        this.clientId = dotenv.get("PLAID_CLIENT_ID");
//        this.secret = dotenv.get("PLAID_SECRET");
//    }


    public PlaidProperties(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getSecret() {
        return secret;
    }
}
