class Employee {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    
    // Constructor for full-time employees
    public Employee(String empId, String empName, String department, double baseSalary) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-time";
        totalEmployees++;
    }
    
    // Constructor for part-time employees
    public Employee(String empId, String empName, String department, double hourlyRate, int hours) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-time";
        totalEmployees++;
    }
    
    // Constructor for contract employees
    public Employee(String empId, String empName, String department, double contractAmount, boolean isContract) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.baseSalary = contractAmount;
        this.empType = "Contract";
        totalEmployees++;
    }
    
    // Overloaded calculateSalary for full-time (base + bonus)
    public double calculateSalary(double bonus) {
        if (empType.equals("Full-time")) {
            return baseSalary + bonus;
        }
        return baseSalary;
    }
    
    // Overloaded calculateSalary for part-time (hourly rate × hours)
    public double calculateSalary(double hourlyRate, int hours) {
        if (empType.equals("Part-time")) {
            return hourlyRate * hours;
        }
        return baseSalary;
    }
    
    // Overloaded calculateSalary for contract (fixed amount)
    public double calculateSalary() {
        return baseSalary;
    }
    
    // Overloaded calculateTax for full-time (15% tax)
    public double calculateTax(double salary) {
        if (empType.equals("Full-time")) {
            return salary * 0.15;
        }
        return salary * 0.10; // Default 10%
    }
    
    // Overloaded calculateTax for part-time (10% tax)
    public double calculateTax(double salary, String type) {
        if (type.equals("Part-time")) {
            return salary * 0.10;
        }
        return salary * 0.15;
    }
    
    // Overloaded calculateTax for contract (5% tax)
    public double calculateTax(double salary, boolean isContract) {
        if (isContract) {
            return salary * 0.05;
        }
        return salary * 0.10;
    }
    
    public void generatePaySlip() {
        double salary = 0;
        double tax = 0;
        
        switch (empType) {
            case "Full-time":
                salary = calculateSalary(500); // $500 bonus
                tax = calculateTax(salary);
                break;
            case "Part-time":
                salary = calculateSalary(20, 80); // $20/hour, 80 hours
                tax = calculateTax(salary, "Part-time");
                break;
            case "Contract":
                salary = calculateSalary();
                tax = calculateTax(salary, true);
                break;
        }
        
        System.out.println("=== PAY SLIP ===");
        System.out.println("Employee: " + empName + " (" + empId + ")");
        System.out.println("Department: " + department);
        System.out.println("Type: " + empType);
        System.out.println("Gross Salary: $" + salary);
        System.out.println("Tax: $" + tax);
        System.out.println("Net Salary: $" + (salary - tax));
        System.out.println("================");
    }
    
    public void displayEmployeeInfo() {
        System.out.println(empId + ": " + empName + " (" + empType + ") - " + department + " - $" + baseSalary);
    }
    
    public static int getTotalEmployees() { return totalEmployees; }
    public static double generateCompanyPayroll(Employee[] employees) {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.baseSalary;
        }
        return total;
    }
    
    public String getEmpType() { return empType; }
    public double getBaseSalary() { return baseSalary; }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[6];
        
        // Full-time employees
        employees[0] = new Employee("E001", "John Doe", "IT", 5000);
        employees[1] = new Employee("E002", "Jane Smith", "HR", 4500);
        
        // Part-time employees (empId, name, dept, hourlyRate, hours)
        employees[2] = new Employee("E003", "Bob Johnson", "IT", 25, 60);
        employees[3] = new Employee("E004", "Alice Brown", "Marketing", 20, 40);
        
        // Contract employees (empId, name, dept, contractAmount, isContract)
        employees[4] = new Employee("E005", "Charlie Wilson", "Consulting", 8000, true);
        employees[5] = new Employee("E006", "Eva Davis", "Design", 6000, true);
        
        System.out.println("=== Employee Payroll System ===");
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
        
        System.out.println("\n=== Employee Information ===");
        for (Employee emp : employees) {
            emp.displayEmployeeInfo();
        }
        
        System.out.println("\n=== Method Overloading Demonstration ===");
        System.out.println("Different calculateSalary methods for different employee types:");
        
        for (Employee emp : employees) {
            System.out.println("\n" + emp.getEmpType() + " Employee:");
            emp.generatePaySlip();
        }
        
        System.out.println("\n=== Company Statistics ===");
        System.out.println("Total Company Payroll: $" + Employee.generateCompanyPayroll(employees));
        
        // Count employees by type
        int fullTime = 0, partTime = 0, contract = 0;
        for (Employee emp : employees) {
            switch (emp.getEmpType()) {
                case "Full-time": fullTime++; break;
                case "Part-time": partTime++; break;
                case "Contract": contract++; break;
            }
        }
        
        System.out.println("Full-time: " + fullTime + ", Part-time: " + partTime + ", Contract: " + contract);
        
        System.out.println("\n=== Method Overloading Benefits ===");
        System.out.println("✓ Same method names (calculateSalary, calculateTax) with different parameters");
        System.out.println("✓ Flexible salary calculation based on employee type");
        System.out.println("✓ Different tax rates for different employment types");
        System.out.println("✓ Code reusability and maintainability");
    }
}