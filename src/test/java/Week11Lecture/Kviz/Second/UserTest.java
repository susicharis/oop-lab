package Week11Lecture.Kviz.Second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("Haris","12345678",21,"ytharke@gmail.com");
    String filename = "nesto.txt";

    void checkingWrittenFile() {
        user.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int counter = 0;
            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line, user.getUsername());
                } else {
                    assertEquals(line,user.getPassword());
                }


                assertEquals(2,counter,"Should get 2");

            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }


    }
}