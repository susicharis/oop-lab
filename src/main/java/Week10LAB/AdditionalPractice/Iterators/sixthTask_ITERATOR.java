package Week10LAB.AdditionalPractice.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class Student {
    String name;
    int age;
    int grade;

    public Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nAge: " + this.age + "\nGrade: " + this.grade + "\n";
    }
}

class GradeFilterIterator implements Iterator<Student> {
    List<Student> students;
    int minimalGrade;
    int currentIndex = 0;

    public GradeFilterIterator(List<Student> students, int minimalGrade) {
        this.students = students;
        this.minimalGrade = minimalGrade;
    }

    @Override
    public boolean hasNext() {
        while(currentIndex < students.size()) {
            Student getStudents = students.get(currentIndex);
            if (getStudents.getGrade() >= minimalGrade) {
                return true;
            } currentIndex++;
        } return false;
    }

    @Override
    public Student next() {
        if(hasNext()) {
            return students.get(currentIndex++);
        } else
            throw new NoSuchElementException();
    }
}

class Main07 {
    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Haris",20,10));
        listOfStudents.add(new Student("Becir",30,10));
        listOfStudents.add(new Student("Tarik",21,7));
        listOfStudents.add(new Student("Bokisa",27,5));
        listOfStudents.add(new Student("Micko",24,5));

        System.out.println("Students that have passed! (CONGRATULATIONS): \n" );
        GradeFilterIterator gradeIterator = new GradeFilterIterator(listOfStudents,6);
        while(gradeIterator.hasNext()) {
            System.out.println(gradeIterator.next());
        }
    }
}