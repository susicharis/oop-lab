package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

//class StudentTest {
//    Student student = new Student("Haris",20,'A',"ytharke@gmail.com");
//    String filename = "exists.txt";
//
//    @Test
//    void checkTheWritingInFile() {
//        student.writeToFile();
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
//            String line;
//            int counter = 0;
//
//            while((line = reader.readLine()) != null) {
//                counter++;
//
//                if(counter == 1) {
//                    assertEquals(line,student.getStudentName());
//                } else {
//                    assertEquals(line,student.getGrade());
//                }
//
//
//                assertTrue(counter <= 2);
//            }
//        } catch (IOException ioe) {
//            System.out.println(ioe.getMessage());
//        }
//    }
//
//    void checkIfFileExists() {
//        student.writeToFile();
//        assertTrue(filename.exists(),)
//
//    }
//
//}