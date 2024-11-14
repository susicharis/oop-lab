package W5_Practice.Upcasting_and_Downcasting;

public class Animals {
    String name;

    public void makeNoise() {
        System.out.println("I am making noise!");
    }
}


class Dogs extends Animals {
    public void makeNoise() {
        System.out.println("This dog barks");
    }
    public void growl() {
        System.out.println("This dog growls");
    }
}


class Cats extends Animals {
    public void makeNoise() {
        System.out.println("Im me(o)wing..");
    }
    public void purr() {
        System.out.println("Im purri(fyi)ng..");
    }
}


class Main {
    public static void doAnimalStuff(Animals animals) {
        animals.makeNoise();

        if (animals instanceof Dogs) {
            Dogs myDog = (Dogs) animals;
            myDog.growl();
        }


    }

    public static void main(String[] args) {
        Animals myDog = new Dogs();
        myDog.makeNoise();

        doAnimalStuff(myDog);




    }
}
