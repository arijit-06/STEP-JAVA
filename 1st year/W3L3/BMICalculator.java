/*
Level 3 Practice Program 9: BMI Calculator
*/

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();
        
        // Convert height from cm to meters
        double heightInMeters = height / 100;
        
        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);
        
        String status;
        if (bmi <= 18.4) {
            status = "underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            status = "normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            status = "overweight";
        } else {
            status = "obese";
        }
        
        System.out.printf("Weight: %.1f kg%n", weight);
        System.out.printf("Height: %.1f cm%n", height);
        System.out.printf("BMI: %.2f%n", bmi);
        System.out.println("Status: " + status);
        
        scanner.close();
    }
}