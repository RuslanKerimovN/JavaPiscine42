package ex00;

public class Program {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Illegal arguments");
            System.exit(-1);
        }

        String string = args[0].substring(8);
        int value = Integer.parseInt(string);

        Thread egg = new Thread(new Egg(value));
        Thread hen = new Thread(new Hen(value));

        egg.start();
        hen.start();

        egg.join();
        hen.join();

        for (int i = 0; i < value; i++) {
            System.out.println("Human");
        }

    }
}
