import java.util.*;

class Student {
    private String name;
    private int rollNo;
    
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    
    public void showDetails() {
        System.out.println("Student: " + name + ", Roll: " + rollNo);
    }
}

class Teacher {
    private String name;
    private String subject;
    private List<Student> students;
    
    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
        this.students = new ArrayList<>();
    }
    
    public void guideStudent(Student student) {
        students.add(student);
        System.out.println("Teacher " + name + " guides:");
        student.showDetails();
    }
    
    public void showGuidedStudents() {
        System.out.println("Students guided by " + name + ":");
        for (Student student : students) {
            student.showDetails();
        }
    }
}

public class StudentTeacher {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Karthik", "Java");
        Student student1 = new Student("Ravi", 101);
        Student student2 = new Student("Priya", 102);
        
        teacher1.guideStudent(student1);
        teacher1.guideStudent(student2);
        teacher1.showGuidedStudents();
    }
}