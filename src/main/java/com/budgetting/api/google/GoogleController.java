package com.budgetting.api.google;

import com.google.api.client.auth.oauth.OAuthCredentialsResponse;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

//@CrossOrigin(origins = {"http://192.168.1.23:8080"})
@CrossOrigin(origins = {"http://173.52.45.250:8080","http://173.52.45.250:8080", "https://budgetting-api-56751984313.us-east4.run.app"})
@RestController
public class GoogleController {

    private final GoogleIDToken googleIDToken;

    @Autowired
    public GoogleController(GoogleIDToken googleIDToken) {
        this.googleIDToken = googleIDToken;
    }

    @PostMapping("/validate_id_token")
    public ResponseEntity<PayloadDto> validateIdToken(@RequestParam String idToken) throws IOException {
        System.out.println(idToken);
//        String idToken = credential.getAccessToken();

        return googleIDToken.validateIdToken(idToken);
    }
}
