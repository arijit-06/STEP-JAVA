/*
Level 3 Practice Program 8: Count Digits in a Number
*/

import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int originalNumber = number;
        int count = 0;
        
        if (number == 0) {
            count = 1;
        } else {
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }
        
        System.out.println("Number of digits in " + originalNumber + " is: " + count);
        
        scanner.close();
    }
}