package com.budgetting.api.plaid.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class LinkToken {
    @JsonProperty
    private String link_token;
}
