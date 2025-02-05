package Midterm.Exercise_MostlyW4;

import java.util.ArrayList;

public class ArrayAsParameter {


    public static void listOperations() {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println(numbers);

        removeFirst(numbers);

        System.out.println("After: " + numbers);
    }

    public static void removeFirst(ArrayList<Integer> list) {
        list.remove(0);
    }




    // --------------- Main

    public static void main(String[] args) {
        listOperations();

        System.out.println();

        // Ovaj dole kod je copy-paste , mozemo bolje uraditi ovo koristeci metode

        ArrayList<Integer> brojevi = new ArrayList<>();
        brojevi.add(2);
        brojevi.add(3);
        brojevi.add(4);
        brojevi.add(5);



        System.out.println("Numbers in the beginning: ");
        for (int brojac : brojevi) {
            System.out.println(brojac);
        }

        while(brojevi.contains(Integer.valueOf(3))) {
            brojevi.remove(Integer.valueOf(3));
        }

        System.out.println("Numbers after the removal: ");
        for (int brojac2 : brojevi) {
            System.out.println(brojac2);
        }




    }
}


