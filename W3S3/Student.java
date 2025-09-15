public class Student {
    private String studentId;
    private String name;
    private double grade;
    private String course;

    public Student() {
        this.studentId = "";
        this.name = "";
        this.grade = 0.0;
        this.course = "";
    }

    public Student(String studentId, String name, double grade, String course) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.course = course;
    }

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

    public void displayStudent() {
        System.out.println("ID: " + studentId + ", Name: " + name +
                ", Grade: " + grade + ", Course: " + course +
                ", Letter Grade: " + calculateLetterGrade());
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setStudentId("S001");
        student1.setName("Alice");
        student1.setGrade(85.5);
        student1.setCourse("Computer Science");

        Student student2 = new Student("S002", "Bob", 92.0, "Mathematics");

        System.out.println("Student 1 ID: " + student1.getStudentId());
        System.out.println("Student 1 Name: " + student1.getName());

        student1.displayStudent();
        student2.displayStudent();
    }
}