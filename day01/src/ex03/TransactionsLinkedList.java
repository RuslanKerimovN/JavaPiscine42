package ex03;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node tail;
    private int size;

    TransactionsLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addingTransaction(Transaction transaction) {
        if (size == 0) {
            this.head = new Node(null, null, transaction);
            this.tail = head;
        }
        else {
            this.tail.next = new Node(this.tail, null, transaction);
            this.tail = this.tail.next;
        }
        size++;
    }

    @Override
    public void removeTransactionById(UUID id) throws TransactionNotFoundException {
        Node tmp = head;

        if (head == null) {
            return;
        }
        else if (head.value.getId() == id) {
            this.head = this.head.next;
            size--;
            return;
        }
        else if (tail.value.getId() == id) {
            this.tail = this.tail.prev;
            size--;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (tmp.value.getId() == id) {
                tmp.next.prev = tmp.prev;
                tmp.prev.next = tmp.next;
                break;
            }
            if (i == size - 1) {
                throw new TransactionNotFoundException("Transaction not found!");
            }
            tmp = tmp.next;
        }
        size--;
    }

    @Override
    public Transaction[] transactionToArray() {
        Transaction[] returnedArray = new Transaction[size];
        Node tmp = head;

        for(int i = 0; i < size; i++) {
            returnedArray[i] = tmp.value;
            tmp = tmp.next;
        }
        return returnedArray;
    }
}
