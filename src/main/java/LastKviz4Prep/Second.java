package LastKviz4Prep;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class PriceValidation extends Exception {
    public PriceValidation(String message) {
        super(message);
    }
}

class Product {
    String productName;
    String productCode;
    double price;
    int stockQuantity;

    public Product(String productName,String productCode,double price,int stockQuantity) {
        this.productName = productName;
        this.productCode = productCode;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }



    public String getProductName() {
        return this.productName;
    }
    public String getProductCode() {
        return this.productCode;
    }
    public double getPrice() {
        return this.price;
    }
    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public void writeToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/tmp/productDetails.txt"));
            writer.write("Product Name: " + this.productName + "\n");
            writer.write("Price: " + this.price + "\n");
            writer.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void validatePrice() throws PriceValidation {
        if(this.price <= 0) {
            throw new PriceValidation("It should be higher!");
        }
    }
}