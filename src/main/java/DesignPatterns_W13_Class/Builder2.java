package DesignPatterns_W13_Class;

class Car {
    private int id;
    private String brand;
    private String model;
    private String color;

    public Car(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    @Override
    public String toString() {
        return id + brand + model + color;
    }
}

interface CarInterface {
    CarInterface setId(int id);
    CarInterface setBrand(String brand);
    CarInterface setModel(String model);
    CarInterface setColor(String color);
    Car getResults();
}

class CarBuilder implements CarInterface {
    private int id;
    private String brand;
    private String model;
    private String color;

    public CarInterface setId(int id) {
        this.id = id;
        return this;
    }
    public CarInterface setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public CarInterface setModel(String model) {
        this.model = model;
        return this;
    }
    public CarInterface setColor(String color) {
        this.color = color;
        return this;
    }

    public Car getResults() {
        return new Car(id,brand,model,color);
    }
}

class LuxuryCar implements CarInterface {
    private int id;
    private String brand;
    private String model;
    private String color;

    public LuxuryCar(int id, String brand, String model, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public CarInterface setId(int id) {
        this.id = id;
        return this;
    }
    public CarInterface setBrand(String brand) {
        this.brand = brand;
        return this;
    }
    public CarInterface setModel(String model) {
        this.model = model;
        return this;
    }
    public CarInterface setColor(String color) {
        this.color = color;
        return this;
    }
    public Car getResults() {
        return new Car(id,brand,model,color);
    }
}


class Direktor {
    void buildBMW(CarInterface builder) {
        builder.setId(1)
                .setBrand("BMW")
                .setModel("M4")
                .setColor("Blue")
                .getResults();

    }
}