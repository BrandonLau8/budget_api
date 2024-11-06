package com.budgetting.api.google;

import lombok.Data;

@Data
public class PayloadDto {
    private String sub;
    private String email;
    private String name;
}
