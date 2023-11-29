package co.chu3la.controller;


import co.chu3la.Adapter.OBTransactionAdapter;
import co.chu3la.Adapter.TransactionApiClient;
import co.chu3la.domain.Transaction;
import org.springframework.web.reactive.function.client.WebClient;
import co.chu3la.model.OBReadDataTransaction6;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

public class RESTTransactionsAPIClient implements TransactionApiClient {

    private final WebClient webClient;
    private final OBTransactionAdapter obTransactionAdapter;

    public RESTTransactionsAPIClient(WebClient.Builder webClientBuilder, OBTransactionAdapter obTransactionAdapter) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:9090").build();
        this.obTransactionAdapter = obTransactionAdapter;
    }

    @Override
    public List<Transaction> getTransactionList(String numberAccount) {
        Mono<OBReadDataTransaction6> transactionResponse = webClient.get()
                .uri("/accounts/{accountNumber}/transactions", numberAccount)
                .retrieve()
                .bodyToMono(OBReadDataTransaction6.class);

        OBReadDataTransaction6 obReadDataTransaction6 = transactionResponse.block();

        return obReadDataTransaction6.getTransaction()
                .stream()
                .map(obTransactionAdapter::adapt)
                .collect(Collectors.toList());
    }
}
