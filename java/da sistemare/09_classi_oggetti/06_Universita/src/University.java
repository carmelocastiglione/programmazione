public class University {
    private String name;
    private Rector rector;
    private Student[] students = new Student[1000];
    private Course[] courses = new Course[1000];
    private int numStudents;
    private int numCourses;

    public University(String name) {
        this.name = name;
        numStudents = 0;
        numCourses = 0;
    }

    public String getName() {
        return name;
    }

    public void SetRector(String name, String surname) {
        Rector rector = new Rector(name, surname);
        this.rector = rector;
    }

    public String getRector() {
        return rector.getName() + " " + rector.getSurname();
    }

    public int enroll(String name, String surname) throws Exception {
        if (numStudents < 1000) {
            Student student = new Student(name, surname);
            int studentNumber = generateStudentNumber();
            student.setStudentNumber(studentNumber);
            students[numStudents] = student;
            numStudents++;
            return studentNumber;
        }
        throw new Exception("Limite studenti raggiunto");
    }

    public String student(int studentNumber) throws Exception {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getStudentNumber() == studentNumber) {
                return students[i].getStudentNumber() + " " + students[i].getName() + " " + students[i].getSurname();            
            }   
        }
        throw new Exception("Studente non trovato");
    }

    public int activate(String title, String teacher) throws Exception {
        if (numCourses < 50) {
            Course course = new Course(title, teacher);
            int courseId = generateCourseId();
            course.setCourseId(courseId);
            courses[numCourses] = course;
            numCourses++;
            return courseId;
        }
        throw new Exception("Limite corsi raggiunto");
    }

    public String course(int courseId) throws Exception {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].getCourseId() == courseId) {
                return courses[i].getCourseId() + "," + courses[i].getTitle() + "," + courses[i].getTeacher();            
            }   
        }
        throw new Exception("Corso non trovato");
    }

    public void register(int studentNumber, int courseId) throws Exception {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getStudentNumber() == studentNumber) {
                for (int j = 0; j < numCourses; j++) {
                    if (courses[j].getCourseId() == courseId) {
                        students[i].addCourse(courses[j]);
                        courses[j].addStudent(students[i]);
                        return;
                    }
                }
                throw new Exception("Corso non trovato");
            }
        }
        throw new Exception("Studente non trovato");
    }

    public String listAttendees(int courseId) throws Exception {
        String list = "";
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].getCourseId() == courseId) {
                Student[] students = courses[i].getStudents();
                int numStudents = courses[i].getNumStudentsAttending();
                for (int j = 0; j < numStudents; j++) {
                    list = list + students[j].getStudentNumber() + " " + students[j].getName() + " " + students[j].getSurname() + "\n";
                }
                return list;
            }
        }
        throw new Exception("Corso non trovato");
    }

    public String studyPlan(int studentNumber) throws Exception {
        String list = "";
        for (int i = 0; i < numStudents; i++) {
            if (students[i].getStudentNumber() == studentNumber) {
                Course[] courses = students[i].getCourses();
                int numCourses = students[i].getNumCoursesAttending();
                for (int j = 0; j < numCourses; j++) {
                    list = list + courses[i].getCourseId() + "," + courses[i].getTitle() + "," + courses[i].getTeacher() + "\n";
                }
                return list;
            }
        }
        throw new Exception("Studente non trovato");
    }

    private int generateStudentNumber() {
        return 10000 + numStudents;
    }

    private int generateCourseId() {
        return 10 + numCourses;
    }
    
}
