package FinalExamPrep2.Builder;

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
        return "ID: " + id + " , Brand: " + brand + " , Model: " + model + " , Color: " + color;
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