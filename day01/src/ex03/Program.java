package ex03;

import java.util.*;

public class Program {
    public static void main(String[] args) throws TransactionNotFoundException {
        User user1 = new User("Ruslan", 5000);
        User user2 = new User("Gosha", 5000);
        Transaction transaction1 = new Transaction(user1, user2, "IN", 500);
        Transaction transaction2 = new Transaction(user1, user2, "OUT", 500);
        Transaction transaction3 = new Transaction(user1, user2, "OUT", 5000);
        Transaction transaction4 = new Transaction(user1, user2, "OUT", 5000);
        Transaction transaction5 = new Transaction(user1, user2, "OUT", 5000);

        TransactionsLinkedList list = new TransactionsLinkedList();

        list.addingTransaction(transaction1);
        list.addingTransaction(transaction2);
        list.addingTransaction(transaction3);
        list.addingTransaction(transaction4);
        list.addingTransaction(transaction5);

        Transaction[] ShowArray = list.transactionToArray();
        System.out.println(Arrays.toString(ShowArray));

        UUID id = transaction5.getId();
        list.removeTransactionById(id);
        ShowArray = list.transactionToArray();
        System.out.println(Arrays.toString(ShowArray));

        UUID id2 = UUID.randomUUID();
        list.removeTransactionById(id2);
    }
}
