package Midterm.Exercise_MostlyW4.W5Lecture;

import java.util.ArrayList;

public class ArrayListOfObjects {

    public static void main(String[] args) {
        ArrayList<Person> first = new ArrayList<Person>();
        first.add(new Person("Haris"));
        first.add(new Person("Tarik"));

        for (Person person : first) {
            System.out.println(person);
        }
    }

}
