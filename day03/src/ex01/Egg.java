package ex01;

public class Egg implements Runnable {
    private final int count;
    Queue q;

    public Egg(int count, Queue q) {
        this.count = count;
        this.q = q;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < count; i++) {
            q.eggTalk();
        }

    }
}
