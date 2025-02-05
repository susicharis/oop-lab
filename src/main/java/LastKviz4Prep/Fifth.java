package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class GradeException extends Exception {
    public GradeException(String message) {
        super(message);
    }
}

class Student {
    String studentName;
    int rollNumber;
    char grade;
    String email;

    public Student(String studentName,int rollNumber,char grade, String email) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.email = email;
    }

    public String getStudentName() {
        return studentName;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public char getGrade() {
        return grade;
    }
    public String getEmail() {
        return email;
    }

    public void writeToFile()  {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
            writer.write("Student name: " + this.studentName);
            writer.write("Grades : " + this.grade);
            writer.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void validateGrade() throws GradeException {
        if (grade < 'A' || grade > 'F') {
            throw new GradeException("Not good");
        }
    }
}