package com.budgetting.api.google;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "google")
public class GoogleProperties {

    @Value("${google.clientId}")
    private String clientId;

//    public GoogleProperties(Dotenv dotenv){
//        this.clientId = dotenv.get("GOOGLE_CLIENT_ID");
//    }


//    public GoogleProperties(String clientId) {
//        this.clientId = clientId;
//    }

    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
