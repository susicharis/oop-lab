package DesignPatterns_W13_Class;

import java.util.ArrayList;
import java.util.List;

enum PizzaSize {
    SMALL,MEDIUM,LARGE
}
enum CrustType {
    HARD,RAW
}

enum Toppings {
    KETCHUP,MAYO,CHEESE
}

class Pizza {
    PizzaSize pizzaSize;
    CrustType crustType;
    List<Toppings> toppings;

    public Pizza(PizzaSize pizzaSize, CrustType crustType, List<Toppings> toppings) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Pizza: " + this.pizzaSize + this.crustType + this.toppings;
    }
}

interface PizzaBuilder {
    void buildSize(PizzaSize pizzaSize);
    void buildCrustType(CrustType crustType);
    void addToppings(List<Toppings> toppings);
    Pizza getResults();
}

class VeggiePizzaBuilder implements PizzaBuilder {
    PizzaSize pizzaSize;
    CrustType crustType;
    List<Toppings> toppings = new ArrayList<>();

    public VeggiePizzaBuilder(PizzaSize pizzaSize, CrustType crustType, List<Toppings> toppings) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    public void buildSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    public void buildCrustType(CrustType crustType) {
        this.crustType = crustType;
    }
    public void addToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
    }

    public Pizza getResults() {
        return new Pizza(pizzaSize,crustType,toppings);
    }
}

class PepperoniPizzaBuilder implements PizzaBuilder {
    PizzaSize pizzaSize;
    CrustType crustType;
    List<Toppings> toppings = new ArrayList<>();

    public PepperoniPizzaBuilder(PizzaSize pizzaSize, CrustType crustType, List<Toppings> toppings) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    public void buildSize(PizzaSize pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
    public void buildCrustType(CrustType crustType) {
        this.crustType = crustType;
    }
    public void addToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
    }

    public Pizza getResults() {
        return new Pizza(pizzaSize,crustType,toppings);
    }
}

class MargheritaPizzaBuilder implements PizzaBuilder {
    PizzaSize pizzaSize;
    CrustType crustType;
    List<Toppings> toppings = new ArrayList<>();

    public MargheritaPizzaBuilder(PizzaSize pizzaSize, CrustType crustType, List<Toppings> toppings) {
        this.pizzaSize = pizzaSize;
        this.crustType = crustType;
        this.toppings = toppings;
    }

    public void buildSize(PizzaSize pizzaSize) {
        this.pizzaSize = PizzaSize.SMALL;
    }
    public void buildCrustType(CrustType crustType) {
        this.crustType = crustType;
    }
    public void addToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
    }

    public Pizza getResults() {
        return new Pizza(pizzaSize,crustType,toppings);
    }
}

class PizzaDirector {
    void constructPizza(PizzaBuilder builder, PizzaSize pizzaSize, CrustType crustType, List<Toppings> toppings) {
        builder.buildSize(pizzaSize);
        builder.buildCrustType(crustType);
        builder.addToppings(toppings);
        builder.getResults();
    }
}


