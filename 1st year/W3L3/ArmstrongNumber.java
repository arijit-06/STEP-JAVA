/*
Level 3 Practice Program 7: Armstrong Number Checker
*/

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int originalNumber = number;
        int sum = 0;
        
        System.out.println("Checking if " + number + " is an Armstrong number:");
        System.out.println("Steps:");
        
        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            int cube = digit * digit * digit;
            sum += cube;
            System.out.println(digit + "^3 = " + cube);
            originalNumber = originalNumber / 10;
        }
        
        System.out.println("Sum = " + sum);
        
        if (number == sum) {
            System.out.println(number + " is an Armstrong number");
        } else {
            System.out.println(number + " is not an Armstrong number");
        }
        
        scanner.close();
    }
}