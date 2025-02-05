package DesignPatterns_W13_Class.Builder2;

import java.util.ArrayList;
import java.util.List;

enum CoffeeType {
    ESPRESSO,LATTE,CAPPUCCINO
}
enum CoffeeSize {
    SMALL,MEDIUM,LARGE
}
enum AdditionalToppings {
    MARSHMALLOW,WHIPPED_CREAM,CARAMEL
}


class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<AdditionalToppings> toppings;

    public Coffee(CoffeeType type, CoffeeSize size, List<AdditionalToppings> toppings) {
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

interface CoffeeBuilder {
    void buildType();
    void buildSize(CoffeeSize size);
    void buildToppings(List<AdditionalToppings> toppings);
    Coffee getResults();
}

class EspressoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<AdditionalToppings> toppings = new ArrayList<>();

    public void buildType() {
        this.type = CoffeeType.ESPRESSO;
    }

    public void buildSize(CoffeeSize size) {
        this.size = size;
    }

    public void buildToppings(List<AdditionalToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    public Coffee getResults() {
        return new Coffee(type, size, toppings);
    }
}

class LatteBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<AdditionalToppings> toppings = new ArrayList<>();

    public void buildType() {
        this.type = CoffeeType.LATTE;
    }
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }
    public void buildToppings(List<AdditionalToppings> toppings) {
        this.toppings.addAll(toppings);
    }
    public Coffee getResults() {
        return new Coffee(type,size,toppings);
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<AdditionalToppings> toppings = new ArrayList<>();

    public void buildType() {
        this.type = CoffeeType.CAPPUCCINO;
    }
    public void buildSize(CoffeeSize size) {
        this.size = size;
    }
    public void buildToppings(List<AdditionalToppings> toppings) {
        this.toppings.addAll(toppings);
    }
    public Coffee getResults() {
        return new Coffee(type,size,toppings);
    }
}


class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, CoffeeSize size, List<AdditionalToppings> toppings) {
        builder.buildType();
        builder.buildSize(size);
        builder.buildToppings(toppings);
        return builder.getResults();
    }
}


class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        // Espresso
        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, CoffeeSize.SMALL, List.of(AdditionalToppings.CARAMEL));
        System.out.println(espresso);

        // Lattee
        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, CoffeeSize.MEDIUM, List.of(AdditionalToppings.WHIPPED_CREAM));
        System.out.println(latte);

        // Cappuccino
        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, CoffeeSize.LARGE, List.of(AdditionalToppings.WHIPPED_CREAM));
        System.out.println(cappuccino);
    }
}

