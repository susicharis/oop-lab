package Exercises;

import People.Person;

public class LecutrePerson {

    private String name;
    private int age;
    // all instances created from the LecturePerson class have a name and an age
    // defining attributes is done in quite similar fashion as with normal variables
    // private - name and age will not show outside of the object, but are instead hidden within it : ENCAPSULATION

    public LecutrePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void printOutPerson() {
        System.out.println(this.name + " " + this.age);
    }

    public String toString() {
        return this.name + " " + this.age;
    }

    // vraca string koji sadrzi name i age vrijednosti te osobe, spojene u jednu smislenu recenicu
    //

    public static void main(String[] args) {
        LecutrePerson firstPerson = new LecutrePerson("Haris", 24);
        System.out.println(firstPerson.getName());
        System.out.println(firstPerson.getAge());

        firstPerson.setAge(25);
        System.out.println(firstPerson.getAge());

        firstPerson.printOutPerson(); // jos jedan nacin oopa (uljepsavanja i olaksavanja koda)

        LecutrePerson thirdPerson = new LecutrePerson("Tarik", 21);
        System.out.println(thirdPerson);

    }
}


