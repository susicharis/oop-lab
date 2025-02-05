package Midterm.Exercise_MostlyW4.W5Lecture;

public class HumanBeing {
    private String name;
    private double weight;
    private MyCustomDate dateOfBirth;

    public HumanBeing(String name, double weight) {
        this.name = name;
        this.weight = weight;

    }


    public HumanBeing(String name, double weight, MyCustomDate dateOfBirth) {
        this.name = name;
        this.weight = weight;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + " " + this.weight + " " + this.dateOfBirth;
    }



}


class MyCustomDate {
    private int day;
    private int month;
    private int year;

    public MyCustomDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + " " + this.month + " " + this.year;
    }

}


class Counter {
    private int value;

    public Counter() {
        this.value = 0;
        /*
        postavlja pocetnu vrijednost value na 0
        mozemo napraviti objekat tipa Counter bez zadavanja ikakve vrijednosti,
        sto znaci da ce automatski imati vrijednost 0
        !! KORISNO jer mozemo inicijalizovati brojac i kasnije da mijenjamo njegovu vrijednost
         */
    }

    public Counter(int initialValue) {
        this.value = initialValue;
        /*
        pomocu ovog mozemo mijenjati tu vrijednost konstruktora nakon inicijalizacije
        ovakav nacin koristenja daje nam fleksibilnost u radu
         */
    }

    public int getValue() {
        return value;
    }


    public void growInValue() {
        this.value++;
    }

    public String toString() {
        return "Value: " + this.value;
    }


 /*
  kreirali smo novi oject "primjer" klase Counter i inicijalizujemo ga tako sto mu proslijedimo
  vrijednost "Value" iz originalnog objekta
 */
    public Counter clone() {
        Counter primjer = new Counter(this.value);
        return primjer; // vrati calleru
    }


    /*
    Poredjenje 2 objekta - da li dva objekta imaju isti atribut value - sto znaci da imaju jednaku vrijednost
     */
    @Override
    public boolean equals(Object comperedCounter){

        if (comperedCounter == null)
            return false;

        if(comperedCounter instanceof Counter) {
            Counter counter = (Counter) comperedCounter;
            // ovdje smo castovali proslijedjeni objekat comperedCounter u tip Counter
            // TO NAM omogucava pristup atributama i metodama specificnim za Counter, kao sto je getValue()

            if(this.value == counter.getValue())
                return true; // ako je ista vrijednost u oba objekta - vrati true
        }

        return false;
    }

    public static void main(String[] args) {
        HumanBeing haris = new HumanBeing("Haris",79, new MyCustomDate(30,8,2004));
        HumanBeing semha = new HumanBeing("Semha", 64, new MyCustomDate(30,8,2004));

        System.out.println(haris);
        System.out.println();

        Counter myCounter = new Counter(10);
        myCounter.growInValue();

        Counter myNewCounter = myCounter.clone();
        myNewCounter.growInValue();
        myNewCounter.growInValue();

        System.out.println(myCounter);
        System.out.println(myNewCounter);

        System.out.println(myCounter.equals(myNewCounter));

    }

}
