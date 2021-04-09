package A1;

public class Course {
    private String CourseId;
    private String CourseName;
    private int CourseCredit;

    public Course(){}

    public String getCourseId() {
        return CourseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public int getCourseCredit() {
        return CourseCredit;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setCourseCredit(int courseCredit) {
        CourseCredit = courseCredit;
    }

    @Override
    public String toString(){
        return  "Course name : " + CourseName;
    }


}
