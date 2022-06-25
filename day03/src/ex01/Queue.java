package ex01;

public class Queue {
    private static int waiter = 0;

    public synchronized void henTalk() {
        while (waiter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hen");
        waiter--;
        notify();
    }

    public synchronized void eggTalk() {
        while (waiter == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Egg");
        waiter++;
        notify();
    }
}
