/*
Problem 3: Interface for Payment Gateway
Problem Statement:
Create an interface PaymentGateway with methods pay() and refund().
Implement this interface in CreditCardPayment and UPIPayment. Demonstrate
multiple payment methods using interfaces.
Understanding: Interface implementation and abstraction through contracts.
*/

// File: PaymentGateway.java
interface PaymentGateway {
    // TODO: Declare method pay(double amount)
    void pay(double amount);
    
    // TODO: Declare method refund(double amount)
    void refund(double amount);
    
    // Additional method to show payment gateway info
    default void showGatewayInfo() {
        System.out.println("Payment Gateway Interface - Supports pay() and refund() operations");
    }
}

// File: CreditCardPayment.java
class CreditCardPayment implements PaymentGateway {
    private String cardNumber;
    private String cardHolderName;
    
    public CreditCardPayment() {
        this.cardNumber = "**** **** **** 1234";
        this.cardHolderName = "John Doe";
    }
    
    // TODO: Implement pay() -> "Paid via Credit Card"
    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card: " + cardNumber);
        System.out.println("Cardholder: " + cardHolderName);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Status: SUCCESS - Paid $" + amount + " via Credit Card");
    }
    
    // TODO: Implement refund() -> "Refund to Credit Card"
    @Override
    public void refund(double amount) {
        System.out.println("Processing Credit Card Refund...");
        System.out.println("Refunding $" + amount + " to Credit Card " + cardNumber);
        System.out.println("Refund Status: SUCCESS - Refund processed to Credit Card");
    }
}

// File: UPIPayment.java
class UPIPayment implements PaymentGateway {
    private String upiId;
    private String bankName;
    
    public UPIPayment() {
        this.upiId = "user@paytm";
        this.bankName = "State Bank of India";
    }
    
    // TODO: Implement pay() -> "Paid via UPI"
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI Payment...");
        System.out.println("UPI ID: " + upiId);
        System.out.println("Bank: " + bankName);
        System.out.println("Amount: $" + amount);
        System.out.println("Payment Status: SUCCESS - Paid $" + amount + " via UPI");
    }
    
    // TODO: Implement refund() -> "Refund to UPI"
    @Override
    public void refund(double amount) {
        System.out.println("Processing UPI Refund...");
        System.out.println("Refunding $" + amount + " to UPI ID: " + upiId);
        System.out.println("Refund Status: SUCCESS - Refund processed to UPI account");
    }
}

// File: PaymentTest.java
public class PaymentGateway {
    public static void main(String[] args) {
        System.out.println("=== Payment Gateway Interface Demo ===");
        
        // TODO: Create PaymentGateway reference -> CreditCardPayment
        System.out.println("\n--- Credit Card Payment ---");
        PaymentGateway creditCard = new CreditCardPayment();
        creditCard.showGatewayInfo();
        // TODO: Call pay() and refund()
        creditCard.pay(500.00);
        System.out.println();
        creditCard.refund(100.00);
        
        System.out.println("\n" + "=".repeat(50));
        
        // TODO: Create PaymentGateway reference -> UPIPayment
        System.out.println("\n--- UPI Payment ---");
        PaymentGateway upi = new UPIPayment();
        upi.showGatewayInfo();
        // TODO: Call pay() and refund()
        upi.pay(300.00);
        System.out.println();
        upi.refund(50.00);
        
        System.out.println("\n=== Interface Benefits ===");
        System.out.println("- Same interface for different payment methods");
        System.out.println("- Easy to add new payment gateways");
        System.out.println("- Polymorphic behavior through interface references");
        
        // Demonstrating polymorphism
        System.out.println("\n--- Polymorphic Payment Processing ---");
        PaymentGateway[] gateways = {new CreditCardPayment(), new UPIPayment()};
        for (PaymentGateway gateway : gateways) {
            gateway.pay(250.00);
            System.out.println();
        }
    }
}