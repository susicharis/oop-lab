package QuizzPriprema;


abstract class DrugaKartica{
    int cardNumber;
    String type;

    public DrugaKartica(int cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public String getType() {
        return type;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setType(String type) {
        this.type = type;
    }

    abstract String printOut();
}


class KreditnaKartica extends DrugaKartica {
    int balance;

    public KreditnaKartica(int cardNumber, String type, int balance) {
        super(cardNumber,type);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }


    public String printOut() {
        return "Your card number: " + this.cardNumber + " ,type: " + this.type + "Balance: " + this.balance;
    }
}


class Banka<T extends DrugaKartica> {
    T transactions;

    public Banka(T transactions) {
        this.transactions = transactions;
    }

    public T getTransactions() {
        return transactions;
    }
    public void setTransactions(T transactions) {
        this.transactions = transactions;
    }

    public String printOut() {
        return "This is generic!";
    }
}

