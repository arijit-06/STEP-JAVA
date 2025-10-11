/*
Level 2 Practice Program 2: Triangle Area Calculator
*/

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base: ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter height: ");
        double height = scanner.nextDouble();
        
        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 6.4516; // 1 square inch = 6.4516 square cm
        
        System.out.println("Area of triangle with base " + base + " and height " + height 
                          + " is " + areaInches + " square inches and " + areaCm + " square centimeters");
        
        scanner.close();
    }
}