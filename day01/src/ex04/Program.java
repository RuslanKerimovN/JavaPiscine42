package ex04;

import java.util.Arrays;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        TransactionsService ts = new TransactionsService();
        Transaction[] tlist = new Transaction[0];
        Transaction[] tlist2 = new Transaction[0];

        ts.addingUser("Ruslan", 500000);
        ts.addingUser("Tanya", 5000);
        System.out.println(ts.getBalanceOfUser(1));
        System.out.println(ts.getBalanceOfUser(2));
        System.out.println("-----------------------");

        ts.MakeTransaction(1, 2, 500);
        ts.MakeTransaction(2, 1, 500);
        ts.MakeTransaction(1, 2, 500);
        System.out.println(ts.getBalanceOfUser(1));
        System.out.println(ts.getBalanceOfUser(2));
        System.out.println("-----------------------");

        tlist = ts.getTransactionListOfUser(1);
        tlist2 = ts.getTransactionListOfUser(2);
        System.out.println(Arrays.toString(tlist));
        System.out.println(Arrays.toString(tlist2));
        System.out.println("-----------------------");

        System.out.println(tlist[0].getId());
        ts.removeTransaction(2, tlist[0].getId());
        System.out.println(tlist[1].getId());
        ts.removeTransaction(2, tlist[1].getId());
        System.out.println(tlist[2].getId());
        ts.removeTransaction(2, tlist[2].getId());
        tlist = ts.getTransactionListOfUser(1);
        tlist2 = ts.getTransactionListOfUser(2);
        System.out.println(Arrays.toString(tlist));
        System.out.println(Arrays.toString(tlist2));

        System.out.println("HERE :" + Arrays.toString(ts.correctArrayTransaction()));

        UUID ud = UUID.randomUUID();
        ts.removeTransaction(1, ud);

    }
}
