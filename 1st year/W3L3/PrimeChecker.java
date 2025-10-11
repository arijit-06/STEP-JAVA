/*
Level 3 Practice Program 6: Prime Number Checker
*/

import java.util.Scanner;

public class PrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        if (number <= 1) {
            System.out.println(number + " is not a prime number");
            return;
        }
        
        boolean isPrime = true;
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        System.out.println(number + " is " + (isPrime ? "a prime number" : "not a prime number"));
        
        scanner.close();
    }
}