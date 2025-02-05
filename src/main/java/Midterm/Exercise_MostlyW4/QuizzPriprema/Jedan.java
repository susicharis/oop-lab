package Midterm.Exercise_MostlyW4.QuizzPriprema;

interface TestniInterface {
    void printPls();
}

abstract class Vehicle implements TestniInterface {
    String model;
    int year;

    public Vehicle(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    abstract String startEngine();

}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String model, int year, int numberOfDoors) {
        super(model,year);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String startEngine() {
        return "Engine has started";
    }

    public void printPls() {
        System.out.println("Blja");
    }

}