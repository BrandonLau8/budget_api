package com.budgetting.api.plaid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessToken {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("item_id")
    private String itemId;

    @JsonProperty("request_id")
    private String requestId;

    public AccessToken(ItemPublicTokenExchangeResponse body) {
        this.accessToken = body.getAccessToken();
        this.itemId = body.getItemId();
        this.requestId = body.getRequestId();
    }
}
