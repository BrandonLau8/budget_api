package com.budgetting.api.plaid;

import com.plaid.client.model.LinkTokenCreateResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @PostMapping("/exchange-public-token")
    public String exchangePublicToken(@RequestBody String publicToken) throws IOException {
        return plaidService.exchangePublicToken(publicToken);
    }
}
