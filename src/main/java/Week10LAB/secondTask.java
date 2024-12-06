package Week10LAB;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    String id;
    List<Integer> listOfGrades;

    public Student(String name, String id, List<Integer> listOfGrades) {
        this.name = name;
        this.id = id;
        this.listOfGrades = listOfGrades;
    }

    public void printInfo() {
        System.out.println("Name: " + this.name + ", ID: " + this.id + ", Grades: " + this.listOfGrades);
    }

    private List<Integer> getListOfGrades() {
        return this.listOfGrades;
    }


}

class GradeAnalyzer extends Student{
    double average;

    public GradeAnalyzer(String name, String id, List<Integer> listOfGrades) {
        super(name,id,listOfGrades);

    }

    public double calculateAverage() {
        double sum = 0;

        for(int grades : listOfGrades) {
            sum += grades;
        }
        average = sum / listOfGrades.size();
        return average;
    }

    public void printSummary() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("List of Grades: " + this.listOfGrades);
        System.out.println("Average grade: " + average);
    }

}

class Start {
    public static void main(String[] args) throws IllegalAccessException {
        List<Integer> grades = new ArrayList<Integer>();
        grades.add(10);
        grades.add(9);
        grades.add(8);

        Student prviStudent = new Student("Haris","3008", grades);
        GradeAnalyzer stillPrviStudent = new GradeAnalyzer("Haris","3008",grades);
        stillPrviStudent.calculateAverage();

        Field[] firstField = prviStudent.getClass().getDeclaredFields();
        for(Field f : firstField) {
            f.setAccessible(true);
            System.out.println("The field we used for Student class : " + f.getName() + ", and their value: " + f.get(prviStudent));
        }



        Field[] secondField = stillPrviStudent.getClass().getDeclaredFields();
        for (Field f : secondField) {
            f.setAccessible(true);
            System.out.println("The field we used for GradeAnalyzer class : " + f.getName() + ", and their value: " + f.get(stillPrviStudent));
        }


    }
}