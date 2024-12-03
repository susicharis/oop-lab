package W7Lecture;

interface Printable {
    public void print();
}


/*
class Main {

    public static void printThing(Printable thing) {
        thing.print();
    }
    public static void performAction(Runnable action) {
        action.run();
    }

    public static void main(String[] args)  {

       // Cat cat = new Cat();
       // printThing(cat);


        Printable cat = () -> System.out.println("I'm a cat!");
        printThing(cat);

        performAction( () -> System.out.println("Hello! Performing Action..") );
        // prvi list (fizicki) -> lambdas providea slj funkcionalnosti : tretiranje funkcionalnosti kao argumenta metode


    }
}

*/

class Run {

    public static void printThing(Printable thing) {
        thing.print();
    }

    public static void main(String[] args) {
        Printable printable = () -> {
            System.out.println("Hey guys!");
        };
        printThing(printable);


    }
}


