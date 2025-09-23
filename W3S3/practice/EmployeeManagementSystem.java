import java.util.Scanner;

class Employee {
    private static String companyName;
    private static int totalEmployees = 0;
    
    private String empId;
    private String name;
    private String department;
    private double salary;
    
    public Employee() {
        this.empId = "";
        this.name = "";
        this.department = "";
        this.salary = 0.0;
        totalEmployees++;
    }
    
    public Employee(String empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
        totalEmployees++;
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
    
    public String getEmpId() { return empId; }
    public void setEmpId(String empId) { this.empId = empId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public double getSalary() { return salary; }
}

class Department {
    private String deptName;
    private Employee[] employees;
    private int employeeCount;
    
    public Department(String deptName, int capacity) {
        this.deptName = deptName;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }
    
    public void addEmployee(Employee emp) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = emp;
            employeeCount++;
            System.out.println("Added employee to " + deptName);
        } else {
            System.out.println("Department is full!");
        }
    }
    
    public Employee findHighestPaid() {
        if (employeeCount == 0) return null;
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
        System.out.println("\n=== " + deptName + " Department ===");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].displayEmployee();
        }
    }
    
    public String getDeptName() { return deptName; }
    public int getEmployeeCount() { return employeeCount; }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee.setCompanyName("Tech Solutions Inc.");
        
        Department itDept = new Department("IT", 5);
        Department hrDept = new Department("HR", 3);
        
        System.out.println("=== EMPLOYEE MANAGEMENT SYSTEM ===");
        
        // Sample data
        Employee emp1 = new Employee("E001", "John Doe", "IT", 5000);
        Employee emp2 = new Employee("E002", "Jane Smith", "IT", 5500);
        Employee emp3 = new Employee("E003", "Bob Johnson", "HR", 4500);
        Employee emp4 = new Employee("E004", "Alice Brown", "HR", 4800);
        
        itDept.addEmployee(emp1);
        itDept.addEmployee(emp2);
        hrDept.addEmployee(emp3);
        hrDept.addEmployee(emp4);
        
        boolean running = true;
        while (running) {
            System.out.println("\n1. Display All Employees");
            System.out.println("2. Department Statistics");
            System.out.println("3. Company Statistics");
            System.out.println("4. Find Highest Paid");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    itDept.displayDepartment();
                    hrDept.displayDepartment();
                    break;
                case 2:
                    System.out.println("\n=== Department Statistics ===");
                    System.out.println(itDept.getDeptName() + " - Employees: " + itDept.getEmployeeCount() + 
                                     ", Payroll: $" + itDept.calculateTotalPayroll());
                    System.out.println(hrDept.getDeptName() + " - Employees: " + hrDept.getEmployeeCount() + 
                                     ", Payroll: $" + hrDept.calculateTotalPayroll());
                    break;
                case 3:
                    System.out.println("\n=== Company Statistics ===");
                    System.out.println("Total Employees: " + Employee.getTotalEmployees());
                    System.out.println("Total Payroll: $" + (itDept.calculateTotalPayroll() + hrDept.calculateTotalPayroll()));
                    break;
                case 4:
                    Employee itHighest = itDept.findHighestPaid();
                    Employee hrHighest = hrDept.findHighestPaid();
                    System.out.println("\n=== Highest Paid Employees ===");
                    System.out.print("IT: "); itHighest.displayEmployee();
                    System.out.print("HR: "); hrHighest.displayEmployee();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
        
        System.out.println("\n=== OOP Principles Demonstrated ===");
        System.out.println("✓ Encapsulation: Private variables with public methods");
        System.out.println("✓ Static vs Instance: Company name shared, employee data unique");
        System.out.println("✓ Object Interaction: Department contains Employee objects");
        System.out.println("✓ Code Reusability: Same Employee class used across departments");
        
        scanner.close();
    }
}