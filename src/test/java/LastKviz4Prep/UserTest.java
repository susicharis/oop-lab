package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("Haris","123456",21,"ytharke@gmail.com");
    String filename = "nesto.txt";
    @Test
    void checkingWrittenFile() {
        user.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line,user.getUsername());
                } else
                    assertEquals(line,user.getPassword());
            }

            assertEquals(2,counter);
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}