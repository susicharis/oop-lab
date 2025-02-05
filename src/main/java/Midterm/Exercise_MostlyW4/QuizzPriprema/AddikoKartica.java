package Midterm.Exercise_MostlyW4.QuizzPriprema;

interface AddikoPayable {
    abstract int payOut();
}

public class AddikoKartica implements AddikoPayable {
    String cardNum;
    int price;

    public AddikoKartica(String cardNum, int price) {
        this.cardNum = cardNum;
        this.price = price;
    }

    public String getCardNum() {
        return cardNum;
    }
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }


    public int payOut() {
        return 10;
    }


}


class AddikoPerson extends AddikoKartica {
    int cardType;

    public AddikoPerson(String cardNum, int price, int cardType) {
        super(cardNum,price);
        this.cardType = cardType;
    }

    public int getCardType() {
        return this.cardType;
    }
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    @Override
    public int payOut() {
        return 1000;
    }
}
