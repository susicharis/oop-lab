package labWeek4;
import labWeek4.Person;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Person person1 = new Person("Haris Susic", "Francuske Revolucije");
        Person person2 = new Person("Timur Puzo", "Konjodorska Ulica");
        System.out.println(person1);
        System.out.println(person2);

        List<Person> persons = new ArrayList<>();
        persons.add(new Teacher("Pekka Mikkola", "korsontie Street 1", 1200));
        persons.add(new Student("Olli", "Ida Albergintie Street 1"));
        printDepartment(persons);
    }

    public static void printDepartment(List<Person> people) {
        for (Person person : people) {
            System.out.println(person);
        }
    }


}
