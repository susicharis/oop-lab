package Midterm.Exercise_MostlyW4.QuizzPriprema;

interface Payable {
    int pay();
}

class NewCard implements Payable {
    String cardNo;
    int price;

    public NewCard (String cardNo, int price) {
        this.cardNo = cardNo;
        this.price = price;
    }

    public String getCardNo() {
        return cardNo;
    }
    public int getPrice() {
        return price;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int pay() {
        return 100;
    }

}

class Person extends NewCard {
    int cardType;

    public Person(String cardNo, int price, int cardType) {
        super(cardNo,price);
        this.cardType = cardType;
    }

    public int getCardType() {
        return cardType;
    }
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Override
    public int pay() {
        return 10000;
    }
}