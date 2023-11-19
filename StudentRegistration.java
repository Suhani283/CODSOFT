import java.util.ArrayList;
import java.util.List;
import java.util.*;

class Course {
    public String courseCode;
    private String title;
    private String description;
    public int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    // Getter method for remaining capacity
    public int getRemainingCapacity() {
        return capacity;
    }

    // Getter method for enrolled students
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getRemainingCapacity() > 0) {
            registeredCourses.add(course);
            course.enrollStudent(this);
            course.capacity--;
            System.out.println("Course registration successful for " + name + ". Remaining capacity: " + course.getRemainingCapacity());
        } else {
            System.out.println("Course registration failed for " + name + ". No available slots.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent(this);
            course.capacity++;
            System.out.println("Course dropped successfully for " + name + ". Remaining capacity: " + course.getRemainingCapacity());
        } else {
            System.out.println("Course drop failed for " + name + ". Student not registered for the course.");
        }
    }
}

class StudentRegistration {
    private List<Course> courses;
    private List<Student> students;

    public StudentRegistration() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added: " + course.getTitle());
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student.getName());
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode() +
                    ", Title: " + course.getTitle() +
                    ", Description: " + course.getDescription() +
                    ", Capacity: " + course.getRemainingCapacity() +
                    ", Schedule: " + course.getSchedule());
        }
    }
    public void displayStudents()
    {
        System.out.println("Available Students");
        for(Student student:students)
        {
            System.out.println("Student ID: "+student.getStudentID()+
            ", Name: "+student.getName());
        }
    }
    public void displayEnrolledStudents(Course course) {
        List<Student> enrolledStudents = course.getEnrolledStudents();
        System.out.println("Enrolled Students for " + course.getTitle() + ":");
        for (Student student : enrolledStudents) {
            System.out.println("Student ID: " + student.getStudentID() + ", Name: " + student.getName());
        }
    }

    public static void main(String[] args) {
         int co=0;
         String courseCode="";
         String title="";
         String desc="";
         String schedule="";
         int cap=0;
         String name="";
         String StudentId="";
       StudentRegistration registrationSystem = new StudentRegistration();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the number of Courses");
        co=sc.nextInt();
        sc.nextLine();
       System.out.println("\n Enter the number of Students");
        int num=sc.nextInt();
        sc.nextLine();
        // Adding courses
        for(int i=0;i<co;i++)
        {
            System.out.println("\n Enter the course code");
            courseCode=sc.nextLine();  
               System.out.println("\n Enter the capacity");
             cap=sc.nextInt();
             sc.nextLine();
            System.out.println("\n Enter the course title");
            title=sc.nextLine();
             System.out.println("\n Enter the course description");
             desc=sc.nextLine();
             System.out.println("\n Enter the schedule for the course");
             schedule=sc.nextLine();
            registrationSystem.addCourse(new Course(courseCode,title,desc,cap,schedule));
       
        }
        
        // Adding students
        for(int i=0;i<num;i++)
        {
            System.out.println("\n Enter the name of the student");
            name=sc.nextLine();
            System.out.println("\n Enter student ID");
            StudentId=sc.nextLine();
            registrationSystem.addStudent(new Student(StudentId,name));
        }
        

        int choice;
        for(;;)
        {
            System.out.println("\n1. Display Available Courses");
             System.out.println("2. Display Available Students");
            System.out.println("3. Register Student for a Course");
            System.out.println("4. Drop a Course for a Student");
            System.out.println("5. Display Enrolled Students for a Course");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    registrationSystem.displayCourses();
                    break;
                    case 2:
                    registrationSystem.displayStudents();
                    break;
                case 3:
                    // Register student for a course
                    System.out.print("Enter student ID: ");
                    String studentID = sc.nextLine();
                    System.out.print("Enter course code to register: ");
                    String courseCodeToRegister = sc.nextLine();

                    Student studentToRegister = null;
                    for (Student student : registrationSystem.students) {
                        if (student.getStudentID().equals(studentID)) {
                            studentToRegister = student;
                            break;
                        }
                    }

                    Course courseToRegister = null;
                    for (Course course : registrationSystem.courses) {
                        if (course.getCourseCode().equals(courseCodeToRegister)) {
                            courseToRegister = course;
                            break;
                        }
                    }

                    if (studentToRegister != null && courseToRegister != null) {
                        studentToRegister.registerCourse(courseToRegister);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 4:
                    // Drop a course for a student
                    System.out.print("Enter student ID: ");
                    String studentIDToDrop = sc.nextLine();
                    System.out.print("Enter course code to drop: ");
                    String courseCodeToDrop = sc.nextLine();

                    Student studentToDrop = null;
                    for (Student student : registrationSystem.students) {
                        if (student.getStudentID().equals(studentIDToDrop)) {
                            studentToDrop = student;
                            break;
                        }
                    }

                    Course courseToDrop = null;
                    for (Course course : registrationSystem.courses) {
                        if (course.getCourseCode().equals(courseCodeToDrop)) {
                            courseToDrop = course;
                            break;
                        }
                    }

                    if (studentToDrop != null && courseToDrop != null) {
                        studentToDrop.dropCourse(courseToDrop);
                    } else {
                        System.out.println("Invalid student ID or course code.");
                    }
                    break;
                case 5:
                    // Display enrolled students for a course
                    System.out.print("Enter course code: ");
                    String courseCodeToDisplay = sc.nextLine();

                    Course courseToDisplay = null;
                    for (Course course : registrationSystem.courses) {
                        if (course.getCourseCode().equals(courseCodeToDisplay)) {
                            courseToDisplay = course;
                            break;
                        }
                    }

                    if (courseToDisplay != null) {
                        registrationSystem.displayEnrolledStudents(courseToDisplay);
                    } else {
                        System.out.println("Invalid course code.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } 
    }
}
