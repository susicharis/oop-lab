package labWeek4;
import labWeek4.Student;
import labWeek4.Teacher;

public class main2 {
    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1");
        System.out.println(olli);
        System.out.println("credits: " + olli.credits());
        olli.study();
        System.out.println("credits: " + olli.credits());

        Teacher pekka = new Teacher("Pekka Mikkola", "Korsonite Street 1", 1200);
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street", 5400);
        System.out.println(pekka);
        System.out.println(esko);
    }
}


