package ex04;

import java.util.UUID;

public class Transaction {
    private final UUID id;
    private User recipient;
    private User sender;
    private String category;
    private Integer transfer;

    public Transaction(User recipient, User sender,
                       String category, Integer transfer) {
        this.id = UUID.randomUUID();
//        System.out.println(id); //for checking
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        setTransfer(transfer);
    }

    public Transaction(UUID uuid, User recipient, User sender,
                       String category, Integer transfer) {
        this.id = uuid;
//        System.out.println(id); //for checking
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        setTransfer(transfer);
    }

    public UUID getId() {
        return id;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getCategory() {
        return category;
    }

    public Integer getTransfer() {
        return transfer;
    }

    private void setCategory(String category) {
        if (category.equals("IN") || category.equals("OUT")) {
            this.category = category;
        }
        else {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }

    public void setTransfer(Integer transfer) {
        if (category.equals("IN")) {
            this.transfer = transfer;
        }
        else if (category.equals("OUT")) {
            this.transfer = -1 * transfer;
        }
    }

    @Override //for checking
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                '}';
    }
}
