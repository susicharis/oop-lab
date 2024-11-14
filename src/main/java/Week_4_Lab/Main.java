package Week_4_Lab;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki");
        System.out.println(pekka);
        System.out.println(esko);


        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());


        Teacher pekka2 = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200);
        Teacher esko2 = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400);
        System.out.println( pekka2 );
        System.out.println( esko2 );

        Student olli3 = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki: ");

            olli3.study2();

        System.out.println( olli3 );

        System.out.println();

        List<Person> people = new ArrayList<Person>();
        people.add( new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add( new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );
        printDepartment(people);
    }


    public static void printDepartment(List<Person> people) {
        for (Person persons : people) {
            System.out.println(persons);
        }

    }





}

