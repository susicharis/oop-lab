package Week11Lecture.Kviz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TUserTest {

    @Test
    void testReadFromFile() {
        TUser user1 = new TUser("Tarik", "pass123");
        String filename = "copypaste.txt";

        user1.readFromFile(filename);

        assertTrue(user1.getUsername().equals("Tarik"), "Bravo Kolumbo");
        assertTrue(user1.getPassword().equals("pass123"), "Bravo Kolumbo v2");



    }
}