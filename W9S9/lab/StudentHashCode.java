/*
LAB PROBLEM 3: hashCode() and equals() Contract
Topic: Object Class Methods – hashCode() and equals() Relationship
*/

import java.util.HashSet;
import java.util.Objects;

class Student {
    private int id;
    private String name;
    
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class StudentHashCode {
    public static void main(String[] args) {
        System.out.println("=== hashCode() and equals() Contract Demo ===");
        
        Student s1 = new Student(101, "Alice");
        Student s2 = new Student(102, "Bob");
        Student s3 = new Student(101, "Alice Smith"); // Same ID as s1
        
        HashSet<Student> students = new HashSet<>();
        
        System.out.println("\n--- Adding Students to HashSet ---");
        students.add(s1);
        System.out.println("Added: " + s1);
        
        students.add(s2);
        System.out.println("Added: " + s2);
        
        students.add(s3);
        System.out.println("Attempted to add: " + s3);
        
        System.out.println("\n--- HashSet Contents ---");
        System.out.println("Total students in set: " + students.size());
        for (Student student : students) {
            System.out.println(student);
        }
        
        System.out.println("\n--- Equality Check ---");
        System.out.println("s1.equals(s3): " + s1.equals(s3));
        System.out.println("s1.hashCode(): " + s1.hashCode());
        System.out.println("s3.hashCode(): " + s3.hashCode());
    }
}