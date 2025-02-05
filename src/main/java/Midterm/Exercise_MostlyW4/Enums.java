package Midterm.Exercise_MostlyW4;

enum Days {
    MON, TUE, WED, THU, FRI, SAT, SUN;
    public boolean isWeekend() {
        return this == SAT || this == SUN;
    }
}

public class Enums {

    enum Gender {
        MALE, FEMALE
    }

    enum Day {
        MON, TUE, WED, THU, FRI, SAT, SUN;
    }



    public static void main(String[] args) {
        Gender gender = Gender.MALE;
        Gender gender2 = Gender.FEMALE;

        System.out.println(gender);
        System.out.println(gender2);

        Day monday = Day.MON;
        System.out.println(monday);

        Days today = Days.SAT;
        Days sutra = Days.MON;

        System.out.println("Is today the Weekend?: " + today.isWeekend());
        System.out.println("Is it in 2 days also the Weekend?: " + sutra.isWeekend());


    }
}
