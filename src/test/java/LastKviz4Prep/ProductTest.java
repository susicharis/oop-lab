package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product = new Product("Mouse","2010",149.99,50);
    String filename = "/tmp/productDetails.txt";


    @Test
    void readFromTheFileAndCheck() {
        product.writeToFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line,product.getProductName());
                } else {
                    assertEquals(line,product.getPrice());
                }
            }

            assertEquals(2,counter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}