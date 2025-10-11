/*
Level 2 Practice Program 4: Distance Converter (Feet to Yards and Miles)
*/

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = scanner.nextDouble();
        
        double distanceInYards = distanceInFeet / 3; // 1 yard = 3 feet
        double distanceInMiles = distanceInYards / 1760; // 1 mile = 1760 yards
        
        System.out.println("Distance " + distanceInFeet + " feet is " + distanceInYards 
                          + " yards and " + distanceInMiles + " miles");
        
        scanner.close();
    }
}