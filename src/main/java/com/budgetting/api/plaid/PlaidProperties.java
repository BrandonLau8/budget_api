package com.budgetting.api.plaid;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Component
//@ConfigurationProperties(prefix = "plaid")
@Profile("prod")
public class PlaidProperties {

    @Value("${plaid.clientId}")
    private String clientId;

//    @Value("${plaid.clientIdPath}")
//    private String clientIdPath;

    @Value("${plaid.secret}")
    private String secret;

//    @Value("${plaid.secretPath}")
//    private String secretPath;

    // No-argument constructor
    public PlaidProperties() {}

    public PlaidProperties(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
    }

//    @PostConstruct
//    public void init() {
//        if (clientIdPath == null || clientIdPath.isEmpty() || secretPath == null || secretPath.isEmpty()) {
//            System.err.println("Warning: Client ID path or Secret path is not configured");
//            return;
//        }
//        try{
//            this.clientId = new String(Files.readAllBytes(Paths.get(clientIdPath))).trim();
//            this.secret = new String(Files.readAllBytes(Paths.get(secretPath))).trim();
//        } catch (IOException e) {
//            System.err.println("Failed to load Client ID: " + e.getMessage());
//            System.err.println("Failed to load Secret: " + e.getMessage());
//        }
//    }

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

//    public String getClientIdPath() {
//        return clientIdPath;
//    }

//    public void setClientIdPath(String clientIdPath) {
//        this.clientIdPath = clientIdPath;
//    }
//
//    public String getSecretPath() {
//        return secretPath;
//    }
//
//    public void setSecretPath(String secretPath) {
//        this.secretPath = secretPath;
//    }
}
