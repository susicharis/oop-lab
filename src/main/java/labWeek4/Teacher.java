package labWeek4;
import labWeek4.Person;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, double salary) {
        super(name, address);
        this.salary = (int) salary;
    }

    @Override
    public String toString(){
        return super.toString() + " Salary: " + salary;
    }


}
