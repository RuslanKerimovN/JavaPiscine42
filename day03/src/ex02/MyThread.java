package ex02;

import java.util.List;

public class MyThread extends Thread{
    private static List<Integer> list;
    private static int sizeStep;
    private static int result = 0;
    private static int queue = 0;
    private static int ScoreThreads = 0;
    private static int valueThreads;
    private static int sss = -1;

    public static int getResult() {
        return result;
    }

    MyThread(List<Integer> list, int valueThreads) {
        this.list = list;
        this.valueThreads = valueThreads;
        sizeStep = (int) Math.ceil((double) list.size() / valueThreads);
    }

    @Override
    public void run() {
        working();
    }

    static synchronized void working() {
            int scoreLoop;
            int from = queue;
            int res = 0;

            if (valueThreads - ScoreThreads == 1) {
                scoreLoop = list.size() - queue;
            }
            else {
                scoreLoop = sizeStep;
            }
            for (int i = 0; i < scoreLoop; queue++, i++) {
                ++sss;
                res += list.get(queue);
                result += list.get(queue);
            }
            ScoreThreads++;
            System.out.println("Thread "+ ScoreThreads + ": from " + from + " to " + sss + " sum is " + res);
        }
    }
