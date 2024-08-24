package com.budgetting.api.plaid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://192.168.1.9:8080")
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
    public AccessToken exchangePublicToken(@RequestParam String public_token) throws IOException {
        return plaidService.exchangePublicToken(public_token);
    }
}
