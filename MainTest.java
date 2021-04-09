package A1;

import org.junit.jupiter.api.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {

    public static Student s;
    public static Course c;
    public static StudentEnrolment se;

    @BeforeAll
    public void setupAll(){
        System.out.println("should Print before ALL testing ");
    }

    @BeforeAll
    public void setup(){
        s = new Student();
        c = new Course();
        se = new StudentEnrolment();
    }

    @Test
    void saveEnrolmentToFile() throws IOException {
        try {
            FileWriter fileWriter = new FileWriter("test.csv");
            fileWriter.write("Testing...");
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error found during testing... ");
        }
//        assertEquals();
    }


    @DisplayName("Repeat enrollStudent Test for 10 times.")
    @RepeatedTest(value = 10)
    void enrollStudent() {
        StudentEnrolment se = new StudentEnrolment();
        ArrayList<StudentEnrolment> seL = new ArrayList<StudentEnrolment>();
        se.setCourseName("Intro to Testing");
        se.setSemester("2021A");
        se.setStudentID("s01");
        seL.add(se);
        Assertions.assertFalse(seL.isEmpty());
        Assertions.assertEquals(1,seL.size());
    }

    @Test
    void printStudents() {
        Student s = new Student();
        s.setStudentName("Tony");
        ArrayList<Student> sL = new ArrayList<>();
        sL.add(s);
        Assertions.assertFalse(sL.isEmpty());
        Assertions.assertEquals(1,sL.size());
    }

    @Test
    void printCourses() {
        Course c = new Course();
        c.setCourseName("Intro to testing");
        ArrayList<Course> cL = new ArrayList<>();
        cL.add(c);
        Assertions.assertFalse(cL.isEmpty());
        Assertions.assertEquals(1,cL.size());
    }

    @Test
    void getOne() {
        StudentEnrolment se = new StudentEnrolment();
        ArrayList<StudentEnrolment> seL= new ArrayList<StudentEnrolment>();
        se.setStudentID("s01");
        se.setSemester("2021A");
        se.setCourseName("Intro to Python");
        seL.add(se);
        Assertions.assertFalse(seL.isEmpty());
        Assertions.assertEquals(1,seL.size());

    }

    @DisplayName("Repeat getAll Test for 10 times.")
    @RepeatedTest(value = 10)
    void getAll() {
        StudentEnrolment se = new StudentEnrolment();
        StudentEnrolment se1 = new StudentEnrolment();
        ArrayList<StudentEnrolment> seL= new ArrayList<StudentEnrolment>();
        se.setStudentID("s02");
        se.setSemester("2021B");
        se.setCourseName("Intro to Java");
        se1.setStudentID("s02");
        se1.setSemester("2021B");
        se1.setCourseName("Intro to Java");
        seL.add(se);
        seL.add(se1);

        Assertions.assertFalse(seL.isEmpty());
        Assertions.assertEquals(2,seL.size());
    }

    @Test
    void deleteEnrollInfo() {
        StudentEnrolment se = new StudentEnrolment();
        ArrayList<StudentEnrolment> seL= new ArrayList<StudentEnrolment>();
        se.setStudentID("s02");
        seL.add(se);
        seL.remove(se);
        Assertions.assertTrue(seL.isEmpty());
        Assertions.assertEquals(0,seL.size());
    }

    @Test
    void getStudentById() {

    }

    @Test
    void updateInfo() {

    }

    @AfterEach
    public void tearDown(){
        System.out.println("Should execute After each Test.");
    }

    @AfterAll
    public void tearDownAll(){
        System.out.println("Should be executed at the end of the Test.");
    }
}