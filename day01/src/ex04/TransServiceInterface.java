package ex04;

import java.util.UUID;

public interface TransServiceInterface {
    void addingUser(String name, Integer balance);
    Integer getBalanceOfUser(Integer id);
    void MakeTransaction(Integer id1, Integer id2, Integer summ);
    Transaction[] getTransactionListOfUser(Integer id);
    void removeTransaction(Integer id, UUID uuid);
    Transaction[] correctArrayTransaction();
}
