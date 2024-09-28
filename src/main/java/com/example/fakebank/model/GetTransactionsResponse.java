package com.example.fakebank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetTransactionsResponse {

    @JsonProperty("Data")
    private TransactionData data;

}
