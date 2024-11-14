package com.budgetting.api.google;

import lombok.Data;

@Data
public class CustomCredential {
    private PayloadDto payloadDto;

    public PayloadDto getPayloadDto() {
        return payloadDto;
    }

    public void setPayloadDto(PayloadDto payloadDto) {
        this.payloadDto = payloadDto;
    }
}
