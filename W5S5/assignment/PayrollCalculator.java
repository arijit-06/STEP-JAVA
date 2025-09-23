// File: PayrollCalculator.java
// ASSIGNMENT 4: Employee Payroll Calculator

public class PayrollCalculator {
    
    public static class Employee {
        private String name;
        private double salary;
        private static double taxRate = 0.15;
        private static double totalPayroll = 0;
        
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
            totalPayroll += salary;
        }
        
        public static double calculateTax(double salary) {
            return salary * taxRate;
        }
        
        public double getNetSalary() {
            return salary - calculateTax(salary);
        }
        
        public void displayPayslip() {
            double tax = calculateTax(salary);
            System.out.println(name + " - Gross: $" + salary + ", Tax: $" + tax + ", Net: $" + getNetSalary());
        }
        
        public static double getTotalPayroll() { return totalPayroll; }
        public static void setTaxRate(double rate) { taxRate = rate; }
    }
    
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", 5000);
        Employee e2 = new Employee("Bob", 4500);
        Employee e3 = new Employee("Carol", 5500);
        
        e1.displayPayslip();
        e2.displayPayslip();
        e3.displayPayslip();
        
        System.out.println("Total payroll: $" + Employee.getTotalPayroll());
    }
}