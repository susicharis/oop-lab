package FinalExamPrep.Iterators.LabPractices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Employee {
    String name;
    String department;
    double salary;
    int yearsOfExp;

    public Employee(String name, String department, double salary, int yearsOfExp) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.yearsOfExp =  yearsOfExp;

    }

    public double getSalary() {
        return this.salary;
    }
    public int getYearsOfExp() {
        return this.yearsOfExp;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " , department: " + this.department + " , salary: " + this.salary + " , years of exp: " + this.yearsOfExp;
    }
}


class HighExperienceIterator implements Iterator<Employee> {
    List<Employee> employees;
    int minYearsOfExp;
    double minSalary;
    int currentIndex = 0;

    public HighExperienceIterator(List<Employee> employees,int minYearsOfExp, double minSalary) {
        this.employees = employees;
        this.minYearsOfExp = minYearsOfExp;
        this.minSalary = minSalary;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < employees.size()) {
            if(employees.get(currentIndex).getSalary() >= minSalary && employees.get(currentIndex).getYearsOfExp() >= minYearsOfExp) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Employee next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        } return employees.get(currentIndex++);
    }
}

class Mainest {
    public static void main(String[] args) {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee("Haris","IT",2500,2));
        listOfEmployees.add(new Employee("Becir","SWE",5000,10));

        HighExperienceIterator iterator = new HighExperienceIterator(listOfEmployees,5,4500);

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}