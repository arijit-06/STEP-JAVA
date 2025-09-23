class Employee {
    private String empId;
    private String empName;
    private String department;
    private String designation;
    private double baseSalary;
    private String joinDate;
    private boolean[] attendanceRecord; // 30 days
    private String empType; // Full-time, Part-time, Contract
    
    private static int totalEmployees = 0;
    private static String companyName = "Tech Solutions Inc.";
    private static double totalSalaryExpense = 0;
    private static int workingDaysPerMonth = 22;
    
    public Employee(String empName, String department, String designation, double baseSalary, String joinDate, String empType) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
        this.empType = empType;
        this.attendanceRecord = new boolean[30];
        totalEmployees++;
    }
    
    private static String generateEmpId() {
        return "EMP" + String.format("%03d", totalEmployees + 1);
    }
    
    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30) {
            attendanceRecord[day - 1] = present;
            System.out.println("Attendance marked for " + empName + " on day " + day + ": " + (present ? "Present" : "Absent"));
        } else {
            System.out.println("Invalid day. Must be between 1-30");
        }
    }
    
    public int getAttendanceDays() {
        int count = 0;
        for (boolean present : attendanceRecord) {
            if (present) count++;
        }
        return count;
    }
    
    public double calculateSalary() {
        int attendedDays = getAttendanceDays();
        double salary = 0;
        
        switch (empType) {
            case "Full-time":
                salary = baseSalary; // Fixed monthly salary
                // Deduct for absences
                if (attendedDays < workingDaysPerMonth) {
                    double deduction = (baseSalary / workingDaysPerMonth) * (workingDaysPerMonth - attendedDays);
                    salary -= deduction;
                }
                break;
            case "Part-time":
                salary = (baseSalary / workingDaysPerMonth) * attendedDays; // Daily rate
                break;
            case "Contract":
                salary = baseSalary; // Fixed contract amount
                break;
        }
        
        return salary;
    }
    
    public double calculateBonus() {
        int attendedDays = getAttendanceDays();
        double attendancePercentage = (double) attendedDays / workingDaysPerMonth * 100;
        
        if (attendancePercentage >= 95) return baseSalary * 0.10; // 10% bonus
        else if (attendancePercentage >= 90) return baseSalary * 0.05; // 5% bonus
        else return 0;
    }
    
    public void generatePaySlip() {
        double salary = calculateSalary();
        double bonus = calculateBonus();
        double totalPay = salary + bonus;
        
        System.out.println("=== PAY SLIP ===");
        System.out.println("Company: " + companyName);
        System.out.println("Employee: " + empName + " (" + empId + ")");
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Employee Type: " + empType);
        System.out.println("Days Attended: " + getAttendanceDays() + "/" + workingDaysPerMonth);
        System.out.println("Attendance %: " + (getAttendanceDays() * 100.0 / workingDaysPerMonth) + "%");
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Calculated Salary: $" + salary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Pay: $" + totalPay);
        System.out.println("================");
        
        totalSalaryExpense += totalPay;
    }
    
    public void requestLeave(int day, String reason) {
        if (day >= 1 && day <= 30) {
            attendanceRecord[day - 1] = false;
            System.out.println("Leave approved for " + empName + " on day " + day + " - Reason: " + reason);
        } else {
            System.out.println("Invalid day for leave request");
        }
    }
    
    public static void calculateCompanyPayroll(Employee[] employees) {
        totalSalaryExpense = 0; // Reset
        System.out.println("=== COMPANY PAYROLL ===");
        for (Employee emp : employees) {
            if (emp != null) {
                double salary = emp.calculateSalary() + emp.calculateBonus();
                totalSalaryExpense += salary;
                System.out.println(emp.empName + " (" + emp.empType + "): $" + salary);
            }
        }
        System.out.println("Total Payroll: $" + totalSalaryExpense);
        System.out.println("=======================");
    }
    
    public static void getDepartmentWiseExpenses(Employee[] employees) {
        System.out.println("=== DEPARTMENT-WISE EXPENSES ===");
        String[] departments = {"IT", "HR", "Finance", "Marketing", "Operations"};
        
        for (String dept : departments) {
            double deptExpense = 0;
            int deptCount = 0;
            
            for (Employee emp : employees) {
                if (emp != null && emp.department.equals(dept)) {
                    deptExpense += emp.calculateSalary() + emp.calculateBonus();
                    deptCount++;
                }
            }
            
            if (deptCount > 0) {
                System.out.println(dept + ": " + deptCount + " employees, $" + deptExpense + " expense");
            }
        }
        System.out.println("================================");
    }
    
    public static void getAttendanceReport(Employee[] employees) {
        System.out.println("=== ATTENDANCE REPORT ===");
        for (Employee emp : employees) {
            if (emp != null) {
                int attended = emp.getAttendanceDays();
                double percentage = attended * 100.0 / workingDaysPerMonth;
                String status = percentage >= 90 ? "Excellent" : percentage >= 80 ? "Good" : percentage >= 70 ? "Average" : "Poor";
                
                System.out.println(emp.empName + " (" + emp.department + "): " + attended + "/" + workingDaysPerMonth + 
                                 " (" + percentage + "%) - " + status);
            }
        }
        System.out.println("=========================");
    }
    
    public String getEmpName() { return empName; }
    public String getDepartment() { return department; }
    public String getEmpType() { return empType; }
    public double getBaseSalary() { return baseSalary; }
    public static int getTotalEmployees() { return totalEmployees; }
    public static double getTotalSalaryExpense() { return totalSalaryExpense; }
}

class Department {
    private String deptId;
    private String deptName;
    private Employee manager;
    private Employee[] employees;
    private double budget;
    private int employeeCount;
    
    public Department(String deptName, double budget, int capacity) {
        this.deptId = generateDeptId();
        this.deptName = deptName;
        this.budget = budget;
        this.employees = new Employee[capacity];
        this.employeeCount = 0;
    }
    
    private static String generateDeptId() {
        return "DEPT" + System.currentTimeMillis() % 1000;
    }
    
    public void setManager(Employee manager) {
        this.manager = manager;
        System.out.println(manager.getEmpName() + " appointed as manager of " + deptName);
    }
    
    public void addEmployee(Employee employee) {
        if (employeeCount < employees.length) {
            employees[employeeCount] = employee;
            employeeCount++;
            System.out.println(employee.getEmpName() + " added to " + deptName + " department");
        } else {
            System.out.println("Department is at full capacity");
        }
    }
    
    public double calculateDepartmentPayroll() {
        double total = 0;
        for (int i = 0; i < employeeCount; i++) {
            total += employees[i].calculateSalary() + employees[i].calculateBonus();
        }
        return total;
    }
    
    public void displayDepartmentInfo() {
        System.out.println("=== " + deptName + " Department ===");
        System.out.println("Department ID: " + deptId);
        System.out.println("Budget: $" + budget);
        System.out.println("Manager: " + (manager != null ? manager.getEmpName() : "Not assigned"));
        System.out.println("Employees: " + employeeCount);
        System.out.println("Payroll: $" + calculateDepartmentPayroll());
        System.out.println("Budget Utilization: " + (calculateDepartmentPayroll() / budget * 100) + "%");
        
        System.out.println("Employee List:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println("  - " + employees[i].getEmpName() + " (" + employees[i].getEmpType() + ")");
        }
        System.out.println("==============================");
    }
    
    public String getDeptName() { return deptName; }
    public int getEmployeeCount() { return employeeCount; }
}

public class EmployeePayrollAttendance {
    public static void main(String[] args) {
        // Create employees
        Employee[] employees = {
            new Employee("John Doe", "IT", "Software Engineer", 5000, "2023-01-15", "Full-time"),
            new Employee("Jane Smith", "IT", "Senior Developer", 6000, "2022-03-10", "Full-time"),
            new Employee("Bob Johnson", "HR", "HR Manager", 5500, "2021-06-01", "Full-time"),
            new Employee("Alice Brown", "Finance", "Accountant", 4500, "2023-02-20", "Full-time"),
            new Employee("Charlie Wilson", "Marketing", "Marketing Specialist", 4000, "2023-04-01", "Part-time"),
            new Employee("Diana Davis", "IT", "Consultant", 7000, "2023-05-15", "Contract"),
            new Employee("Eve Miller", "Operations", "Operations Manager", 5200, "2022-08-10", "Full-time"),
            new Employee("Frank Garcia", "HR", "Recruiter", 3500, "2023-07-01", "Part-time")
        };
        
        // Create departments
        Department itDept = new Department("IT", 25000, 10);
        Department hrDept = new Department("HR", 15000, 5);
        Department financeDept = new Department("Finance", 12000, 5);
        Department marketingDept = new Department("Marketing", 10000, 5);
        Department operationsDept = new Department("Operations", 18000, 8);
        
        System.out.println("=== Employee Payroll and Attendance System ===");
        System.out.println("Total Employees: " + Employee.getTotalEmployees());
        
        // Assign employees to departments
        itDept.addEmployee(employees[0]);
        itDept.addEmployee(employees[1]);
        itDept.addEmployee(employees[5]);
        itDept.setManager(employees[1]);
        
        hrDept.addEmployee(employees[2]);
        hrDept.addEmployee(employees[7]);
        hrDept.setManager(employees[2]);
        
        financeDept.addEmployee(employees[3]);
        marketingDept.addEmployee(employees[4]);
        operationsDept.addEmployee(employees[6]);
        operationsDept.setManager(employees[6]);
        
        // Mark attendance for employees (simulate 30 days)
        System.out.println("\n=== Marking Attendance (Sample Days) ===");
        
        // Full attendance for some employees
        for (int day = 1; day <= 22; day++) {
            employees[0].markAttendance(day, true);
            employees[1].markAttendance(day, true);
            employees[2].markAttendance(day, day % 5 != 0); // Miss every 5th day
        }
        
        // Partial attendance for others
        for (int day = 1; day <= 18; day++) {
            employees[3].markAttendance(day, true);
            employees[4].markAttendance(day, day % 3 != 0); // Part-time, irregular
        }
        
        // Contract employee - different pattern
        for (int day = 1; day <= 20; day++) {
            employees[5].markAttendance(day, true);
        }
        
        // Request some leaves
        employees[0].requestLeave(23, "Personal work");
        employees[2].requestLeave(15, "Medical appointment");
        
        System.out.println("\n=== Individual Pay Slips ===");
        for (Employee emp : employees) {
            emp.generatePaySlip();
            System.out.println();
        }
        
        System.out.println("=== Company Payroll Summary ===");
        Employee.calculateCompanyPayroll(employees);
        
        System.out.println("\n=== Department-wise Information ===");
        Department[] departments = {itDept, hrDept, financeDept, marketingDept, operationsDept};
        for (Department dept : departments) {
            dept.displayDepartmentInfo();
            System.out.println();
        }
        
        System.out.println("=== Department-wise Expenses ===");
        Employee.getDepartmentWiseExpenses(employees);
        
        System.out.println("\n=== Attendance Report ===");
        Employee.getAttendanceReport(employees);
        
        System.out.println("\n=== Employee Type Analysis ===");
        int fullTime = 0, partTime = 0, contract = 0;
        double fullTimeExpense = 0, partTimeExpense = 0, contractExpense = 0;
        
        for (Employee emp : employees) {
            double totalPay = emp.calculateSalary() + emp.calculateBonus();
            switch (emp.getEmpType()) {
                case "Full-time":
                    fullTime++;
                    fullTimeExpense += totalPay;
                    break;
                case "Part-time":
                    partTime++;
                    partTimeExpense += totalPay;
                    break;
                case "Contract":
                    contract++;
                    contractExpense += totalPay;
                    break;
            }
        }
        
        System.out.println("Full-time: " + fullTime + " employees ($" + fullTimeExpense + ")");
        System.out.println("Part-time: " + partTime + " employees ($" + partTimeExpense + ")");
        System.out.println("Contract: " + contract + " employees ($" + contractExpense + ")");
        
        System.out.println("\n=== Performance Analysis ===");
        for (Employee emp : employees) {
            int attended = emp.getAttendanceDays();
            double percentage = attended * 100.0 / 22; // Working days
            double bonus = emp.calculateBonus();
            
            System.out.println(emp.getEmpName() + ": " + percentage + "% attendance, $" + bonus + " bonus");
        }
        
        System.out.println("\n=== HR Management Features Demonstrated ===");
        System.out.println("✓ Multiple employee types with different salary calculations");
        System.out.println("✓ Attendance tracking and payroll integration");
        System.out.println("✓ Performance-based bonus calculation");
        System.out.println("✓ Department-wise organization and reporting");
        System.out.println("✓ Leave management system");
        System.out.println("✓ Comprehensive HR analytics and reporting");
    }
}