package A1;


public class Student{

    private String studentName;
    private String studentId;
    private String studentBirthDate;

    public Student(){
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentBirthDate(String studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    @Override
    public String toString(){
        return "Student ID: " + studentId;
    }
}