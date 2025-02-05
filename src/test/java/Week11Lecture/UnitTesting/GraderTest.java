package Week11Lecture.UnitTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraderTest {

    @Test
    void determineLetterGrade() {
        Grader grade = new Grader();
        assertEquals('D',grade.determineLetterGrade(60));
    }
}