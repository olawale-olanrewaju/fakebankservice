package com.example.fakebank.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.fakebank.model.TransactionData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.fakebank.model.GetTransactionsResponse;
import com.example.fakebank.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public GetTransactionsResponse getTransactionsByAccountId(String accountId){

        var allTransactions = getTransactionsFromStubForAnAccount(accountId);

        var transactionsResponse = GetTransactionsResponse.builder()
                                        .data(TransactionData.builder()
                                        .transaction(allTransactions).build())
                                        .build();

        log.info("Received request to fetch transactions for account {} and returning {} transactions", accountId, transactionsResponse.getData().getTransaction().size());
        return transactionsResponse;

    }

    public List<Transaction> getTransactionsFromStubForAnAccount(String accountId){

        List<Transaction> fullTransactionsList = new ArrayList<>();
        fullTransactionsList.addAll(readTransactionsFromFile(accountId));
        return fullTransactionsList;

    }

    private List<Transaction> readTransactionsFromFile(String accountId){

        String path = String.format("transactions_%s.json", accountId);

        try (InputStream in = new ClassPathResource(path).getInputStream()) {
            return objectMapper.readValue(in, TransactionData.class).getTransaction();
        } catch (IOException e) {
            log.warn("Couldn't read the file: {}", path, e);
            return List.of();
        }
    }



}
