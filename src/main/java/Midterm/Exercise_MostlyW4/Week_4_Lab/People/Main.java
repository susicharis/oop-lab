package Midterm.Exercise_MostlyW4.Week_4_Lab.People;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);


        Student olli = new Student("Olli", "Ida Albergintie Street 1");
        System.out.println(olli);
        System.out.println("credits: " + olli.credits());
        olli.study();
        System.out.println("credits: " + olli.credits());

        System.out.println();

        Teacher pekka2 = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko2 = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println(pekka2);
        System.out.println(esko2);

        List<Person> people = new ArrayList<Person>();
        people.add(new Teacher("Haris", "Izacic BB, Bihac 77208"));
        people.add(new Student("Tarik", "Sarajevo Ilidza 21222"));
        printDepartment(people);

        Circle circle = new Circle("Red", FillType.FILLED, 5.0);
        circle.displayInfo();


        Rectangle rectangle = new Rectangle("Blue", FillType.NOT_FILLED, 4.0, 6.0);
        rectangle.displayInfo();

    }


    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }




}