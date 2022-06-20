package ex00;

import java.util.UUID;

public class Transaction {
    private String id;
    private User recipient;
    private User sender;
    private String category;
    private Integer transfer;

    public Transaction() {}

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

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

    public void setRecipient(User recipient) { this.recipient = recipient; }

    public void setSender(User sender) { this.sender = sender; }

    public void setCategory(String category) { this.category = category; }

    public void setTransfer(Integer transfer) {
        if (category.equals("IN")) {
            this.transfer = transfer;
        }
        else if (category.equals("OUT")) {
            this.transfer = -1 * transfer;
        }
    }
}
