/*
Level 2 Practice Program 7: Integer Operations with Precedence
*/

import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter value for b: ");
        int b = scanner.nextInt();
        
        System.out.print("Enter value for c: ");
        int c = scanner.nextInt();
        
        int result1 = a + b * c;      // Multiplication first, then addition
        int result2 = a * b + c;      // Multiplication first, then addition
        int result3 = c + a / b;      // Division first, then addition
        int result4 = a % b + c;      // Modulus first, then addition
        
        System.out.println("The results of Int Operations are " + result1 + ", " + result2 
                          + ", " + result3 + ", and " + result4);
        
        scanner.close();
    }
}