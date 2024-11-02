package W5Lecture;

public class Person {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Person(String name) {
            this.name = name;
            this.age = 0;
            this.weight = 0;
            this.height = 0;

    //     this(name,0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.height = 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " ";
    }




    public static void main(String[] args) {
        Person osoba = new Person("Haris");
        Person osoba2 = new Person("Harke", 24);

        System.out.println(osoba);
        System.out.println(osoba2);

        Person osoba3 = new Person("Hare");
        // postavlja godine na 0, jer poziva drugi konstruktor koji je setan da stavi godine = 0 (default)
        System.out.println(osoba3);
    }

}
