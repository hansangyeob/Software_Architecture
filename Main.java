/*
.Assignment1.
Name : Han sang yeob
ID: s3821179
*/

/*
to do
* delete function
* update function
* add exception on while function in the main
*JUnit testing
* 10 COMMIT TO GITHUB
* */


package librarySystem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main{

  public static ArrayList<Student> studentList = new ArrayList<>();
  public static ArrayList<Course> courseList = new ArrayList<>();
  public static ArrayList<StudentEnrolment> seList = new ArrayList<>();

    public static void main(String[] args){

        Semester semesterFirst = new Semester();
        semesterFirst.setSem("2021A");
        Semester semesterSecond = new Semester();
        semesterSecond.setSem("2021B");

        Student student1 = new Student();
        student1.setStudentName("Tony");
        student1.setStudentId("s01");
        student1.setStudentBirthDate("001225");

        Student student2 = new Student();
        student2.setStudentName("Sara");
        student2.setStudentId("s02");
        student2.setStudentBirthDate("010101");

        Student student3 = new Student();
        student3.setStudentName("John");
        student3.setStudentId("s03");
        student3.setStudentBirthDate("011111");

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        Course course1 = new Course();
        course1.setCourseName("Intro to Python");
        course1.setCourseId("c01");
        course1.setCourseCredit(12);

        Course course2 = new Course();
        course2.setCourseName("Intro to Java");
        course2.setCourseId("c02");
        course2.setCourseCredit(12);

        Course course3 = new Course();
        course3.setCourseName("Intro to C/C++");
        course3.setCourseId("c03");
        course3.setCourseCredit(12);

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);


        System.out.println("===Student list===");
        printStudents();
        System.out.println("===Course list===");
        printCourses();
        System.out.println("");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'm' to see the manual for enrolment.");


        while(true){
            String userInput = scanner.nextLine();

            switch (userInput){
                case "m":{
                        enrolmentManual();
                        break;
                }
                case "1" : {
                    printStudents();
                        break;
                }
                case "2" : {
                    printCourses();
                        break;
                }

                case "3" :{
                    enrollStudent();
                        break;
                }

                case "4" :{
                    getAll();
                        break;
                }

                case "5" : {
                    getOne();
                        break;
                }
                case "6" : {
                    //refer to getCustomerById() and updateCustomer() in A3!!!!!!!!!!!!!!
                    String studentId = enterStudentIdPrompt();
                    updateStudent(studentId);
                    break;
                }
                case "7" : {
                    deleteEnrollInfo();
                        break;
                }
                case "8" : {
                    saveEnrolmentToFile();
                        break;
                }
                case "0" : {
                    System.out.println("Good bye 。。。 ");

                    System.exit(0);
                }
                default:
                    System.out.println("Wrong Input!");
                    enrolmentManual();
                        break;
            }

        }
    }

        public static void saveEnrolmentToFile(){
            try{
                FileWriter fileWriter = new FileWriter("studentEnrolment.csv");
             //   String ls =System.lineSeparator();
                for(int i = 0; i < seList.size();i++) {
                    fileWriter.write("  "+i+". ");
                    fileWriter.write(seList.get(i).getSemester());
                    fileWriter.write(" / ");
                    fileWriter.write(seList.get(i).getStudentID());
                    fileWriter.write(" / ");
                    fileWriter.write(seList.get(i).getCourseName());
                    fileWriter.write(System.lineSeparator());
                }

                fileWriter.close();
                System.out.println("saved!");
            }catch (IOException e){
                System.out.println("Error occurred while writing customer to the file.");
                e.printStackTrace();
            }

        }



    public static void enrolmentManual(){
        System.out.println("[StudentEnrolmentManager]\n" +
                "===MANAGE STUDENT===\n" +
                "m : Manual\n"+
                "1 : Print Students\n" +
                "2 : Print Courses\n" +
                "3 : Enroll student in semester\n" +
                "4 : Get all enrolment information\n"+
                "5 : Get all enrolment in one semester(2021A OR 2021B)\n"+
                "6 : Update enrolment \n"+
                "7 : Delete enrolment \n"+
                "8 : Save \n");
    }



    public static void enrollStudent(){

        Scanner enrollInfo = new Scanner(System.in);

        StudentEnrolment se = new StudentEnrolment();

        System.out.println("==Enroll Student==");
        System.out.println("ID of student :");
        String id = enrollInfo.nextLine();
        for (Student student : studentList) {
            if (student.getStudentId().equals(id))
                se.setStudentID(id);
        }

        System.out.println("Name of course :" );
        String Input = enrollInfo.nextLine();
        for(Course courses: courseList){
            if (courses.getCourseName().equals(Input))
                se.setCourseName(Input);
        }

        System.out.println("semester: (2021A/2021B)" );
        String sem = enrollInfo.nextLine();
        se.setSemester(sem);

        System.out.println("The student information have been enrolled successfully!");

        seList.add(se);

    }



    public static void printStudents(){
        for( int i = 0; i <studentList.size(); i++){
            System.out.println((i+1)+". "+studentList.get(i).getStudentId()+ " "+studentList.get(i).getStudentName().toUpperCase());
        }
    }

    public static void printCourses(){
        for( int i = 0; i <courseList.size(); i++){
            System.out.println((i+1)+". "+courseList.get(i).getCourseId()+"  " + courseList.get(i).getCourseName().toUpperCase());
        }
    }

    public static void getOne(){
        Scanner scanner = new Scanner(System.in);
        StudentEnrolment se = new StudentEnrolment();

        System.out.println("Which semester you want to get the data?");
        String userInputSemester = scanner.nextLine();

        if(userInputSemester.equals("2021A")) {
            System.out.println("===List of student in 2021A===");
            for (StudentEnrolment studentEnrolment : seList) {
                if (studentEnrolment.getSemester().equals("2021A")) {
                    System.out.println("Student ID : " + studentEnrolment.getStudentID());
                    System.out.println("Course Name : " + studentEnrolment.getCourseName());
                    System.out.println(" ");
                }
            }
        }else{
            System.out.println("===List of student in 2021B===");
            for (StudentEnrolment studentEnrolment : seList) {
                if (studentEnrolment.getSemester().equals("2021B")) {
                    System.out.println("Student ID : " + studentEnrolment.getStudentID());
                    System.out.println("Course Name : " + studentEnrolment.getCourseName());
                    System.out.println(" ");
                }
            }
        }
    }

    public static void getAll(){

        for(int i = 0; i < seList.size(); i++){
                System.out.println((i+1)+".");
                System.out.println("Semester : " + seList.get(i).getSemester());
                System.out.println("Student ID : " + seList.get(i).getStudentID());
                System.out.println("Course Name : " + seList.get(i).getCourseName());
                System.out.println(" ");
            }
        if(seList.size()==0){
            System.out.println("The enrolment list is empty.");
            System.out.println("Press '3' to enroll the student.");


        }
    }

    public static void deleteEnrollInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which semester you want to delete?");
        String userInputSemester = scanner.nextLine();

            Predicate<StudentEnrolment> condition = seList -> seList.getSemester().startsWith("2021A");
            Predicate<StudentEnrolment> condition1 = seList -> seList.getSemester().startsWith("2021B");

            switch (userInputSemester){
                case "2021A" : {
                    seList.removeIf(condition);
                    System.out.println("2021A enrolment deleted successfully.");
                    break;
                }
                case "2021B": {
                    seList.removeIf(condition1);
                    System.out.println("2021A enrolment deleted successfully.");
                    break;
                }
                default:{
                    System.out.println("Wrong input!");
                    enrolmentManual();
                    break;
                }
            }

    }

    public static String enterStudentIdPrompt(){
        System.out.print("Enter student id : ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public static void updateStudent(String studentId) {

        boolean isUpdated = updateInfo(studentId);

        if(isUpdated){
            System.out.println("Update successful!");
        }else{
            System.out.println("Update failed.");
        }
    }

    public static StudentEnrolment getStudentById(String studentId){
        for (int i = 0; i < seList.size(); i++) {
            if(studentId.equals(seList.get(i).getStudentID())){
                return seList.get(i);
            }
        }
        return null;
    }
    public static boolean updateInfo(String studentId){

        StudentEnrolment se = getStudentById(studentId);

        if(se == null){
            return false;
        }

        printCustomerUpdateManual();

        Scanner s = new Scanner(System.in);
        boolean isDone = false;

        while(!isDone){
            String target = s.nextLine();

            switch (target){
                case "coursename" : {
                    System.out.println("enter new name : ");
                    String newName = new Scanner(System.in).nextLine();
                    se.setCourseName(newName);
                    break;
                }
                case "semester" : {
                    System.out.println("enter new semester : ");
                    String newSem = new Scanner(System.in).nextLine();
                    se.setSemester(newSem);
                    break;
                }
                case "0" : {
                    isDone = true;
                    break;
                }
                default : {
                    System.out.println("Wrong Input !");
                    printCustomerUpdateManual();
                    break;
                }
            }
        }
        return true;
    }

    public static void printCustomerUpdateManual(){
        System.out.println("Which information you wish to update?");
        System.out.println("Type 'coursename' or 'semester' to update.");
        System.out.println("Type '0' when you are done with updating.");
    }

}