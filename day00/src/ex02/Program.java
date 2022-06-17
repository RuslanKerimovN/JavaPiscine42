package ex02;

import java.util.Scanner;

public class Program {

    static int returnedSumNumber(int value) {
        int sumNumber = 0;
        for (int i = 0; value > 0; i++) {
            sumNumber += value % 10;
            value /= 10;
        }
        return sumNumber;
    }

    static boolean isCupOrNot(int sumNumber) {
        for (int i = 2; i < sumNumber; i++) {
            if (sumNumber % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int value;

        while (true) {
            value = scanner.nextInt();
            if (value <= 0) {
                System.err.println("Illegal Argument");
                System.exit(-1);
            }
            if (value == 42) {
                System.out.println("Count of coffee-request - " + sum);
                System.exit(1);
            }
            value = Program.returnedSumNumber(value);
            if (Program.isCupOrNot(value))
                sum++;
        }
    }
}
