package Week11Lecture.Kviz.First;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class User03Test {
    User03 user = new User03("Haris","1234567","2004","ytharke@gmail.com");
    String filename = "nesto.txt";

    @Test
    void writeToFilePlease() {
        user.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;
                if(counter==1){
                    assertEquals(line, user.getUsername());
                } else {
                    assertEquals(line, user.getPassword());
                }


            }

            assertEquals(2,counter,"File needs to contain 2 lines!");



        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }




    }
}