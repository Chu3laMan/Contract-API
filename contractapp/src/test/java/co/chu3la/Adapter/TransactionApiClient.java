package co.chu3la.Adapter;

import co.chu3la.domain.Transaction;

import java.util.List;

public interface TransactionApiClient {

    public List<Transaction> getTransactionList(String numberAccount);

}
