package W5Lecture;

import java.util.Calendar;

public class FBClubPerson{
    private String name;
    private int age;


    public FBClubPerson (String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }



    public static void main(String[] args) {



    }
}
