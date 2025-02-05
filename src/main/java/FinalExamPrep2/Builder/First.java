package FinalExamPrep2.Builder;

import java.util.ArrayList;
import java.util.List;

enum CrustType {
    SOFT,CRUNCH
}
enum CrustSize {
    SMALL,MEDIUM,LARGE
}
enum Sauces {
    BBQ,KETCHUP,MAYO
}
enum Toppings {
    PINEAPPLE,PEPPERONI,MEAT,EXTRA_CHEESE
}

class Pizza {
    private CrustType type;
    private CrustSize size;
    private List<Sauces> sauce;
    private List<Toppings> toppings;

    public Pizza(CrustType type, CrustSize size, List<Sauces> sauce, List<Toppings> toppings) {
        this.type = type;
        this.size = size;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Type: " + this.type + " , Size: " + this.size + " , Sauce: " + this.sauce + " , Toppings: " + this.toppings;
    }
}

interface PizzaBuilder {
    void buildCrust(CrustType type);
    void buildSize(CrustSize size);
    void buildSauce(List<Sauces> sauce);
    void buildToppings(List<Toppings> toppings);
    Pizza getResult();
}

class VeggiePizzaBuilder implements PizzaBuilder {
    private CrustType type;
    private CrustSize size;
    private List<Sauces> sauce = new ArrayList<>();
    private List<Toppings> toppings = new ArrayList<>();

    @Override
    public void buildCrust(CrustType type) {
        this.type = type;
    }

    @Override
    public void buildSize(CrustSize size) {
        this.size = size;
    }

    @Override
    public void buildSauce(List<Sauces> sauce) {
        this.sauce = sauce;
    }

    @Override
    public void buildToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public Pizza getResult() {
        return new Pizza(type,size,sauce,toppings);
    }
}

class MeatLoversPizzaBuilder implements PizzaBuilder {
    private CrustType type;
    private CrustSize size;
    private List<Sauces> sauce = new ArrayList<>();
    private List<Toppings> toppings = new ArrayList<>();

    @Override
    public void buildCrust(CrustType type) {
        this.type = type;
    }

    @Override
    public void buildSize(CrustSize size) {
        this.size = size;
    }

    @Override
    public void buildSauce(List<Sauces> sauce) {
        this.sauce = sauce;
    }

    @Override
    public void buildToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public Pizza getResult() {
        return new Pizza(type,size,sauce,toppings);
    }
}

class CheesePizzaBuilder implements PizzaBuilder {
    private CrustType type;
    private CrustSize size;
    private List<Sauces> sauce = new ArrayList<>();
    private List<Toppings> toppings = new ArrayList<>();

    @Override
    public void buildCrust(CrustType type) {
        this.type = type;
    }

    @Override
    public void buildSize(CrustSize size) {
        this.size = size;
    }

    @Override
    public void buildSauce(List<Sauces> sauce) {
        this.sauce = sauce;
    }

    @Override
    public void buildToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    @Override
    public Pizza getResult() {
        return new Pizza(type,size,sauce,toppings);
    }
}


class PizzaDirector {
    public Pizza constructPizza(PizzaBuilder builder, CrustType type, CrustSize size, List<Sauces> sauce, List<Toppings> toppings) {
        builder.buildCrust(type);
        builder.buildSize(size);
        builder.buildSauce(sauce);
        builder.buildToppings(toppings);
        return builder.getResult();
    }
}

class Mainoo {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        // Veggie Pizza
        VeggiePizzaBuilder veggiePizza = new VeggiePizzaBuilder();
        Pizza pizza = director.constructPizza(veggiePizza,CrustType.SOFT,CrustSize.SMALL,List.of(Sauces.BBQ,Sauces.KETCHUP),List.of(Toppings.PINEAPPLE,Toppings.PEPPERONI));

        System.out.println(pizza);

    }
}
