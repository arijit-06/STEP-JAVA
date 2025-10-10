/*
Practice Problem 2: equals(), ==, and hashCode()
Problem: "Employee Authentication System"
*/

import java.util.HashSet;
import java.util.Objects;

class Employee {
    private String empCode;
    private String name;
    
    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(empCode, employee.empCode);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(empCode);
    }
    
    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        System.out.println("=== Employee Authentication System ===");
        
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");
        Employee e3 = new Employee("BL002", "John");
        
        System.out.println("Employee 1: " + e1);
        System.out.println("Employee 2: " + e2);
        System.out.println("Employee 3: " + e3);
        
        System.out.println("\n--- Reference Comparison (==) ---");
        System.out.println("e1 == e2: " + (e1 == e2));
        
        System.out.println("\n--- Content Comparison (equals()) ---");
        System.out.println("e1.equals(e2): " + e1.equals(e2));
        System.out.println("e1.equals(e3): " + e1.equals(e3));
        
        System.out.println("\n--- HashSet Test ---");
        HashSet<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        
        System.out.println("HashSet size: " + employees.size());
        System.out.println("HashSet contents:");
        for (Employee emp : employees) {
            System.out.println("  " + emp);
        }
    }
}