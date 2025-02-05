package Midterm.Exercise_MostlyW4.W5_Practice;

public class Test {
    private String name;
    private int age;
    private myDate date_of_birth;

    public Test(String name, int age, myDate date_of_birth) {
        this.name = name;
        this.age = age;
        this.date_of_birth = date_of_birth;
    }

    public myDate getDate_of_birth () {
        return this.date_of_birth;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.date_of_birth;
    }

    public static void main(String[] args) {
        myDate birthDate = new myDate(30,8,2004);
        Test testnaOsoba = new Test("Haris",30,birthDate);

        // mi "birthDate" proslijedjujemo u KONSTRUKTOR, gdje ga prima kao "date_of_birth"
        /*
        Kad kreiramo objekt testnaOsoba, proslijedjujemo objekat birthDate u KONSTRUKTOR, ALI UNUTAR KONSTRUKTORA
        JE IGNORISAN JER VEC IMAMO DODIJELJEN "new myDate(15,8,2004);" , I ZATO SE NE KORISTI PROSLIJEDJENI OBJEKAT
        DA BI SE KORISTIO PROSLIJEDJENI OBJEKAT : "this.date_of_birth = date_of_birth;" OVAKO MORA BITI NAPISANO !!
         */

        System.out.println(testnaOsoba.getDate_of_birth());
    }
}
