package ex01;

public class Program {
    public static void main(String[] args) {
        User human1 = new User("Ivan", 500);
        User human2 = new User("Evgeniy", 100);

        System.out.println("User id = " + human1.getId() +
                " Name User is " + human1.getName() + " balance User = " + human1.getBalance());

        System.out.println("User id = " + human2.getId() +
                " Name User is " + human2.getName() + " balance User = " + human2.getBalance());
    }
}
