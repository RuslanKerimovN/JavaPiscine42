package ex04;

import java.util.Arrays;
import java.util.UUID;

public class TransactionsService implements TransServiceInterface {
    private UsersList usersList;
    private TransactionsLinkedList returnArray;
    private int counterRemove;

    TransactionsService() {
        usersList = new UsersArrayList();
        returnArray = new TransactionsLinkedList();
        counterRemove = 0;
    }

    public UsersList getUsersList() {
        return usersList;
    }

    @Override
    public void addingUser(String name, Integer balance) {
        usersList.addingUsers(new User(name, balance));
    }

    @Override
    public Integer getBalanceOfUser(Integer id) {
        return usersList.getUserById(id).getBalance();
    }

    @Override
    public void MakeTransaction(Integer id1, Integer id2, Integer summ) {
        User tmpUser1 = usersList.getUserById(id1);
        User tmpUser2 = usersList.getUserById(id2);

        TransactionsList t1 = tmpUser1.getTransactionsList();
        TransactionsList t2 = tmpUser2.getTransactionsList();

        UUID uuid = UUID.randomUUID();
        Transaction transaction1 = new Transaction(uuid, tmpUser1, tmpUser2, "OUT", summ);
        if (tmpUser1.getBalance() < summ) {
            throw new IllegalTransactionException("Insufficient funds!");
        }
        tmpUser1.setBalance(tmpUser1.getBalance() + transaction1.getTransfer());
        Transaction transaction2 = new Transaction(uuid, tmpUser2, tmpUser1, "IN", summ);
        tmpUser2.setBalance(tmpUser2.getBalance() + transaction2.getTransfer());

        t1.addingTransaction(transaction1);
        t2.addingTransaction(transaction2);

        tmpUser1.setTransactionsList(t1);
        tmpUser2.setTransactionsList(t2);
    }

    @Override
    public Transaction[] getTransactionListOfUser(Integer id) {
        return usersList.getUserById(id).getTransactionsList().transactionToArray();
    }

    @Override
    public void removeTransaction(Integer id, UUID uuid) {
        User tmpUser = usersList.getUserById(id);
        Transaction[] transactions = returnArray.transactionToArray();

        if (counterRemove == 0) {
            returnArray.addingTransaction(getTransactionById(uuid,
                    tmpUser.getTransactionsList().transactionToArray()));
        }
        else {
            for (int i = 0; i < transactions.length; i++) {
                if (transactions[i].getId().equals(uuid)) {
                    returnArray.removeTransactionById(uuid);
                    break;
                }
                if (i == transactions.length - 1 && transactions[i].getId() != uuid) {
                    returnArray.addingTransaction(getTransactionById(uuid,
                            tmpUser.getTransactionsList().transactionToArray()));
                }
            }
        }
        counterRemove++;
        tmpUser.getTransactionsList().removeTransactionById(uuid);

    }

    private Transaction getTransactionById(UUID uuid, Transaction[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].getId().equals(uuid)) {
                return array[i];
            }
        }
        return null;
    }

    @Override
    public Transaction[] correctArrayTransaction() {
        return returnArray.transactionToArray();
    }
}
