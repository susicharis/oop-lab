package W5_Practice.AbstractCLASS;
import java.util.Scanner;

abstract class Operation {
    private String name;

    public Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    abstract void execute(Scanner reader);
    // abstract metoda

}


class Addition extends Operation {

    public Addition(String name) {
        super(name);
    }

    @Override
    public void execute(Scanner reader) {
        System.out.print("Give the first number: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.print("Give the second number: ");
        int second = Integer.parseInt(reader.nextLine());

        System.out.println("The sum is " + (first + second));

    }
}

class Multiplication extends Operation {
    public Multiplication() {
        super("Multiplication");
    }

    @Override
    public void execute(Scanner reader) {
        System.out.println("Give the first number: ");
        int first = Integer.parseInt(reader.nextLine());
        System.out.println("Give the second number: ");
        int second = Integer.parseInt(reader.nextLine());

        System.out.println("The multiplication is: " + (first * second));
    }
}

class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operation operationOne = new Addition("Haris");
        operationOne.execute(scanner);

        Operation operationTwo = new Multiplication();
        operationTwo.execute(scanner);
    }
}
