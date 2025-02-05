package FinalExamPrep2.Builder;

import java.lang.module.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

enum CoffeeType {
    ESPRESSO,LATTE,CAPPUCCINO
}
enum CoffeeSize {
    SMALL,MEDIUM,LARGE
}
enum CoffeeToppings {
    CHOCOLATE,VANILLA,CARAMEL
}

class Coffee {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    List<CoffeeToppings> toppings;

    public Coffee(CoffeeType coffeeType, CoffeeSize coffeeSize, List<CoffeeToppings> toppings) {
        this.coffeeType = coffeeType;
        this.coffeeSize = coffeeSize;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee Type: " + coffeeType + " , Coffee Size:  " + coffeeSize + " , Toppings: " + toppings;
    }
}

interface CoffeeBuilder {
    void buildType();
    void buildSize(CoffeeSize coffeeSize);
    void buildToppings(List<CoffeeToppings> toppings);
    Coffee getResults();
}

class EspressoBuilder implements CoffeeBuilder {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.coffeeType = CoffeeType.ESPRESSO;
    }

    @Override
    public void buildSize(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResults() {
        return new Coffee(coffeeType,coffeeSize,toppings);
    }
}


class LatteBuilder implements CoffeeBuilder {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.coffeeType = CoffeeType.LATTE;
    }

    @Override
    public void buildSize(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResults() {
        return new Coffee(coffeeType,coffeeSize,toppings);
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private CoffeeType coffeeType;
    private CoffeeSize coffeeSize;
    List<CoffeeToppings> toppings = new ArrayList<>();

    @Override
    public void buildType() {
        this.coffeeType = CoffeeType.CAPPUCCINO;
    }

    @Override
    public void buildSize(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public void buildToppings(List<CoffeeToppings> toppings) {
        this.toppings.addAll(toppings);
    }

    @Override
    public Coffee getResults() {
        return new Coffee(coffeeType,coffeeSize,toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, CoffeeSize coffeeSize, List<CoffeeToppings> coffeeToppings) {
        builder.buildType();
        builder.buildSize(coffeeSize);
        builder.buildToppings(coffeeToppings);
        return builder.getResults();
    }
}


class Mejn {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();

        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espressoCoffee = director.constructCoffee(espressoBuilder,CoffeeSize.SMALL,List.of(CoffeeToppings.VANILLA));
        System.out.println(espressoCoffee);
    }
}