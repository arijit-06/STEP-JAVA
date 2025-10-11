/*
Level 2 Practice Program 8: Double Operations with Precedence
*/

import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();
        
        double result1 = a + b * c;      // Multiplication first, then addition
        double result2 = a * b + c;      // Multiplication first, then addition
        double result3 = c + a / b;      // Division first, then addition
        double result4 = a % b + c;      // Modulus first, then addition
        
        System.out.println("The results of Double Operations are " + result1 + ", " + result2 
                          + ", " + result3 + ", and " + result4);
        
        scanner.close();
    }
}