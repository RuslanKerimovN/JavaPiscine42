package ex01;

public class User {
    private final Integer id;
    private String name;
    private Integer balance;

    User(String name, Integer balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        if (balance < 0) {
            balance = 0;
        }
        this.balance = balance;
    }
}
