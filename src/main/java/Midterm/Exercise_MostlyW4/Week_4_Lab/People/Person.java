package Midterm.Exercise_MostlyW4.Week_4_Lab.People;

public class Person {
    private String name;
    private String address;
    private int age;
    private String country;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
        this.age = 0;
        this.country = "";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() { // nadjacana metoda kako bi vratila string objekta Person, koja sadrzi ime i adresu
        // kad pozovemo na ovom objektu, prikazuje se ovaj format zbog toString()
        return name + " " + address + " " + age + " " + country;
    }
}