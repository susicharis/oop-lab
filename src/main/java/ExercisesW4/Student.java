package ExercisesW4;

public class Student extends Person {
    private int credits;

    public Student(String name, String address) {
        super(name, address);
        credits = 0;
    }

    void study() {
        this.credits++;
    }

    void study2() {
        for (int i = 0; i < 25; i++) {
            this.credits++;
        }
    }

    int credits() {
        return this.credits;
    }

    @Override
    public String toString() {
        return super.toString() + this.credits;
    }

}


