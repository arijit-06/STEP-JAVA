/*
Level 2 Practice Program 9: Print Odd and Even Numbers
*/

import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a natural number (positive integer)");
            return;
        }
        
        System.out.println("Numbers from 1 to " + number + ":");
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even number");
            } else {
                System.out.println(i + " is odd number");
            }
        }
        
        scanner.close();
    }
}