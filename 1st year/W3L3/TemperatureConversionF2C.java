/*
Level 3 Practice Program 2: Temperature Conversion Fahrenheit to Celsius
*/

import java.util.Scanner;

public class TemperatureConversionF2C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        
        double celsiusResult = (fahrenheit - 32) * 5/9;
        
        System.out.println("The " + fahrenheit + " fahrenheit is " + celsiusResult + " celsius");
        
        scanner.close();
    }
}