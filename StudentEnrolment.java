package A1;

public class StudentEnrolment {
    private String studentID;
    private String courseName;
    private String semester;

    public StudentEnrolment(){

    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSemester() {
        return semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getStudentID() {
        return studentID;
    }

    @Override
    public String toString(){
        return semester + studentID + courseName;
    }
}

