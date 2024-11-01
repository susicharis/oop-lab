package Exercises;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public void becomeOlder() {
        this.age++;
    }

    public boolean isAdult() {
        if (this.age < 18) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Person first = new Person("Haris", 24);
        Person second = new Person("Becir", 30);

        System.out.println("Becirove godine prije rodjendana: " + second.getAge());
        second.becomeOlder();
        System.out.println("Becirove godine poslije rodjendana: " + second.getAge());

        System.out.println("Age of becir: " + second.getAge());
        System.out.println("Age of Haris: " + first.getAge());

        int total = first.getAge() + second.getAge();
        System.out.println("Total age: " + total);

        System.out.println(first.isAdult());




    }
}
