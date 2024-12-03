package Week_4_Lab.People;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int credits;                // Broj kredita
    private String student_id;          // Privatna promenljiva za student_id
    private List<Double> grades;        // Lista za ocene

    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
        this.student_id = "";           // Inicijalizacija student_id kao prazan string
        this.grades = new ArrayList<>(); // Inicijalizacija liste ocena
    }

    public void study() {
        this.credits++;
    }

    public int credits() {
        return this.credits;
    }

    // Getter i Setter za student_id
    public String getStudentId() {
        return student_id;
    }

    public void setStudentId(String student_id) {
        this.student_id = student_id;
    }

    // Metoda za dodavanje ocene uz validaciju
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) { // Validacija: ocena treba biti između 0 i 100
            grades.add(grade);
            System.out.println("Grade " + grade + " added successfully.");
        } else {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
        }
    }

    // Getter za ocene
    public List<Double> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return super.toString() + " Credits: " + credits + ", Student ID: " + student_id + ", Grades: " + grades;
    }
}
