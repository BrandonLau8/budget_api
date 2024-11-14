package com.budgetting.api.plaid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class LinkToken {
    @JsonProperty
    private String link_token;

    public LinkToken(String link_token) {
        this.link_token = link_token;
    }
}
