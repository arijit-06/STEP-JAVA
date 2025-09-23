// File: MedievalKingdomBuilder.java
// PRACTICE PROBLEM 3: Hierarchical Inheritance with Method Overriding
// Topic: Multiple classes extending the same parent with diverse overriding strategies

import java.util.Date;

public class MedievalKingdomBuilder {
    
    // Base class Employee
    public static class Employee {
        protected String employeeId;
        protected String name;
        protected double baseSalary;
        protected String department;
        protected Date joiningDate;
        
        public Employee(String employeeId, String name, double baseSalary, String department) {
            this.employeeId = employeeId;
            this.name = name;
            this.baseSalary = baseSalary;
            this.department = department;
            this.joiningDate = new Date();
            System.out.println("Employee " + name + " created in " + department);
        }
        
        public double calculateSalary() {
            return baseSalary;
        }
        
        public String getJobDescription() {
            return "General Employee";
        }
        
        public void performWork() {
            System.out.println("Employee is working");
        }
        
        public void attendMeeting() {
            System.out.println("Employee attending meeting");
        }
        
        public final String getEmployeeId() {
            return employeeId;
        }
        
        public final void printEmployeeDetails() {
            System.out.println("=== Employee Details ===");
            System.out.println("ID: " + employeeId + ", Name: " + name);
            System.out.println("Department: " + department + ", Base Salary: $" + baseSalary);
            System.out.println("Job: " + getJobDescription() + ", Total Salary: $" + calculateSalary());
        }
        
        public void takeBreak() {
            System.out.println("Employee taking a 15-minute break");
        }
        
        public void clockIn() {
            System.out.println("Employee " + name + " clocked in");
        }
        
        public void clockOut() {
            System.out.println("Employee " + name + " clocked out");
        }
    }
    
    // Developer class extends Employee
    public static class Developer extends Employee {
        private String[] programmingLanguages;
        private String experienceLevel;
        private int projectsCompleted;
        
        public Developer(String employeeId, String name, double baseSalary, 
                        String[] languages, String experience, int projects) {
            super(employeeId, name, baseSalary, "Engineering");
            this.programmingLanguages = languages;
            this.experienceLevel = experience;
            this.projectsCompleted = projects;
            System.out.println("Developer profile created");
        }
        
        @Override
        public double calculateSalary() {
            double experienceBonus = experienceLevel.equals("Senior") ? 20000 : 
                                   experienceLevel.equals("Mid") ? 10000 : 5000;
            double projectBonus = projectsCompleted * 1000;
            return baseSalary + experienceBonus + projectBonus;
        }
        
        @Override
        public String getJobDescription() {
            return "Software Developer";
        }
        
        @Override
        public void performWork() {
            System.out.println("Developer is coding and debugging");
        }
        
        @Override
        public void attendMeeting() {
            System.out.println("Developer in technical meeting");
        }
        
        public void writeCode() {
            System.out.println("Writing code in " + String.join(", ", programmingLanguages));
        }
        
        public void reviewCode() {
            System.out.println("Reviewing team's code");
        }
        
        public void deployApplication() {
            System.out.println("Deploying application to production");
        }
    }
    
    // Manager class extends Employee
    public static class Manager extends Employee {
        private int teamSize;
        private String managementLevel;
        private double budgetResponsibility;
        
        public Manager(String employeeId, String name, double baseSalary,
                      int teamSize, String level, double budget) {
            super(employeeId, name, baseSalary, "Management");
            this.teamSize = teamSize;
            this.managementLevel = level;
            this.budgetResponsibility = budget;
            System.out.println("Manager profile created");
        }
        
        @Override
        public double calculateSalary() {
            double teamBonus = teamSize * 2000;
            double levelBonus = managementLevel.equals("Director") ? 30000 :
                              managementLevel.equals("Manager") ? 15000 : 8000;
            return baseSalary + teamBonus + levelBonus;
        }
        
        @Override
        public String getJobDescription() {
            return "Team Manager";
        }
        
        @Override
        public void performWork() {
            System.out.println("Manager is coordinating team activities");
        }
        
        @Override
        public void attendMeeting() {
            System.out.println("Manager leading strategic meeting");
        }
        
        public void conductPerformanceReview() {
            System.out.println("Conducting team performance review");
        }
        
        public void assignTasks() {
            System.out.println("Assigning tasks to team members");
        }
        
        public void manageBudget() {
            System.out.println("Managing department budget of $" + budgetResponsibility);
        }
    }
    
    // Intern class extends Employee
    public static class Intern extends Employee {
        private String university;
        private int internshipDuration;
        private String mentor;
        private boolean isFullTime;
        
        public Intern(String employeeId, String name, String university, 
                     int duration, String mentor, boolean fullTime) {
            super(employeeId, name, 2000, "Internship"); // Lower base salary
            this.university = university;
            this.internshipDuration = duration;
            this.mentor = mentor;
            this.isFullTime = fullTime;
            System.out.println("Intern onboarded");
        }
        
        @Override
        public double calculateSalary() {
            return isFullTime ? 2000 : 1200; // Stipend amount
        }
        
        @Override
        public String getJobDescription() {
            return "Intern";
        }
        
        @Override
        public void performWork() {
            System.out.println("Intern is learning and assisting");
        }
        
        // Don't override attendMeeting() - use parent implementation
        
        public void attendTraining() {
            System.out.println("Intern attending training session");
        }
        
        public void submitReport() {
            System.out.println("Submitting weekly progress report");
        }
        
        public void seekMentorship() {
            System.out.println("Getting guidance from mentor: " + mentor);
        }
    }
    
    // Utility class for employee management
    public static class EmployeeManager {
        public static void processPayroll(Employee[] employees) {
            System.out.println("\n=== Payroll Processing ===");
            double totalPayroll = 0;
            for (Employee emp : employees) {
                double salary = emp.calculateSalary();
                totalPayroll += salary;
                System.out.println(emp.name + " (" + emp.getJobDescription() + "): $" + salary);
            }
            System.out.println("Total Payroll: $" + totalPayroll);
        }
        
        public static void generateJobReport(Employee[] employees) {
            System.out.println("\n=== Job Description Report ===");
            for (Employee emp : employees) {
                System.out.println(emp.name + ": " + emp.getJobDescription());
            }
        }
        
        public static void demonstratePolymorphism(Employee[] employees) {
            System.out.println("\n=== Polymorphic Behavior Demonstration ===");
            for (Employee emp : employees) {
                System.out.println("\n" + emp.name + ":");
                emp.performWork();
                emp.attendMeeting();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Creating Employee Hierarchy ===");
        
        // Create array of Employee references
        Employee[] employees = new Employee[4];
        
        // Initialize with different employee types
        employees[0] = new Developer("DEV001", "Alice Johnson", 80000,
                                   new String[]{"Java", "Python", "JavaScript"}, "Senior", 15);
        
        employees[1] = new Manager("MGR001", "Bob Smith", 90000, 8, "Manager", 500000);
        
        employees[2] = new Intern("INT001", "Charlie Brown", "MIT", 12, "Alice Johnson", true);
        
        employees[3] = new Developer("DEV002", "Diana Prince", 70000,
                                   new String[]{"C++", "Python"}, "Mid", 8);
        
        System.out.println("\n=== Testing Polymorphic Method Calls ===");
        
        // Demonstrate polymorphic behavior
        EmployeeManager.processPayroll(employees);
        EmployeeManager.generateJobReport(employees);
        EmployeeManager.demonstratePolymorphism(employees);
        
        System.out.println("\n=== Testing @Override Annotation Benefits ===");
        
        // Show different implementations of same methods
        System.out.println("\nDifferent calculateSalary() implementations:");
        for (Employee emp : employees) {
            System.out.println(emp.name + " salary calculation: $" + emp.calculateSalary());
        }
        
        System.out.println("\n=== Testing instanceof and Type Checking ===");
        
        for (Employee emp : employees) {
            System.out.println("\n" + emp.name + " type checking:");
            if (emp instanceof Developer) {
                Developer dev = (Developer) emp;
                dev.writeCode();
                dev.reviewCode();
            } else if (emp instanceof Manager) {
                Manager mgr = (Manager) emp;
                mgr.assignTasks();
                mgr.manageBudget();
            } else if (emp instanceof Intern) {
                Intern intern = (Intern) emp;
                intern.attendTraining();
                intern.seekMentorship();
            }
        }
        
        System.out.println("\n=== Testing Final Method Inheritance ===");
        
        // Show that final methods work the same for all subclasses
        System.out.println("\nFinal method behavior (same for all):");
        for (Employee emp : employees) {
            System.out.println("Employee ID: " + emp.getEmployeeId());
        }
        
        System.out.println("\n=== Individual Employee Details ===");
        
        // Print detailed information for each employee
        for (Employee emp : employees) {
            emp.printEmployeeDetails();
            System.out.println();
        }
    }
}