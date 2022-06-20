package ex00;

import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User human1 = new User();
        User human2 = new User();
        Transaction transaction = new Transaction();
        Transaction transaction2 = new Transaction();

        human1.setId(1);
        human1.setName("Timofey");
        human1.setBalance(1000);

        human2.setId(2);
        human2.setName("Serafim");
        human2.setBalance(5000);

        transaction.setId(UUID.randomUUID().toString());
        transaction.setRecipient(human1);
        transaction.setSender(human2);
        transaction.setCategory("IN");
        transaction.setTransfer(500);

        transaction2.setId(UUID.randomUUID().toString());
        transaction2.setRecipient(human1);
        transaction2.setSender(human2);
        transaction2.setCategory("OUT");
        transaction2.setTransfer(500);

        System.out.println("User id = " + human1.getId() +
                " Name User is " + human1.getName() + " balance User = " + human1.getBalance());

        System.out.println("Transaction id = " + transaction.getId()
                + " name human1 is " + transaction.getRecipient().getName()
                + " name human2 is  " + transaction.getSender().getName()
                + " Transaction category is " + transaction.getCategory()
                + " Transaction transfer = " + transaction.getTransfer());

        System.out.println("Transaction2 id = " + transaction2.getId()
                + " name human1 is " + transaction2.getRecipient().getName()
                + " name human2 is  " + transaction2.getSender().getName()
                + " Transaction2 category is " + transaction2.getCategory()
                + " Transaction2 transfer = " + transaction2.getTransfer());
    }
}
