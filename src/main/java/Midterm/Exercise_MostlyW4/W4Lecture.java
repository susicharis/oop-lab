package Midterm.Exercise_MostlyW4;

import java.util.ArrayList;

public class W4Lecture {

    public static void main(String[] args) {
        int number = 1;
        addThree(number);
        System.out.println("Prije:" + number);
        // ispisati ce 1 jer ovdje nista nije promijenjeno

        number = addThree2(number);
        // da bi funkcionisalo, "number" mora primati vrijednost koju ce promjenu napraviti metoda addThree2

        System.out.println("Poslije: " + number);

        System.out.println();
        System.out.println();

        listOperations();


    }

    public static void addThree(int number) {
        number += 3;
        System.out.println(number);
        // proslijedili smo iz maina number, pravi kopiju unutar parametra, ovo ce ispisati 4
    }

    public static int addThree2(int number) {
        number += 3;
        return number;
    }



    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0);
    }

    public static void listOperations() {
        ArrayList<Integer> numbers = new ArrayList<>();
        // numbers - reference that refers to the place where the ArrayList is
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Before removing: " + numbers);

        removeFirst(numbers);

        System.out.println("After: " + numbers);
    }

}
