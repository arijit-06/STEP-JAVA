import java.util.Scanner;

class Employee {
    private static String companyName;
    private static int totalEmployees = 0;
    private String empId;
    private String name;
    private String department;
    private double salary;

    public Employee() {
        this.empId = "EMP" + String.format("%03d", ++totalEmployees);
        this.name = "Unknown";
        this.department = "General";
        this.salary = 30000;
    }

    public Employee(String name, String department, double salary) {
        this.empId = "EMP" + String.format("%03d", ++totalEmployees);
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void displayEmployee() {
        System.out.println("ID: " + empId + ", Name: " + name + ", Dept: " + department + ", Salary: $" + salary);
    }

    public void updateSalary(double newSalary) {
        this.salary = newSalary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

class Department {
    private String deptName;
    private Employee[] employees;
    private int employeeCount;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new Employee[10];
        this.employeeCount = 0;
    }

    public void addEmployee(Employee emp) {
        if (employeeCount < employees.length) {
            employees[employeeCount++] = emp;
            System.out.println("Employee added to " + deptName);
        }
    }

    public Employee findHighestPaid() {
        Employee highest = employees[0];
        for (int i = 1; i < employeeCount; i++) {
            if (employees[i].getSalary() > highest.getSalary()) {
                highest = employees[i];
            }
        }
        return highest;
    }

    public double calculateTotalPayroll() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].getSalary();
        }
        return total;
    }

    public void displayDepartment() {
        System.out.println("=== " + deptName + " Department ===");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployee();
        }
    }

    public String getDeptName() { return deptName; }
    public Employee[] getEmployees() { return employees; }
    public int getEmployeeCount() { return employeeCount; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");
        
        Employee.setCompanyName("TechCorp Solutions");
        
        Department[] departments = {
            new Department("IT"),
            new Department("HR"),
            new Department("Finance")
        };

        departments[0].addEmployee(new Employee("Alice Johnson", "IT", 75000));
        departments[0].addEmployee(new Employee("Bob Smith", "IT", 65000));
        departments[1].addEmployee(new Employee("Carol Davis", "HR", 55000));
        departments[2].addEmployee(new Employee("David Wilson", "Finance", 70000));

        System.out.println("\n=== Department-wise Information ===");
        for (Department dept : departments) {
            dept.displayDepartment();
            System.out.println("Highest Paid: " + dept.findHighestPaid().getName());
            System.out.println("Total Payroll: $" + dept.calculateTotalPayroll());
            System.out.println();
        }

        Employee globalHighest = departments[0].findHighestPaid();
        double companyPayroll = 0;
        for (Department dept : departments) {
            Employee deptHighest = dept.findHighestPaid();
            if (deptHighest.getSalary() > globalHighest.getSalary()) {
                globalHighest = deptHighest;
            }
            companyPayroll += dept.calculateTotalPayroll();
        }

        System.out.println("=== Company Statistics ===");
        System.out.println("Highest Paid Employee: " + globalHighest.getName() + " - $" + globalHighest.getSalary());
        System.out.println("Company-wide Payroll: $" + companyPayroll);
        System.out.println("Total Employees: " + Employee.getTotalEmployees());

        scanner.close();
    }
}