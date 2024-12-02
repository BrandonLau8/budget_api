package com.budgetting.api.google;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Component
@Profile("prod")
//@ConfigurationProperties(prefix = "google")
public class GoogleProperties {

    @Value("${google.clientId}")
    private String clientId;

//    @Value("${google.clientIdPath}")
//    private String clientIdPath;

    public GoogleProperties() {
    }

    public GoogleProperties(String clientId) {
        this.clientId = clientId;;
    }

//    @PostConstruct
//    public void loadSecrets() {
//        if (clientIdPath == null || clientIdPath.isEmpty()) {
//            System.err.println("Warning: Client ID path is not configured, skipping secret loading");
//            return; // Allow application to proceed without crashing
//        }
//        try {
//            this.clientId = new String(Files.readAllBytes(Paths.get(clientIdPath))).trim();
//            System.out.println("Loaded Google Client ID: " + clientId);
//        } catch (IOException e) {
//            System.err.println("Failed to load Client ID: " + e.getMessage());
//        }
//    }

    public String getClientId() {
        return clientId;
    }

//    public void setClientIdPath(String clientIdPath) {
//        this.clientIdPath = clientIdPath;
//    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

//    public String getClientIdPath() {
//        return clientIdPath;
//    }
}
