package com.budgetting.api.google;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
public class GoogleProperties {
    private final String clientId;

    public GoogleProperties(Dotenv dotenv){
        this.clientId = dotenv.get("GOOGLE_CLIENT_ID");
    }

    public String getClientId() {
        return clientId;
    }
}
