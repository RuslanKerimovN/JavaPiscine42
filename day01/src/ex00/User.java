package ex00;

public class User {
    private Integer id;
    private String name;
    private Integer balance;

    User() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public void setId(Integer id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            balance = 0;
        }
        this.balance = balance;
    }
}
