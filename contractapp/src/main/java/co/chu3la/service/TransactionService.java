package co.chu3la.service;


import co.chu3la.domain.Transaction;
import co.chu3la.repository.TransactionRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TransactionService {


    @Autowired(required = true)
    private TransactionRepository transactionRepository;

    @CircuitBreaker(name = "transactionServiceCircuitBreaker", fallbackMethod = "fallbackGetTransactions")
    public List<Transaction> getAllTransactions(String accountNumber) {
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }




}
