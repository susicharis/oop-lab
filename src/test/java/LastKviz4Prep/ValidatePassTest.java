package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePassTest {
    User04 user = new User04("Haris","123456",1004,"ytharke@gmail.com");

    @Test
    void readAndTestFile() {
        user.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line,user.getUsername());
                } else {
                    assertEquals(line,user.getPassword());
                }

                assertEquals(2,counter);
            }


        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}