package com.budgetting.api.plaid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PublicTokenResponse {

    @JsonProperty("public_token")
    private String publicToken;

    @JsonProperty("request_id")
    private String requestId;
}
