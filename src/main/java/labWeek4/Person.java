package labWeek4;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
        // prazan for inheritance
    }

    @Override
    public String toString() {
        return "name: " + name + ", address: " + address;
    }
}
