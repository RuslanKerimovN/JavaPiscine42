package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int value = 2;
        int count = 1;

        if (num <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }

        if (num == 2) {
            System.out.println("true " + 1);
            System.exit(1);
        }

        if (num % 2 == 0) {
            System.out.println("false " + 1);
            System.exit(1);
        }

        while ((value * value < num) && (num % value > 0)) {
            value++;
            count++;
        }

        if (value * value > num) {
            System.out.println("true " + count);
        }
        else {
            System.out.println("false " + count);
        }
    }
}
