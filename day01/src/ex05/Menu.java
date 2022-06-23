package ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private TransactionsService ts;

    Menu() {
        ts = new TransactionsService();
    }

    public TransactionsService getTs() {
        return ts;
    }

    public void showMenu() {
        System.out.print("1. Add a user\n" +
                "2. View user balances\n" +
                "3. Perform a transfer\n" +
                "4. View all transactions for a specific user\n" +
                "5. DEV – remove a transfer by ID\n" +
                "6. DEV – check transfer validity\n" +
                "7. Finish execution\n-> ");
    }

    public void command1AddUser(String line, int index) throws IllegalArgumentException {
        String[] splited = line.split("\\s+");

        if (splited.length > 2) {
            throw new IllegalArgumentException("Need only two arguments!");
        }
        ts.addingUser(splited[0], Integer.parseInt(splited[1]));
        System.out.println("User with id = " + getTs().getUsersList().
                getUserByIndex(index).getId() + " is added");
    }

    public void command2GetBalanceUser(String line) {
        int id = Integer.parseInt(line);
        System.out.println(getTs().getUsersList().
                getUserById(id).getName()
                + " - " + getTs().getBalanceOfUser(id));
    }

    public void command3MakeTransaction(String line) {
        String[] splited = line.split("\\s+");

        if (splited.length > 3) {
            throw new IllegalArgumentException("Need only three arguments!");
        }
        ts.MakeTransaction(Integer.parseInt(splited[0]),
                Integer.parseInt(splited[1]), Integer.parseInt(splited[2]));
        System.out.println("The transfer is completed");
    }

    public void command4ShowTransactions(String line) {
        String[] splited = line.split("\\s+");
        int id = Integer.parseInt(splited[0]);
        Transaction[] transactions = ts.getTransactionListOfUser(id);

        if (splited.length > 1) {
            throw new IllegalArgumentException("Need only one argument!");
        }

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i].getTransfer() < 0) {
                System.out.println("To " + transactions[i].getSender().getName()
                        + "(id = " + transactions[i].getSender().getId() + " ) "
                        + transactions[i].getTransfer()
                        + " with id = " + transactions[i].getId());
            } else {
                System.out.println("From " + transactions[i].getSender().getName()
                        + "(id = " + transactions[i].getSender().getId() + " ) "
                        + transactions[i].getTransfer()
                        + " with id = " + transactions[i].getId());
            }
        }
    }

    public void command5RemoveTransaction(String line) {
        String[] splited = line.split("\\s+");
        Transaction[] transactions = ts.getTransactionListOfUser(
                Integer.parseInt(splited[0]));
        String name = "";
        Integer idOfName = 0;
        Integer summ = 0;

        if (splited.length > 2) {
            throw new IllegalArgumentException("Need only two argument!");
        }

        for (int i = 0; i < transactions.length; i++) {
            name = transactions[i].getSender().getName();
            idOfName = transactions[i].getSender().getId();
            summ = transactions[i].getTransfer();
            if (transactions[i].getId().equals(UUID.fromString(splited[1]))) {
                break;
            }
        }
        ts.removeTransaction(Integer.parseInt(splited[0]), UUID.fromString(splited[1]));
        if (summ > 0) {
            System.out.println("Transfer From " + name
                    + "(id = " + idOfName + ") " + summ + "removed");
            return;
        }
        System.out.println("Transfer To " + name
                + "(id = " + idOfName + ") " + (summ * (-1)) + " removed");
    }

    public void command6CheckTransfers() {
        Transaction[] transactions = ts.correctArrayTransaction();
        String name = "";
        String name2 = "";
        Integer idOfName = 0;
        Integer idOfName2 = 0;
        Integer summ = 0;

        if (transactions.length == 0) {
            System.out.println("No unacknowledged transfers");
            return;
        }
        for (int i = 0; i < transactions.length; i++) {
            name = transactions[i].getSender().getName();
            name2 = transactions[i].getRecipient().getName();
            idOfName = transactions[i].getSender().getId();
            idOfName2 = transactions[i].getRecipient().getId();
            summ = transactions[i].getTransfer();
            if (summ < 0) {
                summ = -1 * summ;
            }
            System.out.println(name + "(id = " + idOfName + ") "
                    + "has an unacknowledged transfer id = "
                    + transactions[i].getId() + " from " + name2
                    + "(id = " + idOfName2 + ") " + "for " + summ);
        }
    }
}
