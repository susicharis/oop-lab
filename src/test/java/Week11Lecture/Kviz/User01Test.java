package Week11Lecture.Kviz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class User01Test {


    @Test
    void pleaseReadFromFile() {
        User01 user = new User01("Haris", "123456789");
        String filename = "copypaste.txt";

        user.readFromFile(filename);

        assertTrue(user.getUsername().equals("Haris"), "Should return 'Haris' ");
        assertTrue(user.getPassword().equals("123456789"), ("Suck a cock"));
    }

}
