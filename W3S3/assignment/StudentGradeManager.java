class Student {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // [subject][test]
    private double gpa;
    
    private static int totalStudents = 0;
    private static String schoolName = "Excellence Academy";
    private static String[] gradingScale = {"A+", "A", "B+", "B", "C+", "C", "D", "F"};
    private static double passPercentage = 60.0;
    
    public Student(String studentName, String className) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.className = className;
        this.subjects = new String[]{"Math", "Science", "English", "History", "Geography"};
        this.marks = new double[5][3]; // 5 subjects, 3 tests each
        totalStudents++;
    }
    
    private static String generateStudentId() {
        return "STU" + String.format("%03d", totalStudents + 1);
    }
    
    public static void setGradingScale(String[] scale) {
        gradingScale = scale;
    }
    
    public void addMarks(String subject, double[] testMarks) {
        int subjectIndex = -1;
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].equalsIgnoreCase(subject)) {
                subjectIndex = i;
                break;
            }
        }
        
        if (subjectIndex != -1 && testMarks.length <= 3) {
            for (int i = 0; i < testMarks.length; i++) {
                marks[subjectIndex][i] = testMarks[i];
            }
            System.out.println("Added marks for " + subject + " for " + studentName);
        } else {
            System.out.println("Invalid subject or too many test marks");
        }
    }
    
    public double calculateGPA() {
        double totalPoints = 0;
        int subjectCount = 0;
        
        for (int i = 0; i < subjects.length; i++) {
            double subjectAverage = 0;
            int testCount = 0;
            
            for (int j = 0; j < 3; j++) {
                if (marks[i][j] > 0) {
                    subjectAverage += marks[i][j];
                    testCount++;
                }
            }
            
            if (testCount > 0) {
                subjectAverage /= testCount;
                totalPoints += convertToGradePoints(subjectAverage);
                subjectCount++;
            }
        }
        
        gpa = subjectCount > 0 ? totalPoints / subjectCount : 0;
        return gpa;
    }
    
    private double convertToGradePoints(double percentage) {
        if (percentage >= 95) return 4.0;      // A+
        else if (percentage >= 90) return 3.7; // A
        else if (percentage >= 85) return 3.3; // B+
        else if (percentage >= 80) return 3.0; // B
        else if (percentage >= 75) return 2.7; // C+
        else if (percentage >= 70) return 2.3; // C
        else if (percentage >= 60) return 2.0; // D
        else return 0.0; // F
    }
    
    public String getLetterGrade(double percentage) {
        if (percentage >= 95) return "A+";
        else if (percentage >= 90) return "A";
        else if (percentage >= 85) return "B+";
        else if (percentage >= 80) return "B";
        else if (percentage >= 75) return "C+";
        else if (percentage >= 70) return "C";
        else if (percentage >= 60) return "D";
        else return "F";
    }
    
    public void generateReportCard() {
        System.out.println("=== REPORT CARD ===");
        System.out.println("School: " + schoolName);
        System.out.println("Student: " + studentName + " (" + studentId + ")");
        System.out.println("Class: " + className);
        System.out.println("-------------------");
        
        for (int i = 0; i < subjects.length; i++) {
            double subjectAverage = 0;
            int testCount = 0;
            
            System.out.print(subjects[i] + ": ");
            for (int j = 0; j < 3; j++) {
                if (marks[i][j] > 0) {
                    System.out.print(marks[i][j] + " ");
                    subjectAverage += marks[i][j];
                    testCount++;
                }
            }
            
            if (testCount > 0) {
                subjectAverage /= testCount;
                System.out.println("(Avg: " + subjectAverage + " - " + getLetterGrade(subjectAverage) + ")");
            } else {
                System.out.println("(No marks recorded)");
            }
        }
        
        System.out.println("-------------------");
        System.out.println("GPA: " + calculateGPA());
        System.out.println("Promotion: " + (checkPromotionEligibility() ? "ELIGIBLE" : "NOT ELIGIBLE"));
        System.out.println("===================");
    }
    
    public boolean checkPromotionEligibility() {
        calculateGPA();
        return gpa >= 2.0; // Minimum GPA for promotion
    }
    
    public static double calculateClassAverage(Student[] students) {
        double total = 0;
        int count = 0;
        for (Student s : students) {
            if (s != null) {
                total += s.calculateGPA();
                count++;
            }
        }
        return count > 0 ? total / count : 0;
    }
    
    public static Student[] getTopPerformers(Student[] students, int count) {
        // Simple selection sort for top performers
        Student[] sorted = new Student[students.length];
        int validCount = 0;
        
        // Copy valid students
        for (Student s : students) {
            if (s != null) {
                sorted[validCount++] = s;
            }
        }
        
        // Sort by GPA (descending)
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = i + 1; j < validCount; j++) {
                if (sorted[i].calculateGPA() < sorted[j].calculateGPA()) {
                    Student temp = sorted[i];
                    sorted[i] = sorted[j];
                    sorted[j] = temp;
                }
            }
        }
        
        Student[] topPerformers = new Student[Math.min(count, validCount)];
        for (int i = 0; i < topPerformers.length; i++) {
            topPerformers[i] = sorted[i];
        }
        
        return topPerformers;
    }
    
    public static void generateSchoolReport(Student[] students) {
        System.out.println("=== SCHOOL REPORT ===");
        System.out.println("School: " + schoolName);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Class Average GPA: " + calculateClassAverage(students));
        
        int promoted = 0;
        for (Student s : students) {
            if (s != null && s.checkPromotionEligibility()) {
                promoted++;
            }
        }
        
        System.out.println("Promotion Rate: " + (promoted * 100.0 / totalStudents) + "%");
        System.out.println("Pass Percentage Requirement: " + passPercentage + "%");
        System.out.println("=====================");
    }
    
    public String getStudentName() { return studentName; }
    public String getStudentId() { return studentId; }
    public double getGpa() { return gpa; }
    public static int getTotalStudents() { return totalStudents; }
}

class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;
    
    public Subject(String subjectCode, String subjectName, int credits, String instructor) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
    }
    
    public void displaySubject() {
        System.out.println(subjectCode + ": " + subjectName + " (" + credits + " credits) - " + instructor);
    }
    
    public String getSubjectName() { return subjectName; }
    public String getInstructor() { return instructor; }
}

public class StudentGradeManager {
    public static void main(String[] args) {
        // Create subjects
        Subject[] subjects = {
            new Subject("MATH101", "Mathematics", 4, "Dr. Smith"),
            new Subject("SCI101", "Science", 4, "Prof. Johnson"),
            new Subject("ENG101", "English", 3, "Ms. Brown"),
            new Subject("HIST101", "History", 3, "Mr. Davis"),
            new Subject("GEO101", "Geography", 3, "Dr. Wilson")
        };
        
        // Create students
        Student[] students = {
            new Student("Alice Johnson", "Grade 10A"),
            new Student("Bob Smith", "Grade 10A"),
            new Student("Carol Davis", "Grade 10B"),
            new Student("David Wilson", "Grade 10B"),
            new Student("Eva Brown", "Grade 10A"),
            new Student("Frank Miller", "Grade 10B")
        };
        
        System.out.println("=== Student Grade Management System ===");
        Student.generateSchoolReport(students);
        
        System.out.println("\n=== Available Subjects ===");
        for (Subject subject : subjects) {
            subject.displaySubject();
        }
        
        System.out.println("\n=== Adding Student Marks ===");
        // Add marks for students (3 tests per subject)
        students[0].addMarks("Math", new double[]{95, 92, 88});
        students[0].addMarks("Science", new double[]{90, 94, 91});
        students[0].addMarks("English", new double[]{88, 85, 90});
        students[0].addMarks("History", new double[]{92, 89, 94});
        students[0].addMarks("Geography", new double[]{87, 91, 89});
        
        students[1].addMarks("Math", new double[]{78, 82, 80});
        students[1].addMarks("Science", new double[]{85, 79, 83});
        students[1].addMarks("English", new double[]{82, 86, 84});
        students[1].addMarks("History", new double[]{80, 78, 85});
        students[1].addMarks("Geography", new double[]{83, 87, 81});
        
        students[2].addMarks("Math", new double[]{92, 95, 93});
        students[2].addMarks("Science", new double[]{96, 94, 98});
        students[2].addMarks("English", new double[]{91, 89, 93});
        students[2].addMarks("History", new double[]{94, 92, 96});
        students[2].addMarks("Geography", new double[]{90, 93, 91});
        
        students[3].addMarks("Math", new double[]{65, 70, 68});
        students[3].addMarks("Science", new double[]{72, 69, 74});
        students[3].addMarks("English", new double[]{75, 78, 73});
        students[3].addMarks("History", new double[]{70, 72, 76});
        students[3].addMarks("Geography", new double[]{68, 71, 69});
        
        students[4].addMarks("Math", new double[]{55, 58, 52});
        students[4].addMarks("Science", new double[]{60, 62, 59});
        students[4].addMarks("English", new double[]{65, 63, 67});
        students[4].addMarks("History", new double[]{58, 61, 56});
        students[4].addMarks("Geography", new double[]{62, 59, 64});
        
        students[5].addMarks("Math", new double[]{88, 85, 90});
        students[5].addMarks("Science", new double[]{87, 91, 89});
        students[5].addMarks("English", new double[]{84, 88, 86});
        students[5].addMarks("History", new double[]{90, 87, 92});
        students[5].addMarks("Geography", new double[]{85, 89, 87});
        
        System.out.println("\n=== Individual Report Cards ===");
        for (Student student : students) {
            student.generateReportCard();
            System.out.println();
        }
        
        System.out.println("=== Top Performers ===");
        Student[] topPerformers = Student.getTopPerformers(students, 3);
        for (int i = 0; i < topPerformers.length; i++) {
            System.out.println((i + 1) + ". " + topPerformers[i].getStudentName() + 
                             " (GPA: " + topPerformers[i].getGpa() + ")");
        }
        
        System.out.println("\n=== Final School Report ===");
        Student.generateSchoolReport(students);
        
        System.out.println("\n=== Grade Distribution ===");
        int[] gradeCount = new int[8]; // A+, A, B+, B, C+, C, D, F
        String[] grades = {"A+", "A", "B+", "B", "C+", "C", "D", "F"};
        
        for (Student s : students) {
            double gpa = s.calculateGPA();
            if (gpa >= 3.7) gradeCount[0]++;      // A+
            else if (gpa >= 3.3) gradeCount[1]++; // A
            else if (gpa >= 3.0) gradeCount[2]++; // B+
            else if (gpa >= 2.7) gradeCount[3]++; // B
            else if (gpa >= 2.3) gradeCount[4]++; // C+
            else if (gpa >= 2.0) gradeCount[5]++; // C
            else if (gpa >= 1.0) gradeCount[6]++; // D
            else gradeCount[7]++;                 // F
        }
        
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i] + ": " + gradeCount[i] + " students");
        }
        
        System.out.println("\n=== Static vs Instance Methods Demonstrated ===");
        System.out.println("✓ Static methods: calculateClassAverage, getTopPerformers, generateSchoolReport");
        System.out.println("✓ Instance methods: addMarks, calculateGPA, generateReportCard");
        System.out.println("✓ Static variables: schoolName, totalStudents, gradingScale");
        System.out.println("✓ Instance variables: studentId, marks, gpa (unique per student)");
    }
}