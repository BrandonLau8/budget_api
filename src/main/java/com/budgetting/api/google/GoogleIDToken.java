package com.budgetting.api.google;

import com.google.api.client.json.JsonFactory;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.Collections;

@Component
public class GoogleIDToken {

    private final GoogleProperties googleProperties;
    private final HttpTransport transport = new NetHttpTransport();
    private final JsonFactory jsonFactory = new GsonFactory();
    private final GoogleIdTokenVerifier verifier;

    // Inject GoogleProperties through the constructor
    public GoogleIDToken(GoogleProperties googleProperties) {
        this.googleProperties = googleProperties;

        // Initialize verifier after googleProperties is set
        this.verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                .setAudience(Collections.singletonList(googleProperties.getClientId()))
                .build();
    }

// (Receive idTokenString by HTTPS POST)
public ResponseEntity<CustomCredential> validateIdToken(String idToken) {
    try {
        // Validate the ID token
        GoogleIdToken token = verifier.verify(idToken);
        System.out.println("Token: " + token);
        if (token != null) {
            // Token is valid, return success response
            CustomCredential response = new CustomCredential();
            PayloadDto payloadDto = new PayloadDto();

            if (token != null) {
                Payload payload = token.getPayload();

                // Print user identifier
                String userId = payload.getSubject();
                System.out.println("User ID: " + userId);

                // Get profile information from payload
                String email = payload.getEmail();
                boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
                String name = (String) payload.get("name");
                String pictureUrl = (String) payload.get("picture");
                String locale = (String) payload.get("locale");
                String familyName = (String) payload.get("family_name");
                String givenName = (String) payload.get("given_name");

                // Use or store profile information
                // ...
                payloadDto.setEmail(email);
                payloadDto.setName(name);
                payloadDto.setSub(userId);
                response.setPayloadDto(payloadDto);
//                response.getPayloadDto().setEmail(email);
//                response.getPayloadDto().setName(name);
//                response.getPayloadDto().setSub(userId);
//                response.getData().setMessage("Token is valid");
            } else {
                System.out.println("Invalid ID token.");
            }
            return ResponseEntity.ok(response);
        } else {
            // Token is invalid
            CustomCredential errorResponse = new CustomCredential();
//            errorResponse.getData().setMessage("Invalid Token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }
    } catch (Exception e) {
        // Handle exceptions (e.g., logging, error messages)
        CustomCredential errorResponse = new CustomCredential();
//        errorResponse.getData().setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}



}
