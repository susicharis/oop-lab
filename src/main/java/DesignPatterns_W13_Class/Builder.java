package DesignPatterns_W13_Class;

import java.util.ArrayList;
import java.util.List;

enum CoffeeType {
    ESPRESSO, LATTE, CAPPUCCINO
}

enum CoffeeSize {
    SMALL, MEDIUM, LARGE
}

enum CoffeeToppings {
    CHOCOLATE, SALTED_CARAMEL, MARSHMALLOW, WHIPPED_CREAM, CINNAMON
}


class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings;

    public Coffee(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " , Size: " + this.size + " , Toppings: " + this.toppings;
    }
}

interface CoffeeBuilder {
    void buildType();
    void buildSize(CoffeeSize size);
    void buildToppings(List<CoffeeToppings> toppings);
    Coffee getResults();
}

class EspressoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    public EspressoBuilder(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    public void buildType() {
        this.type = CoffeeType.ESPRESSO;
    }
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    public Coffee getResults() {
        return new Coffee(type,size,toppings);
    }
}

class LatteBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    public LatteBuilder(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    public void buildType() {
        this.type = CoffeeType.LATTE;
    }
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }
    public Coffee getResults() {
        return new Coffee(type,size,toppings);
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<CoffeeToppings> toppings = new ArrayList<>();

    public CappuccinoBuilder(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    public void buildType() {
        this.type = CoffeeType.CAPPUCCINO;
    }
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }
    public Coffee getResults() {
        return new Coffee(type,size,toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder,CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
        builder.buildType();
        builder.buildSize(size);
        builder.buildToppings(toppings);
        return builder.getResults();
    }
}

