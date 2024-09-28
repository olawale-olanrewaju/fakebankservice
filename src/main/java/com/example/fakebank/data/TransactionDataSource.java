package com.example.fakebank.data;

import com.example.fakebank.service.AccountService;
import org.springframework.web.bind.annotation.RestController;

import com.example.fakebank.model.GetTransactionsResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Slf4j
public class TransactionDataSource {

    private final AccountService accountService = new AccountService();

    
    @GetMapping(path = "/v1/accounts/{accountId}/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetTransactionsResponse getAccountTransactions(@PathVariable("accountId") String accountId){
        log.info("Recieved request to fetch transactions for account {}", accountId);
        return accountService.getTransactionsByAccountId(accountId);
    }

}
