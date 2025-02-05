//package Week11_LAB;
//
//import java.util.ArrayList;
//import java.util.List;
//
//enum CoffeeType {
//    CAPPUCCINO,LATTE,ESPRESSO
//}
//
//enum CoffeeSize {
//    SMALL,MEDIUM,LARGE
//}
//enum CoffeeToppings {
//    COKOLADA,VANILIJA,KURAC
//}
//class Coffee {
//    CoffeeType type;
//    CoffeeSize size;
//    List<CoffeeToppings> toppings;
//
//    public Coffee(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
//        this.type = type;
//        this.size = size;
//        this.toppings = toppings;
//    }
//
//    @Override
//    public String toString() {
//        return "KAFA: " + type + size + toppings;
//    }
//}
//
//interface CoffeeBuilder {
//    void buildType(CoffeeType type);
//    void buildSize();
//    void buildToppings(List<CoffeeToppings> toppings);
//    Coffee getResults();
//}
//
//class EspressoBuilder implements CoffeeBuilder {
//    CoffeeType type;
//    CoffeeSize size;
//    List<CoffeeToppings> toppings = new ArrayList<>();
//    public EspressoBuilder(CoffeeType type, CoffeeSize size, List<CoffeeToppings> toppings) {
//        this.type = type;
//        this.size = size;
//        this.toppings = toppings;
//    }
//
//    public void buildType(CoffeeType type) {
//        this.type = type;
//    }
//    public void buildSize() {
//        this.type = CoffeeSize.SMALL;
//    }
//}
