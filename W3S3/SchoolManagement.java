class SchoolStudent {
    private String studentId;
    private String studentName;
    private int grade;
    private double[] marks;
    private double totalMarks;
    private double percentage;
    private static int studentCounter = 0;

    public SchoolStudent(String studentName, int grade, double[] marks) {
        this.studentId = generateStudentId();
        this.studentName = studentName;
        this.grade = grade;
        this.marks = marks.clone();
        calculateTotal();
        calculatePercentage();
    }

    public void calculateTotal() {
        totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }
    }

    public void calculatePercentage() {
        percentage = (totalMarks / (marks.length * 100)) * 100;
    }

    public void displayResult() {
        System.out.println("ID: " + studentId + ", Name: " + studentName + ", Grade: " + grade);
        System.out.println("Total: " + totalMarks + ", Percentage: " + percentage + "%");
        System.out.println("Result: " + (isPass() ? "PASS" : "FAIL"));
    }

    public boolean isPass() {
        for (double mark : marks) {
            if (mark < 40) return false;
        }
        return percentage >= 40;
    }

    public static String generateStudentId() {
        studentCounter++;
        return "STU" + String.format("%03d", studentCounter);
    }

    public static SchoolStudent getTopStudent(SchoolStudent[] students) {
        SchoolStudent top = students[0];
        for (SchoolStudent s : students) {
            if (s.percentage > top.percentage) {
                top = s;
            }
        }
        return top;
    }

    public static double getClassAverage(SchoolStudent[] students) {
        double total = 0;
        for (SchoolStudent s : students) {
            total += s.percentage;
        }
        return total / students.length;
    }

    public static double getPassPercentage(SchoolStudent[] students) {
        int passCount = 0;
        for (SchoolStudent s : students) {
            if (s.isPass()) passCount++;
        }
        return (double) passCount / students.length * 100;
    }

    public double getPercentage() { return percentage; }
    public String getStudentName() { return studentName; }
}

class Teacher {
    private String teacherId;
    private String teacherName;
    private String subject;
    private int studentsHandled;
    private static int totalTeachers = 0;
    private static int teacherCounter = 0;

    public Teacher(String teacherName, String subject) {
        this.teacherId = generateTeacherId();
        this.teacherName = teacherName;
        this.subject = subject;
        this.studentsHandled = 0;
        totalTeachers++;
    }

    public void assignGrades(SchoolStudent student, Subject subject, double marks) {
        System.out.println("Teacher " + teacherName + " assigned " + marks + " marks to " + student.getStudentName());
        studentsHandled++;
    }

    public void displayTeacherInfo() {
        System.out.println("ID: " + teacherId + ", Name: " + teacherName + ", Subject: " + subject + ", Students: " + studentsHandled);
    }

    public static String generateTeacherId() {
        teacherCounter++;
        return "TCH" + String.format("%03d", teacherCounter);
    }

    public static int getTotalTeachers() {
        return totalTeachers;
    }
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

    public String getSubjectName() { return subjectName; }
    public int getPassMarks() { return passMarks; }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Subject[] subjects = {
            new Subject("MATH", "Mathematics", 100, 40),
            new Subject("ENG", "English", 100, 40),
            new Subject("SCI", "Science", 100, 40),
            new Subject("SOC", "Social Studies", 100, 40),
            new Subject("COMP", "Computer", 100, 40)
        };

        SchoolStudent[] students = {
            new SchoolStudent("Alice Johnson", 10, new double[]{85, 90, 78, 88, 92}),
            new SchoolStudent("Bob Smith", 10, new double[]{75, 80, 85, 70, 88}),
            new SchoolStudent("Charlie Brown", 10, new double[]{65, 70, 60, 75, 68}),
            new SchoolStudent("Diana Prince", 10, new double[]{95, 92, 89, 94, 96})
        };

        Teacher[] teachers = {
            new Teacher("Mr. Anderson", "Mathematics"),
            new Teacher("Ms. Johnson", "English"),
            new Teacher("Dr. Smith", "Science")
        };

        System.out.println("=== STUDENT RESULTS ===");
        for (SchoolStudent s : students) {
            s.displayResult();
            System.out.println();
        }

        System.out.println("=== TEACHER INFO ===");
        for (Teacher t : teachers) {
            t.displayTeacherInfo();
            t.assignGrades(students[0], subjects[0], 85);
        }

        System.out.println("\n=== CLASS STATISTICS ===");
        SchoolStudent topStudent = SchoolStudent.getTopStudent(students);
        System.out.println("Top Student: " + topStudent.getStudentName() + " (" + topStudent.getPercentage() + "%)");
        System.out.println("Class Average: " + SchoolStudent.getClassAverage(students) + "%");
        System.out.println("Pass Percentage: " + SchoolStudent.getPassPercentage(students) + "%");
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
    }
}