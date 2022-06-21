package ex04;

import java.util.UUID;

public interface TransactionsList {
    void addingTransaction(Transaction transaction);
    void removeTransactionById(UUID id);
    Transaction[] transactionToArray();
}
