package Week11_LAB;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//class Student {
//    private int id;
//    private String name;
//    private String university;
//    private double GPA;
//
//    public Student(int id, String name, String university, double GPA) {
//        this.id = id;
//        this.name = name;
//        this.university = university;
//        this.GPA = GPA;
//    }
//
//    public int getId() {
//        return this.id;
//    }
//    public String getName() {
//        return this.name;
//    }
//    public String getUniversity() {
//        return this.university;
//    }
//
//    @Override
//    public String toString() {
//        return "ID: " + this.id + "\n Name: " + this.name + "\n University: " + this.university + "\n GPA: " + this.GPA;
//    }
//
//}
//
//
//class StudentNotFoundException extends Exception {
//    public StudentNotFoundException() {
//        super("Student not found!");
//    }
//}
//
//class EmptyStudentsListException extends RuntimeException {
//    public EmptyStudentsListException(String message) {
//        super(message);
//    }
//}
//
//class InvalidStudentDataException extends Exception {
//    public InvalidStudentDataException(String message) {
//        super(message);
//    }
//}
//
//
//class StudentSystem {
//    List<Student> students;
//
//    public StudentSystem(String filename) {
//        this.students = new ArrayList<>();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//
//        } catch (IOException e) {
//
//        }
//    }
//
//    public StudentSystem(List<Student> students) {
//        this.students = students;
//    }
//
//
//    public static void readStudents(String filename) {
//        System.out.println();
//    }
//
//    public static int noOfStudents() {
//
//    }
//
//}