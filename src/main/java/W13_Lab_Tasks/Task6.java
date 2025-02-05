package W13_Lab_Tasks;



import java.util.ArrayList;
import java.util.List;

enum CoffeeType {
    ESPRESSO,LATTE,CAPPUCCINO
}
enum CoffeeSize {
    SMALL,MEDIUM,LARGE
}
enum Toppings {
    CHOCOLATE,VANILLA,SUGAR
}


class Coffee {
    private CoffeeType type;
    private CoffeeSize size;
    private List<Toppings> toppings;

    public Coffee(CoffeeType type, CoffeeSize size, List<Toppings> toppings) {
        this.type = type;
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return "Coffee with : " + type + " , " + size + " , " + toppings;
    }
}

interface CoffeeBuilder {
    CoffeeBuilder buildType(CoffeeType type);
    CoffeeBuilder buildSize(CoffeeSize size);
    CoffeeBuilder buildToppings(List<Toppings> toppings);
    Coffee getResult();
}

class EspressoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<Toppings> toppings = new ArrayList<>();

    public CoffeeBuilder buildType(CoffeeType type) {
        this.type = CoffeeType.ESPRESSO;
        return this;
    }
    public CoffeeBuilder buildSize(CoffeeSize size) {
        this.size = CoffeeSize.SMALL;
        return this;
    }
    public CoffeeBuilder buildToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public Coffee getResult() {
        return new Coffee(type,size,toppings);
    }

}

class LatteBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<Toppings> toppings = new ArrayList<>();

    public CoffeeBuilder buildType(CoffeeType type) {
        this.type = CoffeeType.LATTE;
        return this;
    }
    public CoffeeBuilder buildSize(CoffeeSize size) {
        this.size = CoffeeSize.MEDIUM;
        return this;
    }
    public CoffeeBuilder buildToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public Coffee getResult() {
        return new Coffee(type,size,toppings);
    }
}

class CappuccinoBuilder implements CoffeeBuilder {
    private CoffeeType type;
    private CoffeeSize size;
    private List<Toppings> toppings = new ArrayList<>();

    public CoffeeBuilder buildType(CoffeeType type) {
        this.type = CoffeeType.CAPPUCCINO;
        return this;
    }
    public CoffeeBuilder buildSize(CoffeeSize size) {
        this.size = CoffeeSize.LARGE;
        return this;
    }
    public CoffeeBuilder buildToppings(List<Toppings> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    public Coffee getResult() {
        return new Coffee(type,size,toppings);
    }
}

class CoffeeDirector {
    public Coffee constructCoffee(CoffeeBuilder builder, CoffeeType type, CoffeeSize size, List<Toppings> toppings) {
        builder.buildType(type);
        builder.buildSize(size);
        builder.buildToppings(toppings);
        return builder.getResult();
    }
}

class Main {
    public static void main(String[] args) {
        CoffeeDirector director = new CoffeeDirector();
        CoffeeBuilder espressoBuilder = new EspressoBuilder();
        Coffee espresso = director.constructCoffee(espressoBuilder, CoffeeType.ESPRESSO, CoffeeSize.SMALL, List.of(Toppings.SUGAR));

        CoffeeBuilder latteBuilder = new LatteBuilder();
        Coffee latte = director.constructCoffee(latteBuilder, CoffeeType.LATTE,CoffeeSize.MEDIUM,List.of(Toppings.VANILLA));

        CoffeeBuilder cappuccinoBuilder = new CappuccinoBuilder();
        Coffee cappuccino = director.constructCoffee(cappuccinoBuilder, CoffeeType.CAPPUCCINO,CoffeeSize.LARGE,List.of(Toppings.CHOCOLATE));

        System.out.println(espresso);
        System.out.println(latte);
        System.out.println(cappuccino);

    }
}


