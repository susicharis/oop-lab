package Midterm.Exercise_MostlyW4.W5Lecture;

public class ObjectReference {

    private String name;
    private int age;
    private int weight;
    private int height;

    public ObjectReference(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.height = 0;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " ";
    }

    public void becomeOlder() {
        this.age++;
    }

    public boolean olderThan(ObjectReference comparedPerson) {
        if(this.age > comparedPerson.getAge()) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        ObjectReference pekka = new ObjectReference("Pekka", 24);
        System.out.println(pekka);

        // oba objekta pokazuju na iste atribute od klase!
        // nismo kreirali novi objekat, samo smo ga referencirali na isti objekat!
        ObjectReference istaOsoba = pekka;
        istaOsoba.becomeOlder(); // mijenja age istog objekta (istog atributa, iste klase)
        System.out.println(istaOsoba);

        // detaching a wire - pointa na novi memory location : kreiramo novi objekat (new)
        pekka = new ObjectReference("Pekka", 19);
        System.out.println(pekka);
        System.out.println(istaOsoba);

        System.out.println();

        ObjectReference becir = new ObjectReference("Becir", 18);
        // Another object of the same type as a parameter to a method
        if(istaOsoba.getAge() > becir.getAge()) {
            System.out.println(istaOsoba.getName() + " is older than " + becir.getName());
        }

        ObjectReference tarik = new ObjectReference("Tarik", 18);
        ObjectReference samed = new ObjectReference("Samed", 16);

        if(tarik.olderThan(samed)) {
            System.out.println(tarik.getName() + " is older than " + samed.getName());
        }





        // Person pekka = null; // NullPointerException


    }

}
