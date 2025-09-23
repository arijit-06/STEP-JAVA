// File: ObjectCounter.java
// LAB 3: Object Counter Implementation

public class ObjectCounter {
    
    public static class Student {
        private String name;
        private static int totalStudents = 0;
        private static int activeStudents = 0;
        
        public Student(String name) {
            this.name = name;
            totalStudents++;
            activeStudents++;
            System.out.println("Student created: " + name);
        }
        
        public void graduate() {
            activeStudents--;
            System.out.println(name + " graduated");
        }
        
        public static int getTotalStudents() { return totalStudents; }
        public static int getActiveStudents() { return activeStudents; }
        public static int getGraduatedStudents() { return totalStudents - activeStudents; }
        
        public static void displayStatistics() {
            System.out.println("=== Student Statistics ===");
            System.out.println("Total enrolled: " + totalStudents);
            System.out.println("Currently active: " + activeStudents);
            System.out.println("Graduated: " + getGraduatedStudents());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Object Counter Demo ===");
        
        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Carol");
        
        Student.displayStatistics();
        
        s1.graduate();
        s2.graduate();
        
        System.out.println("\nAfter graduations:");
        Student.displayStatistics();
        
        Student s4 = new Student("David");
        System.out.println("\nAfter new enrollment:");
        Student.displayStatistics();
    }
}