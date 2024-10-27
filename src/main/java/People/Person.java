package People;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() { // nadjacana metoda kako bi vratila string objekta Person, koja sadrzi ime i adresu
        // kad pozovemo na ovom objektu, prikazuje se ovaj format zbog toString()
        return name + " " + address;
    }
}