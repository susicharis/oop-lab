package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class SalaryException extends Exception {
    public SalaryException(String message) {
        super(message);
    }
}
class Employee {
    String employeeName;
    int id;
    double salary;
    String department;

    public Employee(String employeeName, int id, double salary, String department) {
        this.employeeName = employeeName;
        this.id = id;
        this.salary = salary;
        this.department = department;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }
    public int getId() {
        return this.id;
    }
    public double getSalary() {
        return this.salary;
    }
    public String getDepartment() {
        return this.department;
    }

    public void writeToFile() {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
                writer.write("Employee ID: " + this.id + "\n");
                writer.write("Department: " + this.department + "\n");
                writer.close();
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
    }

    public void checkSalary() throws SalaryException {
        if(this.salary < 500) {
            throw new SalaryException("Has to be higher than 500!");
        }
    }
}