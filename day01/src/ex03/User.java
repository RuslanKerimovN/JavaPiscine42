package ex03;

public class User {
    private final Integer id;
    private String name;
    private Integer balance;
    private TransactionsList transactionsList;

    User(String name, Integer balance) {
        this.id = UserIdsGeneratot.getInstance().generateId();
        this.name = name;
        setBalance(balance);
        this.transactionsList = new TransactionsLinkedList();
    }

    public Integer getId() { return id; }

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

    public TransactionsList getTransactionsList() { return transactionsList; }

    public void setTransactionsList(TransactionsList transactionsList) {
        this.transactionsList = transactionsList;
    }
}
