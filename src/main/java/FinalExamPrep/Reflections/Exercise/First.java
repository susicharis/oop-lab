package FinalExamPrep.Reflections.Exercise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int ID;
    List<Integer> grades;

    public Student(String name, int ID, Integer[] grades) {
        this.name = name;
        this.ID = ID;
        this.grades = Arrays.asList(grades);
    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        for(int grade : grades) {
            System.out.println("Grade: " + grade);
        }
    }
}

class GradeAnalyzer {
    List<Integer> grades;

    public GradeAnalyzer(Integer[] grades) {
        this.grades = Arrays.asList(grades);
    }

    public double calculateAverage() {
        double sum = 0;

        for(int allGrades : grades) {
            sum += allGrades;
        }
        return sum / grades.size();
    }

    public void printSummary() {
        System.out.println("Average grade: " + calculateAverage());
    }
}

class Start {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Student student = new Student("Haris",7,new Integer[]{9,9,10,10,9,6,7});
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(new Integer[]{9,9,10,10,9,6,7});

        // Student Field
        Field[] studentField = student.getClass().getDeclaredFields();
        System.out.println("Student Field");
        for(Field sf : studentField) {
            sf.setAccessible(true);
            System.out.println("Field name: " + sf.getName() + " , value: " + sf.get(student));
        }

        // GradeAnalyzer Field
        Field[] gaField = gradeAnalyzer.getClass().getDeclaredFields();
        for(Field ga : gaField) {
            ga.setAccessible(true);
            System.out.println("\nGrade Analyzer Field ");
            System.out.println("Field name: " + ga.getName() + " , value: " + ga.get(gradeAnalyzer));
        }

        // Student Method
        System.out.println("\nStudent Method:");
        Method[] studentMethod = student.getClass().getDeclaredMethods();
        for(Method sm : studentMethod) {
            sm.setAccessible(true);
            if(sm.getName().startsWith("calculate") || sm.getName().startsWith("print")) {
                if(sm.getReturnType() != void.class) {
                    System.out.println("Method: " + sm.getName() + " with return type: " + sm.invoke(gradeAnalyzer));
                } else {
                    System.out.println("Method: " + sm.getName() + " is invoked(void type): " + sm.invoke(student));
                }
            }
        }


        // GradeAnalyzer Method
        System.out.println("\nGradeAnalyzer Method");
        Method[] gaMethod = gradeAnalyzer.getClass().getDeclaredMethods();
        for(Method ga : gaMethod) {
            ga.setAccessible(true);
            if(ga.getName().startsWith("calculate") || ga.getName().startsWith("print")) {
                if(ga.getReturnType() != void.class) {
                    System.out.println("Method: " + ga.getName() + " with return type: " + ga.invoke(gradeAnalyzer));
                } else {
                    System.out.println("Method: " + ga.getName());
                }
            }
        }

    }
}


