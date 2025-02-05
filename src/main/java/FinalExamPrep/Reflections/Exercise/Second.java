package FinalExamPrep.Reflections.Exercise;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Employee {
    String name;
    int id;
    List<Integer> performanceScores;

    public Employee(String name, int id, Integer[] performanceScores) {
        this.name = name;
        this.id = id;
        this.performanceScores = Arrays.asList(performanceScores);
    }

    public void printInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        for(int n : performanceScores) {
            System.out.println("Performance Score: " + n);
        }
    }


}

class PerformanceAnalyzer {
    List<Integer> performanceScores;

    public PerformanceAnalyzer(Integer[] performanceScores) {
        this.performanceScores = Arrays.asList(performanceScores);
    }

    public double calculateAveragePerformance() {
        double sum = 0;
        for(int n : performanceScores) {
            sum += n;
        } return sum / performanceScores.size();
    }

    public void printPerformanceSummary() {
        System.out.println("Average performance: " + calculateAveragePerformance());
    }
}

class Start2 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Employee employee = new Employee("Becir",10,new Integer[]{10,9,10,10,8,10});
        PerformanceAnalyzer performanceAnalyzer = new PerformanceAnalyzer(new Integer[]{10,9,10,10,8,10});

        // Employee Field
        System.out.println("Employee");
        Field[] employeeField = employee.getClass().getDeclaredFields();
        for(Field ef : employeeField) {
            ef.setAccessible(true);
            System.out.println("Field name: " + ef.getName() + ", Field Values: " + ef.get(employee));
        }

        // Employee method
        Method[] employeeMethod = employee.getClass().getDeclaredMethods();
        for (Method em : employeeMethod) {
            em.setAccessible(true);
            if(em.getName().startsWith("calculate") || em.getName().startsWith("print")) {
                if(em.getReturnType() != void.class) {
                    System.out.println("Method: " + em.getName() + ", non-void: " + em.invoke(performanceAnalyzer));
                } else {
                    System.out.println("Method: " + em.getName() + ", void type: " + em.invoke(employee));
                }
            }
        }


        // PerformanceAnalyzer Field
        System.out.println("\nPerformance Analyzer ");
        Field[] paField = performanceAnalyzer.getClass().getDeclaredFields();
        for(Field pf : paField) {
            pf.setAccessible(true);
            System.out.println("Field name: " + pf.getName() + ", Field Values: " + pf.get(performanceAnalyzer));
        }

        // PerformanceAnalyzer Method
        Method[] paMethod = performanceAnalyzer.getClass().getDeclaredMethods();
        for(Method pa : paMethod) {
            pa.setAccessible(true);
            if(pa.getName().startsWith("calculate") || pa.getName().startsWith("print")) {
                if(pa.getReturnType() != void.class) {
                    System.out.println("Method: " + pa.getName() + ", non void: " + pa.invoke(performanceAnalyzer));
                } else {
                    System.out.println("Method: " + pa.getName());
                }
            }
        }

    }
}