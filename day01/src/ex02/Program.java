package ex02;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws UserNotFoundException,
            ArrayIndexOutOfBoundsException, IndexOutOfBoundsException {
        UsersArrayList list = new UsersArrayList();

        User U1 = new User("Ivan", 500);
        User U2 = new User("Sergey", 500);
        User U3 = new User("Semyon", 500);
        User U4 = new User("Galya", 500);
        User U5 = new User("Olga", 500);
        User U6 = new User("Vadim", 500);
        User U7 = new User("Kirill", 500);
        User U8 = new User("Petya", 500);
        User U9 = new User("Vova", 500);
        User U10 = new User("Ruslan", 500);
        User U11 = new User("Max", 500);
        User U12 = new User("Nikita", 500);
        list.addingUsers(U1);
        list.addingUsers(U2);
        list.addingUsers(U3);
        list.addingUsers(U4);
        list.addingUsers(U5);
        list.addingUsers(U6);
        list.addingUsers(U7);
        list.addingUsers(U8);
        list.addingUsers(U9);
        list.addingUsers(U10);
        list.addingUsers(U11);
        list.addingUsers(U12);

        System.out.println(Arrays.toString(list.getArray()));
        System.out.println(list.getUserById(5));
        System.out.println(list.getUserByIndex(5));
        System.out.println(list.valueUsers());

        System.out.println(list.getUserById(500));

    }
}
