package PonavljanjeW13;

interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing credit card payment");
    }
}

class PaypalPayment implements Payment {
    public void processPayment() {
        System.out.println("Processing pp payment");
    }
}

class PaymentFactory {
    public Payment paymentType(String type) {
        if(type == null || type.isEmpty()) {
            return null;
        }

        switch (type) {
            case "email":
                return new PaypalPayment();
            case "credit":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException();
        }
    }
}