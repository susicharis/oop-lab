package QuizzPriprema;

interface Sellable{
    int sell();
}

abstract class Product implements Sellable{
    private String name;
    private double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }


    public int sell(){
        return (int) getPrice() * 100;
    }


}

class Electronics extends Product{
    private int warranty;

    Electronics(String name, double price, int warranty){
        super(name, price);
        this.warranty = warranty;
    }

    public void setWarranty(int warranty){
        this.warranty = warranty;
    }

    public int getWarranty(){
        return warranty;
    }

    @Override
    public int sell(){
        return (int) getPrice() * 100;
    }

}