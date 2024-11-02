package W5Lecture;



public class MethodOverload {

    private String name;
    private int age;
    private int weight;
    private int height;

    public MethodOverload(String name) {
        this.name = name;
        this.age = 0;
        this.weight = 0;
        this.height = 0;
    }

    public MethodOverload(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 0;
        this.height = 0;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }

    public void becomeOlder() {
        this.age++;
    }

    public void becomeOlder(int years) {
        this.age = this.age + years;
    }


    public static void main(String[] args) {
        MethodOverload prvaOsoba = new MethodOverload("Haris",20);
        System.out.println(prvaOsoba);
        prvaOsoba.becomeOlder();
        System.out.println("Sad imas vise godina: " + prvaOsoba);

        prvaOsoba.becomeOlder(40);
        System.out.println("Sad si u penziji vec! : " + prvaOsoba);

        System.out.println();







    }



}
