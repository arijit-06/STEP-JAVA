/*
Level 2 Practice Program 10: Employee Bonus Calculator
*/

import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter years of service: ");
        int yearsOfService = scanner.nextInt();
        
        double bonusAmount;
        if (yearsOfService > 5) {
            bonusAmount = salary * 0.05; // 5% bonus
        } else {
            bonusAmount = 0; // No bonus
        }
        
        System.out.println("Employee with " + yearsOfService + " years of service gets bonus: INR " + bonusAmount);
        
        scanner.close();
    }
}