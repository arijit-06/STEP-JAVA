/*
Problem 5: Abstract Employee Class with Bonus Calculation
Problem Statement:
Create an abstract class Employee with data members name and salary. Add an
abstract method calculateBonus(). Subclasses Manager and Developer should
implement the method differently. Demonstrate abstraction with real-world employee
roles.
Understanding: Abstract class, common data members, constructor, and abstract
method implementation.
*/

// File: Employee.java
abstract class AbstractEmployee {
    protected String name;
    protected double salary;
    protected String department;
    protected int employeeId;
    private static int nextId = 1001;
    
    // TODO: Constructor to initialize values
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employeeId = nextId++;
        System.out.println("Employee created: " + name + " (ID: " + employeeId + ")");
    }
    
    // Overloaded constructor with department
    public Employee(String name, double salary, String department) {
        this(name, salary);
        this.department = department;
    }
    
    // TODO: Abstract method calculateBonus()
    public abstract double calculateBonus();
    
    // TODO: Non-abstract method displayDetails()
    public void displayDetails() {
        System.out.println("\n=== Employee Details ===");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + (department != null ? department : "Not Assigned"));
        System.out.println("Base Salary: $" + salary);
        System.out.println("Bonus Amount: $" + calculateBonus());
        System.out.println("Total Compensation: $" + (salary + calculateBonus()));
        System.out.println("Employee Type: " + getClass().getSimpleName());
    }
    
    // Additional methods
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
        System.out.println("Salary updated for " + name + ": $" + salary);
    }
}

// File: Manager.java
class Manager extends AbstractEmployee {
    private int teamSize;
    private String[] projects;
    
    public Manager(String name, double salary) {
        super(name, salary, "Management");
        this.teamSize = 0;
    }
    
    public Manager(String name, double salary, int teamSize) {
        super(name, salary, "Management");
        this.teamSize = teamSize;
    }
    
    // TODO: Implement calculateBonus() -> salary * 0.20
    @Override
    public double calculateBonus() {
        double baseBonus = salary * 0.20;
        double teamBonus = teamSize * 500; // Additional bonus per team member
        return baseBonus + teamBonus;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
        System.out.println("Management Bonus Rate: 20% + $500 per team member");
    }
    
    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
}

// File: Developer.java
class Developer extends AbstractEmployee {
    private String programmingLanguage;
    private int projectsCompleted;
    private String specialization;
    
    public Developer(String name, double salary) {
        super(name, salary, "Engineering");
        this.projectsCompleted = 0;
    }
    
    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary, "Engineering");
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = 0;
    }
    
    // TODO: Implement calculateBonus() -> salary * 0.10
    @Override
    public double calculateBonus() {
        double baseBonus = salary * 0.10;
        double projectBonus = projectsCompleted * 1000; // Bonus per completed project
        return baseBonus + projectBonus;
    }
    
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + (programmingLanguage != null ? programmingLanguage : "Not Specified"));
        System.out.println("Projects Completed: " + projectsCompleted);
        System.out.println("Developer Bonus Rate: 10% + $1000 per completed project");
    }
    
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }
    
    public void setProjectsCompleted(int projectsCompleted) {
        this.projectsCompleted = projectsCompleted;
    }
}

// File: EmployeeTest.java
public class Employee {
    public static void main(String[] args) {
        System.out.println("=== Employee Management System - Abstract Class Demo ===");
        
        // TODO: Create Employee reference -> Manager("Alice", 50000)
        System.out.println("\n--- Creating Manager ---");
        AbstractEmployee manager = new Manager("Alice Johnson", 50000, 8);
        
        // TODO: Create Employee reference -> Developer("Bob", 40000)
        System.out.println("\n--- Creating Developer ---");
        AbstractEmployee developer = new Developer("Bob Smith", 40000, "Java");
        
        // Set additional properties
        ((Developer) developer).setProjectsCompleted(5);
        
        // TODO: Call displayDetails() and calculateBonus() for both
        System.out.println("\n" + "=".repeat(60));
        manager.displayDetails();
        
        System.out.println("\n" + "=".repeat(60));
        developer.displayDetails();
        
        // Demonstrate polymorphism
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\n=== Polymorphic Behavior Demo ===");
        AbstractEmployee[] employees = {
            new Manager("Carol Davis", 60000, 12),
            new Developer("David Wilson", 45000, "Python"),
            new Manager("Eve Brown", 55000, 6),
            new Developer("Frank Miller", 42000, "JavaScript")
        };
        
        ((Developer) employees[1]).setProjectsCompleted(3);
        ((Developer) employees[3]).setProjectsCompleted(7);
        
        double totalCompensation = 0;
        for (AbstractEmployee emp : employees) {
            System.out.println("\n--- " + emp.getName() + " (" + emp.getClass().getSimpleName() + ") ---");
            System.out.println("Salary: $" + emp.getSalary());
            System.out.println("Bonus: $" + emp.calculateBonus());
            totalCompensation += (emp.getSalary() + emp.calculateBonus());
        }
        
        System.out.println("\n=== Summary ===");
        System.out.println("Total employees: " + employees.length);
        System.out.println("Total compensation budget: $" + totalCompensation);
        
        System.out.println("\n=== Abstraction Benefits ===");
        System.out.println("- Common structure defined in abstract Employee class");
        System.out.println("- Each employee type implements bonus calculation differently");
        System.out.println("- Polymorphic behavior through Employee references");
        System.out.println("- Code reusability and maintainability");
    }
}