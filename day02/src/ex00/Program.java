package ex00;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static HashMap<String, String> readSignatures() {
        HashMap<String, String> signatures = new HashMap<>();
        String[] splited = null;
        int chars = 0;

        try {
            FileInputStream inputStream = new FileInputStream(new File("src/ex00/signatures.txt"));
            StringBuilder string = new StringBuilder();
            while ((chars = inputStream.read()) != -1) {
                if (chars == '\n') {
                    splited = string.toString().split(", ");
                    signatures.put(splited[1], splited[0]);
                    string.setLength(0);
                    continue;
                } else {
                    string.append((char) chars);
                }
                if (inputStream.available() == 0) {
                    splited = string.toString().split(", ");
                    signatures.put(splited[1], splited[0]);
                }
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return signatures;
    }

    public static void main(String[] args) throws IOException {
        HashMap<String, String> signatures = readSignatures();
        Scanner scanner = new Scanner(System.in);
        String stringOfScanner = "";
        StringBuilder makeHEX = new StringBuilder();
        boolean isFind = false;
        FileInputStream readFile = null;
        FileOutputStream resultFile = null;

        while (true) {
            isFind = false;
            makeHEX.setLength(0);
            stringOfScanner = scanner.nextLine();
            if (stringOfScanner.equals("42")) {
                break;
            }

            try {
                resultFile = new FileOutputStream("src/ex00/result.txt", true);
                readFile = new FileInputStream(stringOfScanner);

                for (int i = 0; readFile.available() > 0 && i < 8; i++) {
                    makeHEX.append(String.format("%02X", readFile.read()));
                    makeHEX.append(' ');
                }
                for (Map.Entry<String, String> entry : signatures.entrySet()) {
                    if (makeHEX.toString().startsWith(entry.getKey())) {
                        isFind = true;
                        resultFile.write(entry.getValue().getBytes(StandardCharsets.UTF_8));
                        resultFile.write('\n');
                        System.out.println("PROCESSED");
                        break;
                    }
                }
                if (!isFind) {
                    System.out.println("UNDEFINED");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (resultFile != null) {
            resultFile.close();
        }
        if (readFile != null) {
            readFile.close();
        }
        scanner.close();
    }
}
