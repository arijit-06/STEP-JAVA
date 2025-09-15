public class EmployeePayroll {
    private String empId;
    private String empName;
    private String department;
    private double baseSalary;
    private String empType;
    private static int totalEmployees = 0;
    private static int empCounter = 0;

    public EmployeePayroll(String empName, String department, double baseSalary) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = baseSalary;
        this.empType = "Full-time";
        totalEmployees++;
    }

    public EmployeePayroll(String empName, String department, double hourlyRate, int hours) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-time";
        totalEmployees++;
    }

    public EmployeePayroll(String empName, String department, double contractAmount, String contract) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.baseSalary = contractAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    public double calculateSalary() {
        if (empType.equals("Full-time")) {
            return baseSalary + (baseSalary * 0.1);
        }
        return baseSalary;
    }

    public double calculateSalary(double bonus) {
        return baseSalary + bonus;
    }

    public double calculateSalary(double hourlyRate, int hours) {
        return hourlyRate * hours;
    }

    public double calculateTax() {
        if (empType.equals("Full-time")) {
            return calculateSalary() * 0.2;
        } else if (empType.equals("Part-time")) {
            return calculateSalary() * 0.1;
        } else {
            return calculateSalary() * 0.15;
        }
    }

    public double calculateTax(double customRate) {
        return calculateSalary() * customRate;
    }

    public void generatePaySlip() {
        double salary = calculateSalary();
        double tax = calculateTax();
        System.out.println("=== PAY SLIP ===");
        System.out.println("ID: " + empId + ", Name: " + empName);
        System.out.println("Department: " + department + ", Type: " + empType);
        System.out.println("Gross Salary: $" + salary);
        System.out.println("Tax: $" + tax);
        System.out.println("Net Salary: $" + (salary - tax));
        System.out.println();
    }

    public void displayEmployeeInfo() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Dept: " + department + ", Type: " + empType);
    }

    public static int getTotalEmployees() {
        return totalEmployees;
    }

    public static String generateEmpId() {
        empCounter++;
        return "EMP" + String.format("%03d", empCounter);
    }

    public static void generateCompanyReport(EmployeePayroll[] employees) {
        double totalPayroll = 0;
        for (EmployeePayroll emp : employees) {
            totalPayroll += emp.calculateSalary();
        }
        System.out.println("=== COMPANY REPORT ===");
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Payroll: $" + totalPayroll);
    }

    public static void main(String[] args) {
        EmployeePayroll[] employees = {
            new EmployeePayroll("John Doe", "IT", 5000),
            new EmployeePayroll("Jane Smith", "HR", 25, 160),
            new EmployeePayroll("Bob Johnson", "Finance", 8000, "contract")
        };

        for (EmployeePayroll emp : employees) {
            emp.displayEmployeeInfo();
            emp.generatePaySlip();
        }

        generateCompanyReport(employees);
    }
}