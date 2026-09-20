
public class Course {
    private String title;
    private String teacher;
    private int courseId;
    private Student[] students = new Student[100];
    private int numStudentsAttending;

    public Course(String title, String teacher) {
        this.title = title;
        this.teacher = teacher;
        courseId = 0;
        numStudentsAttending = 0;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacher() {
        return teacher;
    }

    public void addStudent(Student student) throws Exception {
        if (numStudentsAttending < 100) {
            students[numStudentsAttending] = student;
            numStudentsAttending++;
            return;
        }
        throw new Exception("Limite studenti iscritti ad un corso raggiunto");
    }

    public Student[] getStudents() {
        return students;
    }

    public int getNumStudentsAttending() {
        return numStudentsAttending;
    }

}
