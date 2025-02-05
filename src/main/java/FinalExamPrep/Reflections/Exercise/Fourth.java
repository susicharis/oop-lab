package FinalExamPrep.Reflections.Exercise;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

class Vehicle {
    private final String name;
    String model;
    int year;
    List<Double> mileageRecords;

    public Vehicle(String name, String model, int year, Double[] mileageRecords) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.mileageRecords = Arrays.asList(mileageRecords);
    }

    public void printDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        for(Double d : mileageRecords) {
            System.out.println("Mileage Record: " + d);
        }
    }

}


class MileageAnalyzer {
    List<Double> mileageRecords;

    public MileageAnalyzer(Double[] mileageRecords) {
        this.mileageRecords = Arrays.asList(mileageRecords);
    }

    public double calculateAverageMileage() {
        double sum = 0;
        for(double d : mileageRecords) {
            sum += d;
        } return sum / mileageRecords.size();
    }
    public void printMileageSummary() {
        System.out.println("Average Mileage : " + calculateAverageMileage());
    }
}

class Start03 {
    public static void main(String[] args) throws IllegalAccessException {
        Double[] records = {4.250,5.250,6.760};
        Vehicle vehicle = new Vehicle("BMW","M4",2024,records);
        MileageAnalyzer mileageAnalyzer = new MileageAnalyzer(records);

        Field[] vehicleFields = vehicle.getClass().getDeclaredFields();
        for(Field vf : vehicleFields) {
            vf.setAccessible(true);
            if(vf.getName().equals("name")) {
                vf.set(vehicle,"MERCEDES");
            }
        }

        vehicle.printDetails();
    }
}

