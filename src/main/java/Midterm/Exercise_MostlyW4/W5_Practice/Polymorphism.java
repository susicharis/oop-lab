package Midterm.Exercise_MostlyW4.W5_Practice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Polymorphism {

    public static void printManyTimes(Object objectParameter, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(objectParameter.toString());
        }
    }

    public static void polymorphicBehaviour() {
        Serializable serializableString = new String("String Seriazible");
        CharSequence charSequenceString = "String CharSequence";
        Comparable<String> comparableString = "String Comparable";
    }

    public static void main(String[] args) {

        String string = "String";
        Object string1 = "Another String";
        Object string2 = "One more";
      // String string3 = string2; // Ovo nije, isto objasnjeno Class Polymorphism-Helper
        Object string4 = string; // Ovo je dozvoljeno, objasnjeno Class Polymorphism-Helper



        Dog firstDog = new Dog("Kero");
        System.out.println(firstDog.eat());
        System.out.println(firstDog.play());

        List<String> words = new ArrayList<String>();
        words.add("Polimorfizam");
        words.add("Abstraction");
        words.add("Inheritance");
        words.add("Encapsulation");

        printManyTimes("Haris",5);
        printManyTimes(words,5);

        System.out.println("Serializable + Comparable: \n");
        MyClass objectOne = new MyClass("Data One",10);
        MyClass objectTwo = new MyClass("Data Two", 20);

        // kreiramo objekat CompClass
        CompClass objectCC = new CompClass(15);

        System.out.println("Comparison results: " + objectCC.compareTo(objectOne));
        System.out.println("Comarpsion results 2: " + objectCC.compareTo(objectTwo));

        System.out.println(objectOne);
        System.out.println(objectTwo);
        System.out.println(objectCC);






    }
}

interface Animal {
    String eat();
}
interface Pet {
    String play();
}

class Dog implements Animal,Pet {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String eat() {
        return "He eats!";
    }
    public String play() {
        return "He plays!";
    }
}


// Serializable
class MyClass implements Serializable {
    private String data;
    private int value;

    public MyClass(String data, int value) {
        this.data = data;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data + this.value;
    }
}

// CompClass implementira Comparable<MyClass>
class CompClass implements Comparable<MyClass> {
    int value;

    public CompClass(int value) {
        this.value = value;
    }

    // Implementacija metode compareTo
    @Override
    public int compareTo(MyClass something) {
        return Integer.compare(this.value, something.getValue());
    }

    @Override
    public String toString() {
        return "Value= " + this.value;
    }
}