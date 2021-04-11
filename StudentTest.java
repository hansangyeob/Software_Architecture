package A1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getStudentName() {
        Student studentTesting = new Student();
        studentTesting.setStudentName("Tony");
        assertEquals("Tony",studentTesting.getStudentName());
    }

    @Test
    void getStudentId() {
        Student studentTesting = new Student();
        studentTesting.setStudentId("s01");
        assertEquals("s01",studentTesting.getStudentId());
    }

    @Test
    void getStudentBirthDate() {
        Student studentTesting = new Student();
        studentTesting.setStudentBirthDate("001225");
        assertEquals("001225",studentTesting.getStudentBirthDate());
    }

    @Test
    void setStudentName() {
        Student studentTesting = new Student();
        studentTesting.setStudentName("Tony");
        assertEquals("Tony",studentTesting.getStudentName());
    }

    @Test
    void setStudentId() {
        Student studentTesting = new Student();
        studentTesting.setStudentId("s01");
        assertEquals("s01",studentTesting.getStudentId());
    }

    @Test
    void setStudentBirthDate() {
        Student studentTesting = new Student();
        studentTesting.setStudentBirthDate("001225");
        assertEquals("001225",studentTesting.getStudentBirthDate());
    }

}