package Midterm.Exercise_MostlyW4.W5Lecture;

import java.util.Calendar;

public class FBClubPerson{
    private String name;
    private int age;


    public FBClubPerson (String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }



    public static void main(String[] args) {



    }
}
