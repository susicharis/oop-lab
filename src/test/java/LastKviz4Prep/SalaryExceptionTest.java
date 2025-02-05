package LastKviz4Prep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SalaryExceptionTest {
    Employee employee = new Employee("Haris",7,2000.00,"IT");

    @Test
    void checkFileLines() {
        employee.writeToFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            int counter = 0;

            while((line = reader.readLine()) != null) {
                counter++;

                if(counter == 1) {
                    assertEquals(line,employee.getId());
                } else {
                    assertEquals(line,employee.getDepartment());
                }


                assertEquals(2,counter);
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

}