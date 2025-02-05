package Midterm.Exercise_MostlyW4.W5_Practice;
// Slide 2 -
public class Person implements Readable{
    private String name;
    private int age;
    private int weight;
    private int height;

    // object within object
    private myDate myDateOfBirth;


//    public Person(String name) {
//        this(name, 18);
//    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }



    public Person(String name, int age, myDate myDateOfBirth) {
        this.name = name;
        this.age = age;
        this.myDateOfBirth = myDateOfBirth;
        // mozemo i ovako uraditi:
        this.myDateOfBirth = new myDate(10,8,2004);
        this.weight = 70;
        this.height = 180;
    }

    public void becomeOlder() {
        this.age += 1;
    }
    public void becomeOlder(int years) {
        this.age += years;
    }

    // Metoda za interface
    public String read() {
        return this.name + " " + this.age + " " + this.myDateOfBirth;
    }

    public String readThis() {
        return this.name + " " + this.age + " " + this.myDateOfBirth;
    }


    // Metoda koja prima objekat iste klase, kao parametar
    public boolean isOlderThan(Person proslijedjenaOsoba) {
        if (this.age > proslijedjenaOsoba.getAge()) {
            return true;
        } return false;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.myDateOfBirth;
    }

    public static void main(String[] args) {
//        Person person1 = new Person("Haris",20);
//        Person person2 = new Person("Becir");
//
//        System.out.println(person1.getAge());
//        System.out.println(person2.getAge());
//        System.out.println(person1);
//
//        person1.becomeOlder(10);
//        System.out.println("He is now 10 years older: " + person1);
//
//        person2.becomeOlder();
//        System.out.println("Becir just grew for 1 year because of other method: " + person2);
//
//
//        // Object Reference
//        System.out.println("Object reference: \n");
//        Person pekka = new Person("Pekka", 24);
//        System.out.println(pekka);
//
//        Person randomPerson = pekka;
//        randomPerson.becomeOlder();
//        System.out.println(pekka);
//
//        // Deattaching Object Reference
//        System.out.println("Deattaching object reference: \n");
//        pekka = new Person("New Pekka", 26);
//        System.out.println(pekka);
//        System.out.println(randomPerson);
//
//        System.out.println(person1.isOlderThan(person2));

        // Object within the object
        System.out.println("Object within the object: \n");
        myDate myDateOfBirth = new myDate(30,8,2004);
        Person person3 = new Person("Haris",18,myDateOfBirth);
        System.out.println(person3);

    }

}
