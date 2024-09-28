package com.example.fakebank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Amount {

    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("Currency")
    private String currency;

}
