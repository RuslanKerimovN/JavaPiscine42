package ex05;

import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        Menu menu = new Menu();
        int index = 0;
        boolean baseOrFullVersion = false;
        if (args[0].equals("--profile=dev")) {
            baseOrFullVersion = true;
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
                menu.showMenu();
                String commandNumber = scanner.nextLine();
                try {
                    switch (Integer.parseInt(commandNumber)) {
                        case (1):
                            System.out.print("Enter a user name and a balance\n-> ");
                            menu.command1AddUser(scanner.nextLine(), index);
                            index++;
                            break;
                        case (2):
                            System.out.print("Enter a user ID\n-> ");
                            menu.command2GetBalanceUser(scanner.nextLine());
                            break;
                        case (3):
                            System.out.print("Enter a sender ID, a recipient ID, and a transfer amount\n-> ");
                            menu.command3MakeTransaction(scanner.nextLine());
                            break;
                        case (4):
                            System.out.print("Enter a user ID\n-> ");
                            menu.command4ShowTransactions(scanner.nextLine());
                            break;
                        case (5):
                            if (baseOrFullVersion) {
                                System.out.print("Enter a user ID and a transfer ID\n-> ");
                                menu.command5RemoveTransaction(scanner.nextLine());
                            }
                            else {
                                System.out.println("Sorry, no rules!");
                            }
                            break;
                        case (6):
                            if (baseOrFullVersion) {
                                System.out.println("Check results:");
                                menu.command6CheckTransfers();
                            }
                            else {
                                System.out.println("Soryy, no rules!");
                            }
                            break;
                        case (7):
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Incorrect value!");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            System.out.println("---------------------------------------------------------");
        }
    }
}