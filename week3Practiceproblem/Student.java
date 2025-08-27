package week3Practiceproblem;
// package week3Practiceproblem;

public class Student {
    // Private instance variables (encapsulation)
    private String studentId;
    private String name;
    private double grade;
    private String course;

    // Default constructor
    public Student() {
        this.studentId = "Unknown";
        this.name = "Unknown";
        this.grade = 0.0;
        this.course = "Unknown";
    }

    // Parameterized constructor
    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

    // Getter and Setter methods
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    // Method to calculate letter grade
    public String calculateLetterGrade() {
        if (grade >= 90)
            return "A";
        else if (grade >= 80)
            return "B";
        else if (grade >= 70)
            return "C";
        else if (grade >= 60)
            return "D";
        else
            return "F";
    }

    // Method to display all student information
    public void displayStudent() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Grade: " + grade);
        System.out.println("Letter Grade: " + calculateLetterGrade());
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        // 1. Creating a student using default constructor and then setting values
        Student student1 = new Student();
        student1.setStudentId("S101");
        student1.setName("Alice");
        student1.setCourse("Mathematics");
        student1.setGrade(92.5);

        // 2. Creating a student using parameterized constructor
        Student student2 = new Student("S102", "Bob", 78.0, "Physics");

        // Demonstrating getters
        System.out.println("Student1 Name (getter): " + student1.getName());
        System.out.println("Student2 Grade (getter): " + student2.getGrade());

        // Displaying full information and letter grades
        student1.displayStudent();
        student2.displayStudent();
    }
}
