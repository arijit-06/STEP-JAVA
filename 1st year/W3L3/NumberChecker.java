/*
Level 3 Practice Program 11: Number Checker Utility Class
*/

import java.util.Scanner;

public class NumberChecker {
    
    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
    
    public static int[] storeDigits(int number) {
        int digitCount = countDigits(number);
        int[] digits = new int[digitCount];
        int index = digitCount - 1;
        
        while (number != 0) {
            digits[index--] = number % 10;
            number /= 10;
        }
        return digits;
    }
    
    public static boolean isArmstrong(int number) {
        int[] digits = storeDigits(number);
        int sum = 0;
        int power = digits.length;
        
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }
    
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
    
    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        System.out.println("=== Number Analysis for " + number + " ===");
        System.out.println("Digit count: " + countDigits(number));
        System.out.println("Is Armstrong: " + isArmstrong(number));
        System.out.println("Is Prime: " + isPrime(number));
        System.out.println("Is Perfect: " + isPerfect(number));
        
        int[] digits = storeDigits(number);
        System.out.print("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}