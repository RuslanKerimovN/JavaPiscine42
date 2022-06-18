package ex04;

import java.util.Arrays;
import java.util.Scanner;

public class Program {

    private static final int MAX_SIZE_GRAPH = 10;
    private static final int MAX_COMMING = 999;

    public static boolean isArrayHaveThisChar(char c, char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c)
                return true;
        }
        return false;
    }

    public static char[] increaseArray(char[] chars, char c) {
        char[] tmpArray = new char[chars.length + 1];

        tmpArray[0] = c;
        for (int i = 0, j = 1; i < chars.length; i++, j++) {
            tmpArray[j] = chars[i];
        }
        return tmpArray;
    }

    public static int[] plusQuantityRepeatChars(int[] quantityRepeatChars, char[] chars, char c) {

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                quantityRepeatChars[i] += 1;
                if (quantityRepeatChars[i] > MAX_COMMING) {
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
            }
        }
        return quantityRepeatChars;
    }

    public static void bubbleSortCharAndIntArray(int[] quantityRepeatChars, char[] chars) {
        int tmp = 0;
        char tmpChar = 0;

        for (int i = 1; i < quantityRepeatChars.length; i++) {
            for (int j = 0; j < quantityRepeatChars.length - i; j++) {
                if (quantityRepeatChars[j] < quantityRepeatChars[j + 1]) {
                    tmp = quantityRepeatChars[j];
                    quantityRepeatChars[j] = quantityRepeatChars[j + 1];
                    quantityRepeatChars[j + 1] = tmp;
                    tmpChar = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = tmpChar;
                }
            }
        }
        for (int i = 0; i < quantityRepeatChars.length - 1; i++) {
            if (quantityRepeatChars[i] == quantityRepeatChars[i + 1] && chars[i] > chars[i + 1]) {
                tmpChar = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = tmpChar;
            }
        }
    }

    public static void writerChart(int[] quantityRepeatChars, char[] chars) {
        int lenght = chars.length >= MAX_SIZE_GRAPH ? MAX_SIZE_GRAPH : chars.length;

        int[] tmpArray = arrayGraph(quantityRepeatChars);

        for (int i = 0; i < MAX_SIZE_GRAPH + 1; i++) {
            for (int j = 0; j < lenght; j++) {
                if (tmpArray[j] == MAX_SIZE_GRAPH - i) {
                    System.out.print(quantityRepeatChars[j] + "\t");
                }
                else if (tmpArray[j] <= MAX_SIZE_GRAPH - i) {
                    break;
                }
                else if (tmpArray[j] > MAX_SIZE_GRAPH - i) {
                    System.out.print("#" + "\t");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < MAX_SIZE_GRAPH; i++) {
            System.out.print(chars[i] + "\t");
        }
    }

    public static int[] arrayGraph(int[] quantityRepeatChars) {
        int size = MAX_SIZE_GRAPH;
        int max = quantityRepeatChars[0];

        int[] returnArray = new int[quantityRepeatChars.length];

        for (int i = 0; i < quantityRepeatChars.length; i++) {
            returnArray[i] = quantityRepeatChars[i] * MAX_SIZE_GRAPH / max;
        }
        return returnArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        char[] stringArray = string.toCharArray();

        char[] chars = {stringArray[0]};

        int[] quantityRepeatChars = new int[0];

        for (int i = 1; i < stringArray.length; i++) {
            if (!isArrayHaveThisChar(stringArray[i], chars)) {
                chars = increaseArray(chars, stringArray[i]);
            }
        }
        quantityRepeatChars = new int[chars.length];
        for (int i = 0; i < stringArray.length; i++) {
            plusQuantityRepeatChars(quantityRepeatChars, chars, stringArray[i]);
        }
        bubbleSortCharAndIntArray(quantityRepeatChars, chars);
        writerChart(quantityRepeatChars, chars);

        System.out.println();
    }
}
