import java.util.Date;

class Employee {
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
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Department: " + department + ", Salary: $" + calculateSalary());
    }

    public void takeBreak() {
        System.out.println("Employee taking break");
    }

    public void clockIn() {
        System.out.println("Employee clocked in");
    }

    public void clockOut() {
        System.out.println("Employee clocked out");
    }
}

class Developer extends Employee {
    private String[] programmingLanguages;
    private String experienceLevel;
    private int projectsCompleted;

    public Developer(String employeeId, String name, double baseSalary, String department, String[] programmingLanguages, String experienceLevel, int projectsCompleted) {
        super(employeeId, name, baseSalary, department);
        this.programmingLanguages = programmingLanguages;
        this.experienceLevel = experienceLevel;
        this.projectsCompleted = projectsCompleted;
        System.out.println("Developer profile created");
    }

    @Override
    public double calculateSalary() {
        double experienceBonus = experienceLevel.equals("Senior") ? 20000 : experienceLevel.equals("Mid") ? 10000 : 0;
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
        System.out.println("Writing code in " + programmingLanguages[0]);
    }

    public void reviewCode() {
        System.out.println("Reviewing team's code");
    }

    public void deployApplication() {
        System.out.println("Deploying application to production");
    }
}

class Manager extends Employee {
    private int teamSize;
    private String managementLevel;
    private double budgetResponsibility;

    public Manager(String employeeId, String name, double baseSalary, String department, int teamSize, String managementLevel, double budgetResponsibility) {
        super(employeeId, name, baseSalary, department);
        this.teamSize = teamSize;
        this.managementLevel = managementLevel;
        this.budgetResponsibility = budgetResponsibility;
        System.out.println("Manager profile created");
    }

    @Override
    public double calculateSalary() {
        double teamBonus = teamSize * 2000;
        double levelBonus = managementLevel.equals("Director") ? 30000 : managementLevel.equals("Manager") ? 15000 : 5000;
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
        System.out.println("Managing department budget");
    }
}

class Intern extends Employee {
    private String university;
    private int internshipDuration;
    private String mentor;
    private boolean isFullTime;

    public Intern(String employeeId, String name, String department, String university, int internshipDuration, String mentor, boolean isFullTime) {
        super(employeeId, name, 1000, department);
        this.university = university;
        this.internshipDuration = internshipDuration;
        this.mentor = mentor;
        this.isFullTime = isFullTime;
        System.out.println("Intern onboarded");
    }

    @Override
    public double calculateSalary() {
        return isFullTime ? 1500 : 1000;
    }

    @Override
    public String getJobDescription() {
        return "Intern";
    }

    @Override
    public void performWork() {
        System.out.println("Intern is learning and assisting");
    }

    public void attendTraining() {
        System.out.println("Intern attending training session");
    }

    public void submitReport() {
        System.out.println("Submitting weekly progress report");
    }

    public void seekMentorship() {
        System.out.println("Getting guidance from mentor");
    }
}

class EmployeeManager {
    public static double calculateTotalPayroll(Employee[] employees) {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.calculateSalary();
        }
        return total;
    }

    public static void generateReport(Employee[] employees) {
        System.out.println("=== EMPLOYEE REPORT ===");
        for (Employee emp : employees) {
            System.out.println(emp.getJobDescription() + ": " + emp.name + " - $" + emp.calculateSalary());
        }
        System.out.println("Total Payroll: $" + calculateTotalPayroll(employees));
    }
}

public class HierarchicalInheritanceDemo {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];
        
        employees[0] = new Developer("DEV001", "Alice Johnson", 80000, "IT", new String[]{"Java", "Python"}, "Senior", 15);
        employees[1] = new Manager("MGR001", "Bob Smith", 90000, "IT", 8, "Manager", 500000);
        employees[2] = new Intern("INT001", "Charlie Brown", "IT", "MIT", 12, "DEV001", true);
        employees[3] = new Developer("DEV002", "Diana Prince", 60000, "IT", new String[]{"JavaScript", "React"}, "Mid", 8);

        System.out.println("\n=== Testing Polymorphic Method Calls ===");
        for (Employee emp : employees) {
            emp.performWork();
            emp.attendMeeting();
            System.out.println("Salary: $" + emp.calculateSalary());
            System.out.println();
        }

        System.out.println("=== Testing instanceof ===");
        for (Employee emp : employees) {
            if (emp instanceof Developer) {
                ((Developer) emp).writeCode();
            } else if (emp instanceof Manager) {
                ((Manager) emp).assignTasks();
            } else if (emp instanceof Intern) {
                ((Intern) emp).attendTraining();
            }
        }

        System.out.println("\n=== Testing Final Methods ===");
        for (Employee emp : employees) {
            emp.printEmployeeDetails();
        }

        System.out.println();
        EmployeeManager.generateReport(employees);
    }
}