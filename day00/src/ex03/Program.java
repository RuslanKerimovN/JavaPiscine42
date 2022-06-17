package ex03;

import java.util.Scanner;

public class Program {

    private static final int MAX_WEEK = 18;
    private static final int MAX_MARK = 9;
    private static final int MIN_MARK = 1;

    public static void checkStringOnValid(String str, String strCheker) {
        if (!str.equals(strCheker)) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static void checkTests(int first, int second
            , int third, int fourth, int fifth) {
        if ((first < MIN_MARK || first > MAX_MARK)
                || (second < MIN_MARK || second > MAX_MARK)
                || (third < MIN_MARK || third > MAX_MARK)
                || (fourth < MIN_MARK || fourth > MAX_MARK)
                || (fifth < MIN_MARK || fifth > MAX_MARK)) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static int searchMin(int first, int second
            , int third, int fourth, int fifth) {
        int result = first;

        if (result > second) {
            result = second;
        }
        if (result > third) {
            result = third;
        }
        if (result > fourth) {
            result = fourth;
        }
        if (result > fifth) {
            result = fifth;
        }

        return result;
    }

    public static void writeResult(long result, int numWeek) {
        long writeEquals = 0;
        int times = numWeek;

        for (int i = 1; i <= numWeek; i++, times--) {
            System.out.print("Week ");
            System.out.print(i);
            System.out.print(" ");
            writeEquals = howManyTimesToPrintEquals(result, times);
            for (int j = 0; j < writeEquals; j++) {
                System.out.print("=");
            }
            System.out.println(">");
        }
    }

    public static long howManyTimesToPrintEquals(long result, int times) {
        long returnNum = 0;

        for (int i = 0; i != times; i++) {
            returnNum = result % 10;
            result /= 10;
        }
        return  returnNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";

        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        int fifth = 0;
        int numWeek = 0;

        long result = 0;

        for (int i = 0; i < MAX_WEEK; i++) {
            str = scanner.next();
            if (str.equals("42")) {
                break;
            }
            checkStringOnValid(str, "Week");
            numWeek = scanner.nextInt();
            if (numWeek != (i + 1)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            first = scanner.nextInt();
            second = scanner.nextInt();
            third = scanner.nextInt();
            fourth = scanner.nextInt();
            fifth = scanner.nextInt();
            checkTests(first, second, third, fourth, fifth);
            result = result * 10 + searchMin(first, second, third, fourth, fifth);
        }
        writeResult(result, numWeek);
    }
}
