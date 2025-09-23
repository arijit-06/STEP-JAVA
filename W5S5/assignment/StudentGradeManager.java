// File: StudentGradeManager.java
// ASSIGNMENT 2: Student Grade Management

public class StudentGradeManager {
    
    public static class Student {
        private String name;
        private double[] grades;
        private static int totalStudents = 0;
        private static double totalGPA = 0;
        
        public Student(String name, double[] grades) {
            this.name = name;
            this.grades = grades;
            totalStudents++;
            totalGPA += calculateGPA();
        }
        
        public double calculateGPA() {
            double sum = 0;
            for (double grade : grades) {
                sum += grade;
            }
            return sum / grades.length;
        }
        
        public static double getClassAverage() {
            return totalStudents > 0 ? totalGPA / totalStudents : 0;
        }
        
        public static char getLetterGrade(double gpa) {
            if (gpa >= 90) return 'A';
            else if (gpa >= 80) return 'B';
            else if (gpa >= 70) return 'C';
            else if (gpa >= 60) return 'D';
            else return 'F';
        }
        
        public void displayGrade() {
            double gpa = calculateGPA();
            System.out.println(name + ": GPA = " + gpa + " (" + getLetterGrade(gpa) + ")");
        }
        
        public static int getTotalStudents() { return totalStudents; }
    }
    
    public static void main(String[] args) {
        Student s1 = new Student("Alice", new double[]{85, 90, 88});
        Student s2 = new Student("Bob", new double[]{75, 80, 78});
        Student s3 = new Student("Carol", new double[]{95, 92, 96});
        
        s1.displayGrade();
        s2.displayGrade();
        s3.displayGrade();
        
        System.out.println("Class average: " + Student.getClassAverage());
        System.out.println("Total students: " + Student.getTotalStudents());
    }
}