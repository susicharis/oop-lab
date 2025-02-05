package Midterm.Exercise_MostlyW4.W5_Practice.Upcasting_and_Downcasting;

public class Animal {
    String name;

    public void makeNoise() {
        System.out.println("I am just an Animal");
    }
}

class Dog extends Animal {

    public void makeNoise() {
        System.out.println("Woof woof");
    }

    public void growl() {
        System.out.println("Grrrrr..");
    }
}

class Cat extends Animal {

    public void makeNoise() {
        System.out.println("Meow Meow Gigga!");
    }
}

class Casting {

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();

//        if (animal instanceof Dog) {
//            // Downcasting Animal to Dog
//            Dog myDog = (Dog) animal;
//            myDog.growl();
//        }




    }

    public static void main(String[] args) {

        Cat myCat = new Cat();
        doAnimalStuff(myCat);

        Animal myDog = new Dog();
        doAnimalStuff(myDog);


    }
}
