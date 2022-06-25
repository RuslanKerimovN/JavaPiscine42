package ex01;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Illegal arguments");
            System.exit(-1);
        }

        String string = args[0].substring(8);
        int value = Integer.parseInt(string);

        Queue queue = new Queue();

        Thread egg = new Thread(new Egg(value, queue));
        Thread hen = new Thread(new Hen(value, queue));

        egg.start();
        hen.start();
    }
}
