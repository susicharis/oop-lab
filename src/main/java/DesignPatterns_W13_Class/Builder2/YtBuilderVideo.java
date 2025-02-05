package DesignPatterns_W13_Class.Builder2;

class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car : " + this.id + " , " + this.brand + " , " + this.model + " , " + this.color;
    }
}

class CarBuilder {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarBuilder setId(int id) {
        this.id = id;
        return this;
    }
    public CarBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public CarBuilder setModel(String model) {
        this.model = model;
        return this;
    }
    public CarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public Car build() {
        return new Car(id,brand,model,color);
    }
}

// Director class defines the order in which we should call the construction steps so that we can reuse specific configurations of the products we are building
class Director {
    void buildBugatti(CarBuilder builder) {
        builder.setId(1)
                .setBrand("Bugatti")
                .setModel("Chiron")
                .setColor("Bronze");
    }

    void buildBMW(CarBuilder builder) {
        builder.setId(2)
                .setBrand("BMW")
                .setModel("M4 CS")
                .setColor("Purple");
    }


}

class MainPls {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder();
        builder.setId(1)
                .setBrand("Bugatti")
                .setModel("Chiron")
                .setColor("Black");
        Car firstCar = builder.build();
        System.out.println(firstCar);

        builder.setId(2)
                .setBrand("BMW")
                .setModel("M5 Competition")
                .setColor("Navy Blue");
        Car secondCar = builder.build();
        System.out.println(secondCar);

        Car thirdCar = new CarBuilder()
                .setId(3)
                .setBrand("Audi")
                .setModel("A4")
                .setColor("Red")
                .build();
        System.out.println(thirdCar);

        System.out.println("How bout director class?");
        System.out.println();

        Director director = new Director();
        director.buildBugatti(builder);
        Car fourthCar = builder.build();
        System.out.println(fourthCar);
    }
}