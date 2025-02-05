package Midterm.Exercise_MostlyW4.QuizzPriprema;

abstract class SecondCard {
    int cardNumber;
    String type;

    public SecondCard(int cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public String getCardType() {
        return type;
    }
    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setCardType(String type) {
        this.type = type;
    }

    abstract String printOut();
}

class CreditCard extends SecondCard {
    int balance;

    public CreditCard(int cardNumber, String type, int balance) {
        super(cardNumber,type);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String printOut() {
        return "Vrati kredit majmune!";
    }
}

// on ne extenda nijednu klasu! NE EXTENDA DIREKTNO
// bounded generics klasa !!! (kad imamo extends)
// i ima obicna generics (samo bi stavili "<P>")

class Bank <P extends SecondCard> {
    P transactions;

    public Bank(P transactions) {
        this.transactions = transactions;
    }

    public P getTransactions() {
        return transactions;
    }
    public void setTransactions(P transactions) {
        this.transactions = transactions;
    }


    public String printOut() {
        return "Evo ti ispis glupane";
    }
}
