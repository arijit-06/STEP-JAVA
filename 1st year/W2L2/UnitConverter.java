/*
Level 2 Practice Program 16: Unit Converter Utility Class
*/

import java.util.Scanner;

public class UnitConverter {
    
    // Distance conversions
    public static double convertKmToMiles(double km) {
        return km * 0.621371;
    }
    
    public static double convertMilesToKm(double miles) {
        return miles * 1.60934;
    }
    
    public static double convertMetersToFeet(double meters) {
        return meters * 3.28084;
    }
    
    public static double convertFeetToMeters(double feet) {
        return feet * 0.3048;
    }
    
    // Temperature conversions
    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    
    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    
    // Weight conversions
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }
    
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Unit Converter Demo ===");
        
        System.out.print("Enter distance in km: ");
        double km = scanner.nextDouble();
        System.out.println(km + " km = " + convertKmToMiles(km) + " miles");
        
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        System.out.println(fahrenheit + "°F = " + convertFahrenheitToCelsius(fahrenheit) + "°C");
        
        System.out.print("Enter weight in pounds: ");
        double pounds = scanner.nextDouble();
        System.out.println(pounds + " lbs = " + convertPoundsToKilograms(pounds) + " kg");
        
        scanner.close();
    }
}