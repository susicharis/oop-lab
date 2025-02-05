package FinalExamPrep.Reflections;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


/*
class Student {
    String name;
    int id;
    List<Integer> grades;

    public Student(String name, int id, Integer[] grades) {
        this.name = name;
        this.id = id;
        this.grades = Arrays.asList(grades);
    }


    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades: " );
        for(Integer i : grades) {
            System.out.println(i + " ");
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

        for(int grade : grades) {
            sum += grade;
        }

        return sum / grades.size();
    }

    public void printSummary() {
        System.out.println("Average grade: " + calculateAverage());
    }
}

class Start {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(new Integer[]{9, 8, 8, 6, 9});
        Student student = new Student("Haris", 7, new Integer[]{9, 8, 8, 6, 9});

        // Student

        Field[] studentField = student.getClass().getDeclaredFields();
        for(Field f : studentField) {
            f.setAccessible(true);
            System.out.println("Field " + f.getName() + " holds value " + f.get(student));
        }

        Method[] studentMethod = student.getClass().getDeclaredMethods();
        for (Method sm : studentMethod) {
            if (sm.getName().startsWith("print") || sm.getName().startsWith("calculate")) {
                if(sm.getReturnType() != void.class) {
                    System.out.println("Method: " + sm.getName() + " invoked : " + sm.invoke(gradeAnalyzer));
                } else {
                    System.out.println("Method: " + sm.getName() + " invoked with void return type: " + sm.invoke(student));
                }
            }
        }


        // Grade Analyzer
        Field[] gradeField = gradeAnalyzer.getClass().getDeclaredFields();
        for (Field f : gradeField) {
            f.setAccessible(true);
            System.out.println("Field " + f.getName() + " holds value " + f.get(gradeAnalyzer));
        }

        Method[] gradeMethod = gradeAnalyzer.getClass().getDeclaredMethods();
        for (Method gm : gradeMethod) {
            if (gm.getName().startsWith("calculate") || gm.getName().startsWith("print")) {
                if(gm.getReturnType() != void.class) {
                    System.out.println("Method " + gm.getName() + " invoked : " + gm.invoke(gradeAnalyzer));
                } else {
                    System.out.println("Method with void return type: " + gm.getName());
                }
            }
        }



    }

}



 */


