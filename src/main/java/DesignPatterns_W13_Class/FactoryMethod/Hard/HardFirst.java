package DesignPatterns_W13_Class.FactoryMethod.Hard;

interface Order {
    void processOrder();
    double calculateTotal(double baseAmount);
}

interface OrderFactory {
    Order createOrder(String orderType);
}

interface OrderProcessor {
    void finalizeOrder(Order order);
}

class OnlineOrder implements Order {
    public void processOrder() {
        System.out.println("Processing Online Order...");
    }
    public double calculateTotal(double baseAmount) {
        return baseAmount * 0.10;
    }
}

class StorePickupOrder implements Order {
    public void processOrder() {
        System.out.println("Processing Store Pickup Order...");
    }
    public double calculateTotal(double baseAmount) {
        return baseAmount;
    }
}

class HomeDeliveryOrder implements Order {
    public void processOrder() {
        System.out.println("Processing Special Delivery...");
    }
    public double calculateTotal(double baseAmount) {
        return baseAmount * 0.20;
    }
}

class ConcreteOrderFactory implements OrderFactory {
    public Order createOrder(String orderType) {
        if(orderType.equals("Online")) {
            return new OnlineOrder();
        } else if (orderType.equals("Store Pickup")) {
            return new StorePickupOrder();
        } else if (orderType.equals("Home Delivery")) {
            return new HomeDeliveryOrder();
        } else
            throw new IllegalArgumentException();
    }
}

class BasicOrderProcessor implements OrderProcessor {
    public void finalizeOrder(Order order) {
        double baseAmount = 100;
        double totalAmount = order.calculateTotal(baseAmount);
        order.processOrder();
        System.out.println("Order finalized. Total Amount: " + totalAmount);
        System.out.println("Thank you for your order!");
    }
}


class Mainy {
    public static void main(String[] args) {
        ConcreteOrderFactory factory = new ConcreteOrderFactory();
        BasicOrderProcessor processor = new BasicOrderProcessor();

        Order onlineOrder = factory.createOrder("Online");
        processor.finalizeOrder(onlineOrder);

    }
}