package W13_Lab_Tasks;

interface Payment {
    public void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Credit Card Payment!");
    }
}

class PayPalPayment implements Payment {
    public void processPayment() {
        System.out.println("Paypal Payment!");
    }
}

class PaymentFactory {
    public Payment paymentType(String paymentType) {
        if(paymentType.equals("credit card")) {
            return new CreditCardPayment();
        } else if(paymentType.equals("paypal")) {
            return new PayPalPayment();
        } else
            throw new IllegalArgumentException("Wrong payment type: " + paymentType);
    }
}

class Main01 {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        Payment payment = factory.paymentType("paypal");
        payment.processPayment();

    }
}

