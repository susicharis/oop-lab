package ExercisesW4;

public class Main {

    public static void main(String[] args) {

        Person pekka = new Person("Pekka, ", "Korsontie Street 1");
        Person esko = new Person("Esko Ukkonen, ", "Mannerheim Street");
        System.out.println(pekka);
        System.out.println(esko);

        Student olli = new Student("Olli, ", "Ida Albergintie Street 1");
        System.out.println(olli);

        System.out.println("credits: " + olli.credits());
        olli.study();
        System.out.println("Credits after studying: " + olli.credits());


        Teacher becir = new Teacher("Becir Isakovic", "Ilidza 77208", 2500);
        Teacher amila = new Teacher("Amila Causevic", "Francuske Rev. 22910", 1800);
        System.out.println(becir);
        System.out.println(amila);

        Student olli2 = new Student("Olli, ", "Mannerheim Street 2");
        for (int i = 0; i < 25; i++) {
            olli.study();
        }

        System.out.println(olli2);

    }

}
