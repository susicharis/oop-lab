package DesignPatterns_W13_Class.Builder;

import java.util.ArrayList;
import java.util.List;
/*
// Enums for coffee attributes
enum CoffeeType {
    ESPRESSO, LATTE, CAPPUCCINO
}

enum CoffeeSize {
    SMALL, MEDIUM, LARGE
}

enum CoffeeToppings {
    CHOCOLATE, SALTED_CARAMEL, MARSHMALLOW, WHIPPED_CREAM, CINNAMON
}

// Coffee class
class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings;

    // Constructor
    public Coffee(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "type=" + type +
                ", size=" + size +
                ", toppings=" + toppings +
                '}';
    }
}

// CoffeeBuilder interface
interface CoffeeBuilder {
    void buildType();
    void buildSize(CoffeeSize size);
    void buildToppings(List<CoffeeToppings> toppings);
    Coffee getResult();
}

// EspressoBuilder
class EspressoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.type = CoffeeType.ESPRESSO;
    }

    @Override
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResult() {
        return new Coffee(type, size, toppings);
    }
}

// LatteBuilder
class LatteBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.type = CoffeeType.LATTE;
    }

    @Override
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResult() {
        return new Coffee(type, size, toppings);
    }
}

// CappuccinoBuilder
class CappuccinoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.type = CoffeeType.CAPPUCCINO;
    }

    @Override
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResult() {
        return new Coffee(type, size, toppings);
    }
}

// CoffeeDirector class
class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, CoffeeSize size, List<CoffeeToppings> toppings) {
        builder.buildType();
        builder.buildSize(size);
        builder.buildToppings(toppings);
        return builder.getResult();
    }
}

// Main class
class Main07 {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        // Create an Espresso
        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, CoffeeSize.SMALL, List.of(CoffeeToppings.CINNAMON));
        System.out.println(espresso);

        // Create a Latte
        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, CoffeeSize.MEDIUM, List.of(CoffeeToppings.WHIPPED_CREAM, CoffeeToppings.MARSHMALLOW));
        System.out.println(latte);

        // Create a Cappuccino
        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, CoffeeSize.LARGE, List.of(CoffeeToppings.CHOCOLATE, CoffeeToppings.SALTED_CARAMEL));
        System.out.println(cappuccino);
    }
}


 */