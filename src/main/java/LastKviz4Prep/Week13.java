//package LastKviz4Prep;
//
//import java.util.ArrayList;
//import java.util.List;
//
//enum CoffeeType {
//    ESPRESSO, LATTE, CAPPUCCINO
//}
//
//enum CoffeeSize {
//    SMALL, MEDIUM, LARGE
//}
//
//enum CoffeeToppings {
//    CHOCOLATE, SALTED_CARAMEL, MARSHMALLOW, WHIPPED_CREAM, CINNAMON
//}
//
//class Coffee {
//     CoffeeType coffeeType;
//     CoffeeSize coffeeSize;
//     List<CoffeeToppings> toppings;
//
//     public Coffee(CoffeeType coffeeType, CoffeeSize coffeeSize, List<CoffeeToppings> toppings) {
//         this.coffeeType = coffeeType;
//         this.coffeeSize = coffeeSize;
//         this.toppings = toppings;
//     }
//
//     @Override
//    public String toString() {
//         return "Coffe: " + coffeeType + coffeeSize + toppings;
//     }
//}
//
//interface CoffeeBuilder {
//    void buildType(CoffeeType coffeType);
//    void buildSize(CoffeeSize coffeeSize);
//    void buildToppings(List<CoffeeToppings> toppings);
//    Coffee getResults();
//}
//
//class EspressoBuilder implements CoffeeBuilder {
//    CoffeeType coffeeType;
//    CoffeeSize coffeeSize;
//    List<CoffeeToppings> toppings = new ArrayList<>();
//
//    public EspressoBuilder(CoffeeType coffeeType, CoffeeSize coffeeSize, List<CoffeeToppings> toppings) {
//        this.coffeeType = coffeeType;
//        this.coffeeSize = coffeeSize;
//        this.toppings = toppings;
//    }
//
//    @Override
//    public void buildType(CoffeeType coffeeType) {
//        this.coffeeType = coffeeType;
//    }
//
//
//}
//
