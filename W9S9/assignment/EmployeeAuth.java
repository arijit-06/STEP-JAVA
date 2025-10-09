/*
Problem 2: equals(), ==, and hashCode()
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
    
    // TODO: Override equals() - same empCode means same employee
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Objects.equals(empCode, employee.empCode);
    }
    
    // TODO: Override hashCode() based on empCode
    @Override
    public int hashCode() {
        return Objects.hash(empCode);
    }
    
    // TODO: Write toString() showing both fields
    @Override
    public String toString() {
        return "Employee{empCode='" + empCode + "', name='" + name + "'}";
    }
    
    public String getEmpCode() {
        return empCode;
    }
    
    public String getName() {
        return name;
    }
}

public class EmployeeAuth {
    public static void main(String[] args) {
        // 1. Employee e1 = new Employee("BL001", "Ritika");
        Employee e1 = new Employee("BL001", "Ritika");
        
        // 2. Employee e2 = new Employee("BL001", "Ritika S.");
        Employee e2 = new Employee("BL001", "Ritika S.");
        
        // 3. Compare using e1 == e2 and e1.equals(e2)
        System.out.println("=== Employee Comparison ===");
        System.out.println("Employee 1: " + e1);
        System.out.println("Employee 2: " + e2);
        
        System.out.println("\n=== Reference Comparison (==) ===");
        System.out.println("e1 == e2: " + (e1 == e2));
        
        System.out.println("\n=== Content Comparison (equals) ===");
        System.out.println("e1.equals(e2): " + e1.equals(e2));
        
        System.out.println("\n=== HashCode Comparison ===");
        System.out.println("e1.hashCode(): " + e1.hashCode());
        System.out.println("e2.hashCode(): " + e2.hashCode());
        System.out.println("Same hashCode: " + (e1.hashCode() == e2.hashCode()));
        
        // 4. Test using HashSet<Employee>
        System.out.println("\n=== HashSet Test ===");
        HashSet<Employee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);
        
        System.out.println("HashSet size after adding both employees: " + employees.size());
        System.out.println("Contains e1: " + employees.contains(e1));
        System.out.println("Contains e2: " + employees.contains(e2));
        
        // Additional test with different empCode
        Employee e3 = new Employee("BL002", "John");
        employees.add(e3);
        System.out.println("HashSet size after adding employee with different code: " + employees.size());
    }
}