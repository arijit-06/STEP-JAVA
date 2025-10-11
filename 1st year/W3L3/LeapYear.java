/*
Level 3 Practice Program 5: Leap Year Checker
*/

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar)");
            return;
        }
        
        boolean isLeapYear = false;
        
        // Multiple if-else approach
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    isLeapYear = true;
                }
            } else {
                isLeapYear = true;
            }
        }
        
        // Single if with logical operators
        boolean isLeapYearSingle = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        
        System.out.println("Year " + year + " is " + (isLeapYear ? "a Leap Year" : "not a Leap Year"));
        System.out.println("Single condition result: " + (isLeapYearSingle ? "Leap Year" : "Not Leap Year"));
        
        scanner.close();
    }
}