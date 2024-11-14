package QuizzPriprema;


abstract class NewKartica {
    int cardNumber;
    String type;

    public NewKartica(int cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    abstract void printOut();
}


class CreditKartica extends NewKartica {
    int balance;

    public CreditKartica(int cardNumber, String type, int balance) {
        super(cardNumber,type);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void printOut() {
        System.out.println(balance);
    }
}

class Banks <T extends NewKartica> {
    T transactions;

    public Banks(T transactions) {
        this.transactions = transactions;
    }

    public T getTransactions() {
        return transactions;
    }
    public void setTransactions(T transactions) {
        this.transactions = transactions;
    }

    public void printOut() {
        System.out.println(transactions);
    }
}