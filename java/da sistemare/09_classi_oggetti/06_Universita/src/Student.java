
public class Student extends Rector {
    private int studentNumber;
    private Course[] courses = new Course[25];
    private int numCoursesAttending;

    public Student(String name, String surname) {
        super(name, surname);
        studentNumber = 0;
        numCoursesAttending = 0;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void addCourse(Course course) throws Exception {
        if (numCoursesAttending < 25) {
            courses[numCoursesAttending] = course;
            numCoursesAttending++;
            return;
        }
        throw new Exception("Limite corsi frequentabili raggiunto");
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getNumCoursesAttending() {
        return numCoursesAttending;
    }

    

}
