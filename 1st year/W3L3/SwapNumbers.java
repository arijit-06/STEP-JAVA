/*
Level 3 Practice Program 4: Swap Two Numbers
*/

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int number1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int number2 = scanner.nextInt();
        
        System.out.println("Before swapping: " + number1 + " and " + number2);
        
        // Swapping using temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;
        
        System.out.println("The swapped numbers are " + number1 + " and " + number2);
        
        scanner.close();
    }
}