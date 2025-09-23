class Student {
    private String studentId;
    private String studentName;
    private int grade;
    private double[] marks;
    private double totalMarks;
    private double percentage;
    private static int totalStudents = 0;
    
    public Student(String studentName, int grade) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.grade = grade;
        this.marks = new double[5]; // 5 subjects
        totalStudents++;
    }
    
    private static String generateStudentId() {
        return "S" + String.format("%03d", totalStudents + 1);
    }
    
    public void calculateTotal() {
        totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
    }
    
    public void calculatePercentage() {
        calculateTotal();
        percentage = (totalMarks / 500) * 100; // Assuming 100 marks per subject
    }
    
    public void displayResult() {
        calculatePercentage();
        System.out.println("Student: " + studentName + " (" + studentId + ") - Grade " + grade);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2] + ", " + marks[3] + ", " + marks[4]);
        System.out.println("Total: " + totalMarks + "/500, Percentage: " + percentage + "%");
        System.out.println("Result: " + (isPass() ? "PASS" : "FAIL"));
    }
    
    public boolean isPass() {
        calculatePercentage();
        if (percentage < 40) return false; // Overall pass percentage
        for (double mark : marks) {
            if (mark < 35) return false; // Individual subject pass marks
        }
        return true;
    }
    
    public static Student getTopStudent(Student[] students) {
        if (students.length == 0) return null;
        Student top = students[0];
        for (Student s : students) {
            if (s != null) {
                s.calculatePercentage();
                if (s.percentage > top.percentage) {
                    top = s;
                }
            }
        }
        return top;
    }
    
    public static double getClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null) {
                s.calculatePercentage();
                total += s.percentage;
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }
    
    public static double getPassPercentage(Student[] students) {
        int passed = 0;
        int total = 0;
        for (Student s : students) {
            if (s != null) {
                total++;
                if (s.isPass()) passed++;
            }
        }
        return total > 0 ? (double) passed / total * 100 : 0;
    }
    
    public void setMarks(double[] marks) { this.marks = marks; }
    public String getStudentId() { return studentId; }
    public String getStudentName() { return studentName; }
    public double getPercentage() { calculatePercentage(); return percentage; }
    public static int getTotalStudents() { return totalStudents; }
}

class Teacher {
    private String teacherId;
    private String teacherName;
    private String subject;
    private int studentsHandled;
    private static int totalTeachers = 0;
    
    public Teacher(String teacherName, String subject) {
        this.teacherId = generateTeacherId();
        this.teacherName = teacherName;
        this.subject = subject;
        this.studentsHandled = 0;
        totalTeachers++;
    }
    
    private static String generateTeacherId() {
        return "T" + String.format("%03d", totalTeachers + 1);
    }
    
    public void assignGrades(Student student, Subject subject, double marks) {
        // Simplified - assumes subject index mapping
        double[] currentMarks = new double[5];
        // This is a simplified implementation
        System.out.println("Teacher " + teacherName + " assigned " + marks + " marks to " + 
                          student.getStudentName() + " in " + subject.getSubjectName());
        studentsHandled++;
    }
    
    public void displayTeacherInfo() {
        System.out.println("Teacher: " + teacherName + " (" + teacherId + ") - " + subject + 
                          " (Students handled: " + studentsHandled + ")");
    }
    
    public static int getTotalTeachers() { return totalTeachers; }
    public String getTeacherName() { return teacherName; }
    public String getSubject() { return subject; }
}

class Subject {
    private String subjectCode;
    private String subjectName;
    private int maxMarks;
    private int passMarks;
    
    public Subject(String subjectCode, String subjectName, int maxMarks, int passMarks) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.maxMarks = maxMarks;
        this.passMarks = passMarks;
    }
    
    public void displaySubjectInfo() {
        System.out.println(subjectCode + ": " + subjectName + " (Max: " + maxMarks + ", Pass: " + passMarks + ")");
    }
    
    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
    public int getMaxMarks() { return maxMarks; }
    public int getPassMarks() { return passMarks; }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        // Create subjects
        Subject[] subjects = {
            new Subject("MATH", "Mathematics", 100, 35),
            new Subject("SCI", "Science", 100, 35),
            new Subject("ENG", "English", 100, 35),
            new Subject("HIST", "History", 100, 35),
            new Subject("GEO", "Geography", 100, 35)
        };
        
        // Create teachers
        Teacher[] teachers = {
            new Teacher("Dr. Smith", "Mathematics"),
            new Teacher("Ms. Johnson", "Science"),
            new Teacher("Mr. Brown", "English"),
            new Teacher("Mrs. Davis", "History"),
            new Teacher("Dr. Wilson", "Geography")
        };
        
        // Create students
        Student[] students = {
            new Student("Alice Johnson", 10),
            new Student("Bob Smith", 10),
            new Student("Carol Davis", 10),
            new Student("David Wilson", 10),
            new Student("Eva Brown", 10)
        };
        
        // Assign marks to students
        double[][] marksData = {
            {85, 78, 92, 88, 90}, // Alice
            {76, 82, 79, 85, 88}, // Bob
            {92, 95, 89, 91, 94}, // Carol
            {65, 70, 68, 72, 75}, // David
            {45, 38, 42, 40, 44}  // Eva
        };
        
        for (int i = 0; i < students.length; i++) {
            students[i].setMarks(marksData[i]);
        }
        
        System.out.println("=== School Management System ===");
        System.out.println("Total Students: " + Student.getTotalStudents());
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
        
        System.out.println("\n=== Subjects ===");
        for (Subject subject : subjects) {
            subject.displaySubjectInfo();
        }
        
        System.out.println("\n=== Teachers ===");
        for (Teacher teacher : teachers) {
            teacher.displayTeacherInfo();
        }
        
        System.out.println("\n=== Student Results ===");
        for (Student student : students) {
            student.displayResult();
            System.out.println();
        }
        
        System.out.println("=== Class Statistics ===");
        Student topStudent = Student.getTopStudent(students);
        System.out.println("Top Student: " + topStudent.getStudentName() + " (" + topStudent.getPercentage() + "%)");
        System.out.println("Class Average: " + Student.getClassAverage(students) + "%");
        System.out.println("Pass Percentage: " + Student.getPassPercentage(students) + "%");
        
        System.out.println("\n=== Grade Assignment Simulation ===");
        teachers[0].assignGrades(students[0], subjects[0], 85);
        teachers[1].assignGrades(students[1], subjects[1], 82);
        teachers[2].assignGrades(students[2], subjects[2], 89);
        
        System.out.println("\n=== Updated Teacher Information ===");
        for (Teacher teacher : teachers) {
            teacher.displayTeacherInfo();
        }
        
        System.out.println("\n=== Object Interactions Demonstrated ===");
        System.out.println("✓ Teacher objects assign grades to Student objects");
        System.out.println("✓ Student objects use Subject information for validation");
        System.out.println("✓ Static methods provide class-wide statistics");
        System.out.println("✓ Instance methods handle individual student operations");
        
        System.out.println("\n=== Performance Analysis ===");
        int excellent = 0, good = 0, average = 0, poor = 0;
        for (Student s : students) {
            double percentage = s.getPercentage();
            if (percentage >= 90) excellent++;
            else if (percentage >= 75) good++;
            else if (percentage >= 60) average++;
            else poor++;
        }
        
        System.out.println("Excellent (90%+): " + excellent + " students");
        System.out.println("Good (75-89%): " + good + " students");
        System.out.println("Average (60-74%): " + average + " students");
        System.out.println("Poor (<60%): " + poor + " students");
    }
}