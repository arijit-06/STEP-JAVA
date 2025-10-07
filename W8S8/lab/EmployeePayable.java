/*
LAB PROBLEM 4: Abstract Employee and Payable Interface
Topic: Abstract Class with Interface for Payroll System
Problem Statement:
Create an abstract class Employee with fields name and salary. Add abstract method
calculateBonus().
Create an interface Payable with method generatePaySlip().
Create a class Manager that extends Employee and implements Payable.
Hints:
● Use abstract method for bonus calculation.
● Interface method should handle pay slip generation.
*/

abstract class AbstractEmployee {
    protected String name;
    protected double salary;
    protected String department;
    protected int employeeId;
    protected String joinDate;
    private static int nextId = 1001;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employeeId = nextId++;
        this.department = "General";
        this.joinDate = "2023-01-01";
    }
    
    public Employee(String name, double salary, String department, String joinDate) {
        this.name = name;
        this.salary = salary;
        this.employeeId = nextId++;
        this.department = department;
        this.joinDate = joinDate;
    }
    
    public abstract double calculateBonus();
    
    public void displayEmployeeInfo() {
        System.out.println("\n=== Employee Information ===");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Join Date: " + joinDate);
        System.out.println("Base Salary: $" + salary);
        System.out.println("Position: " + getClass().getSimpleName());
    }
    
    public double getTotalCompensation() {
        return salary + calculateBonus();
    }
    
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public int getEmployeeId() { return employeeId; }
}

interface Payable {
    void generatePaySlip();
    
    default void payrollInfo() {
        System.out.println("Payroll processed according to company policy");
    }
    
    static void payrollGuidelines() {
        System.out.println("Payroll Guidelines:");
        System.out.println("- Salaries paid monthly on the 30th");
        System.out.println("- Bonuses calculated based on performance");
        System.out.println("- Deductions applied as per tax regulations");
    }
}

class Manager extends AbstractEmployee implements Payable {
    private int teamSize;
    private double performanceRating;
    private int yearsOfExperience;
    
    public Manager(String name, double salary) {
        super(name, salary, "Management", "2023-01-01");
        this.teamSize = 0;
        this.performanceRating = 3.5;
        this.yearsOfExperience = 1;
    }
    
    public Manager(String name, double salary, String joinDate, int teamSize, int yearsOfExperience) {
        super(name, salary, "Management", joinDate);
        this.teamSize = teamSize;
        this.performanceRating = 3.5;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    @Override
    public double calculateBonus() {
        double baseBonus = salary * 0.15;
        double teamBonus = teamSize * 500;
        double experienceBonus = yearsOfExperience * 1000;
        return baseBonus + teamBonus + experienceBonus;
    }
    
    @Override
    public void generatePaySlip() {
        System.out.println("\n" + "=".repeat(40));
        System.out.println("        MANAGER PAY SLIP");
        System.out.println("=".repeat(40));
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Position: Manager");
        System.out.println("Department: " + department);
        System.out.println("-".repeat(40));
        
        System.out.println("EARNINGS:");
        System.out.printf("Base Salary:      $%,.2f%n", salary);
        
        double baseBonus = salary * 0.15;
        double teamBonus = teamSize * 500;
        double experienceBonus = yearsOfExperience * 1000;
        
        System.out.printf("Base Bonus:       $%,.2f%n", baseBonus);
        System.out.printf("Team Bonus:       $%,.2f%n", teamBonus);
        System.out.printf("Experience Bonus: $%,.2f%n", experienceBonus);
        
        double grossPay = salary + calculateBonus();
        System.out.printf("Gross Pay:        $%,.2f%n", grossPay);
        
        System.out.println("-".repeat(40));
        double tax = grossPay * 0.25;
        double insurance = 500;
        double totalDeductions = tax + insurance;
        
        System.out.printf("Tax (25%%):        $%,.2f%n", tax);
        System.out.printf("Insurance:        $%,.2f%n", insurance);
        System.out.printf("Total Deductions: $%,.2f%n", totalDeductions);
        
        System.out.println("-".repeat(40));
        double netPay = grossPay - totalDeductions;
        System.out.printf("NET PAY:          $%,.2f%n", netPay);
        System.out.println("=".repeat(40));
    }
    
    @Override
    public void displayEmployeeInfo() {
        super.displayEmployeeInfo();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.printf("Total Compensation: $%,.2f%n", getTotalCompensation());
    }
    
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    
    public void setPerformanceRating(double rating) {
        this.performanceRating = rating;
    }
    
    public int getTeamSize() { return teamSize; }
}

public class EmployeePayable {
    public static void main(String[] args) {
        System.out.println("=== Abstract Employee and Payable Interface Demo ===");
        
        Payable.payrollGuidelines();
        
        Manager manager1 = new Manager("Alice Johnson", 75000, "2022-03-15", 8, 5);
        manager1.setPerformanceRating(4.2);
        
        Manager manager2 = new Manager("Bob Smith", 80000, "2021-06-01", 12, 7);
        manager2.setPerformanceRating(4.8);
        
        System.out.println("\n=== Manager 1 Information ===");
        manager1.displayEmployeeInfo();
        manager1.generatePaySlip();
        manager1.payrollInfo();
        
        System.out.println("\n=== Manager 2 Information ===");
        manager2.displayEmployeeInfo();
        manager2.generatePaySlip();
        
        System.out.println("\n=== Polymorphic Payroll Processing ===");
        AbstractEmployee[] employees = {manager1, manager2};
        Payable[] payables = {manager1, manager2};
        
        double totalPayroll = 0;
        for (AbstractEmployee emp : employees) {
            double compensation = emp.getTotalCompensation();
            totalPayroll += compensation;
            System.out.printf("%s: $%,.2f%n", emp.getName(), compensation);
        }
        
        System.out.printf("Total Payroll: $%,.2f%n", totalPayroll);
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract Employee class provides common structure");
        System.out.println("2. Payable interface defines payroll contract");
        System.out.println("3. Manager implements both abstract and interface methods");
        System.out.println("4. Polymorphism enables uniform payroll processing");
    }
}