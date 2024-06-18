package com.budgetting.api.plaid;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExchangeToken {


    private String client_id;


    private String secret;


    private String public_token;


}
