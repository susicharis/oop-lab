package Midterm.Exercise_MostlyW4.Week_4_Lab;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return this.name + " " + this.address;
    }

}
