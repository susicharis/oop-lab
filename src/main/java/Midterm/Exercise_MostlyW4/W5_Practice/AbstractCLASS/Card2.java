package Midterm.Exercise_MostlyW4.W5_Practice.AbstractCLASS;

abstract class Card2 {
    String cardNumber;
    int secondType;

    public Card2(String cardNumber, int secondType) {
        this.cardNumber = cardNumber;
        this.secondType = secondType;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public int getSecondType() {
        return secondType;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setSecondType(int secondType) {
        this.secondType = secondType;
    }

    abstract String printOut();


}

class CreditCard extends Card2 {
    int balance;

    public CreditCard(int balance, String cardNumber, int secondType) {
        super(cardNumber,secondType);
        this.balance = balance;

    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String printOut() {
        return "Ja sam picka";
    }
}

class Bank <P extends Card2> {
    private P transactions;

    public Bank(P transactions) {
        this.transactions = transactions;
    }
    public P getTransactions() {
        return transactions;
    }

    public P setTransactions(P transactions) {
        return this.transactions = transactions;
    }

    public String printOut() {
        return "Jos jedna picka";
    }
}
