package com.budgetting.api.plaid;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;


@Component
@ConfigurationProperties(prefix = "plaid")
public class PlaidProperties {


    private String clientId;

    private String secret;

    // No-argument constructor
    public PlaidProperties() {}

    public PlaidProperties(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
    }

    @PostConstruct
    public void init() {
        System.out.println("Plaid Client ID: " + clientId);
        System.out.println("Plaid Secret: " + secret);
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public String getClientId() {
        return clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
