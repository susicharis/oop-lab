package W5Lecture;

import java.util.Calendar;

public class Person2 {
    private String name;
    private int age;
    private int height;
    private int weight;
    private myDate dateOfBirth;

    public Person2 (String name, int day, int month, int year) {
        this.name = name;
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        this.dateOfBirth = new myDate(day,month,year);
    }

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return this.name + " " + this.age;
    }



    public static void main(String[] args) {
        Person2 osoba = new Person2("Haris", 30, 8, 2004);
        System.out.println(osoba);

        /*
        Calendar.getInstance() - kreira instancu objekta Calendar koja sadrzi
        trenutni datum i vrijeme.
        get(Calendar.DATE); - vraca vrijednost dana u mjesecu.
         */
        int day = Calendar.getInstance().get(Calendar.DATE);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        System.out.println("Today is day: " + day + " , month: " + month + " , year: " + year);
    }
}
