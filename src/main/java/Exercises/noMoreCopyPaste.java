package Exercises;

import java.util.ArrayList;




public class noMoreCopyPaste {

    public static void objectsExample(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Finland");
        countries.add("Sweden");
        countries.add("Germany");
        cities.add("New York");
        cities.add("North America");
        cities.add("South America");
        cities.add("Europe");

        System.out.println("Number of cities: " + cities.size());
        System.out.println("Number of countries: " + countries.size());

    }


    public static void main(String[] args) {

        objectsExample(args);


        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println("Numbers before removaL: ");
        getRidOfCopyPaste(numbers);

        removeNumber(numbers, 2);



        System.out.println("Numbers after removaL: ");
        getRidOfCopyPaste(numbers);



    }

    public static void getRidOfCopyPaste(ArrayList<Integer> numbers) {
        for (int brojac : numbers) {
            System.out.println(brojac);
        }
    }

    public static void removeNumber(ArrayList<Integer> numbers, int removed) {
        while(numbers.contains(Integer.valueOf(removed))) {
            numbers.remove(Integer.valueOf(removed));
        }
    }






}
