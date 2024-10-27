package ExercisesW4;

public class Student extends Person {
    private int credits;

    public Student (String name, String address) {
        super(name, address);
        this.credits = credits;
    }

    void study() {
        this.credits++;
    }

    int credits() {
        return this.credits;
    }

    @Override
    public String toString() {
        return super.toString() + this.credits;
    }
}


