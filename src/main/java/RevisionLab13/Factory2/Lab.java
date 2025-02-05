package RevisionLab13.Factory2;

interface Payment {
    void processPayment();
}

class CreditCardPayment implements Payment {
    public void processPayment() {
        System.out.println("Credit Card Payment");
    }
}

class PayPalPayment implements Payment {
    public void processPayment() {
        System.out.println("PayPal Payment");
    }
}

class PaymentFactory {
    public Payment createPayment(String type) {
        if(type == null || type.isEmpty()) {
            return null;
        }

        switch(type) {
            case "EMAIL":
                return new PayPalPayment();
            case "SMS":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException();
        }
    }
}
