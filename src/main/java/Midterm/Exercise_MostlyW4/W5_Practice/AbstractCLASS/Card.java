package Midterm.Exercise_MostlyW4.W5_Practice.AbstractCLASS;

class Card implements Payable {
    private String cardNo;
    private int price;

    public Card(String cardNo, int price) {
        this.cardNo = cardNo;
        this.price = price;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int pay() {
        return 100;
    }
}

class DrugaClass extends Card {
    private int type;

    public DrugaClass(int type, String cardNo, int price) {
        super(cardNo,price);
    }

    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public int pay() {
        return 10000;
    }

}





interface Payable {
    abstract int pay();
}
