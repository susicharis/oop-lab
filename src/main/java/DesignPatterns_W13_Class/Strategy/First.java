package DesignPatterns_W13_Class.Strategy;
// From GPT Example

interface PaymentStrategy2 {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy2 {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy2 {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class ShoppingCart {
    private PaymentStrategy2 paymentStrategy;

    // Postavljanje strategija u Runtime
    public void setPaymentStrategy(PaymentStrategy2 paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}

class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setPaymentStrategy(new CreditCardPayment());
        shoppingCart.checkout(200);
    }
}