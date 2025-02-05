package FinalExamPrep2.Lab10;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int id;
    List<Integer> listOfGrades;

    public Student(String name, int id, Integer[] listOfGrades) {
        this.name = name;
        this.id = id;
        this.listOfGrades = Arrays.asList(listOfGrades);
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        for(int i : listOfGrades) {
            System.out.println("Grade: " + i);
        }
    }

}

class GradeAnalyzer {
    List<Integer> listOfGrades;

    public GradeAnalyzer(Integer[] listOfGrades) {
        this.listOfGrades = Arrays.asList(listOfGrades);
    }

    public double calculateAverage() {
        double sum = 0;
        for(int i : listOfGrades) {
            sum += i;
        }
        return sum / listOfGrades.size();
    }

    public void printSummary() {
        System.out.println("Average Grade: " + calculateAverage());
    }
}

class Start {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Integer[] listOfGrades = {10,9,9,9,6};
        Student student = new Student("Haris",7,listOfGrades);
        GradeAnalyzer analyzer = new GradeAnalyzer(listOfGrades);

        // Student Field
        Field[] studentField = student.getClass().getDeclaredFields();
        for(Field sf : studentField) {
            sf.setAccessible(true);
            System.out.println("Field name: " + sf.getName() + " , their value: " + sf.get(student));
        }

        // Student Method
        Method[] studentMethod = student.getClass().getDeclaredMethods();
        for(Method sm : studentMethod) {
            sm.setAccessible(true);
            if(sm.getName().startsWith("calculate") || sm.getName().startsWith("print")) {
                if(sm.getReturnType() != void.class) {
                    System.out.println("Method: " + sm.getName() + " invoked: " + sm.invoke(student));
                } else {
                    System.out.println("Method: " + sm.getName() + " is type of VOID return type");
                }
            }
        }


        // GA Field
        Field[] analyzerField = analyzer.getClass().getDeclaredFields();
        for (Field af : analyzerField) {
            af.setAccessible(true);
            System.out.println("Field name: " + af.getName() + " , their value: " + af.get(analyzer));
        }

        // GA Method

    }

}