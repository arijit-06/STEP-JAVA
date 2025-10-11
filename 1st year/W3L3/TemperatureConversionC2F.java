/*
Level 3 Practice Program 1: Temperature Conversion Celsius to Fahrenheit
*/

import java.util.Scanner;

public class TemperatureConversionC2F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        
        double fahrenheitResult = (celsius * 9/5) + 32;
        
        System.out.println("The " + celsius + " celsius is " + fahrenheitResult + " fahrenheit");
        
        scanner.close();
    }
}