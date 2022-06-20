package ex03;

public class Node {
    Transaction value;
    Node next;
    Node prev;

    Node(Node prev, Node next, Transaction value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}
