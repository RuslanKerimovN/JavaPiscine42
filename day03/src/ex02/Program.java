package ex02;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private static final int MAX_VALUE = 1000;
    private static final int MAX_ARRAY = 2000000;

    public static void main(String[] args) {
        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            System.err.println("Illegal arguments");
            System.exit(-1);
        }

        int lengthArray = Integer.parseInt(args[0].substring(12));
        int valueThreads = Integer.parseInt(args[1].substring(15));
        int sum = 0;

        if (lengthArray > MAX_ARRAY || valueThreads > lengthArray) {
            System.err.println("Illegal arguments");
            System.exit(-1);
        }

        List<Integer> arrayList = new ArrayList<>();
        MyThread[] arrayThread = new MyThread[valueThreads];

        for (int i = 0; i < lengthArray; i++) {
            arrayList.add((int) (Math.random() * MAX_VALUE));
            sum += arrayList.get(i);
        }
        System.out.println("Sum is : " + sum);

        for (int i = 0; i < arrayThread.length; i++) {
            arrayThread[i] = new MyThread(arrayList, valueThreads);
            arrayThread[i].start();
        }
        for (int i = 0; i < arrayThread.length; i++) {
            try {
                arrayThread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum by threads: " + MyThread.getResult());
    }
}
