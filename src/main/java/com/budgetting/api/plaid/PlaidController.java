package com.budgetting.api.plaid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://10.0.2.2:8080")
@RestController
public class PlaidController {

    private final PlaidService plaidService;

    @Autowired
    public PlaidController(PlaidService plaidService) {
        this.plaidService = plaidService;
    }

    @PostMapping("/link/token/create")
    public LinkToken createLinkToken() throws IOException {
        return plaidService.createLinkToken();
    }

    @PostMapping("/item/public_token/exchange")
    public String exchangePublicToken(@RequestBody ExchangeToken token) throws IOException {
        return plaidService.exchangePublicToken(token.getPublic_token());
    }
}
