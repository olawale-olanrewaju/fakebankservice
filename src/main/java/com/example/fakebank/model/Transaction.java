package com.example.fakebank.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Transaction {

     @JsonProperty("AccountId")
    private String accountId;

    @JsonProperty("TransactionId")
    private String transactionId;

    @JsonProperty("TransactionReference")
    private String transactionReference;

    @JsonProperty("StatementReference")
    private List<String> statementReference;

    @JsonProperty("CreditDebitIndicator")
    private String creditDebitIndicator;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("BookingDateTime")
    @JsonFormat(pattern = "uuuu-MM-dd'T'HH:mm:ss.SSS'Z'")
    private String bookingDateTime;

    @JsonProperty("ValueDateTime")
    private String valueDateTime;

    @JsonProperty("TransactionInformation")
    private String transactionInformation;

    @JsonProperty("AddressLine")
    private String addressLine;

    @JsonProperty("Amount")
    private Amount amount;

}
