/*
Level 2 Practice Program 5: Total Price Calculator
*/

import java.util.Scanner;

public class TotalPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter unit price: ");
        double unitPrice = scanner.nextDouble();
        
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
        double totalPrice = unitPrice * quantity;
        
        System.out.println("The total purchase price is INR " + totalPrice 
                          + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
        
        scanner.close();
    }
}