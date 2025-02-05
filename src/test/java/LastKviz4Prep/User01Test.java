package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class User01Test {
    User01 user = new User01("Haris","1234567",2001,"ytharke@gmail.com");
    String filename = "example.txt";
    @Test
    void readFromFilesAndCheck() {
        user.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line,user.getUsername());
                } else {
                    assertEquals(line,user.getPassword());
                }
            }

            assertEquals(2,counter);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}