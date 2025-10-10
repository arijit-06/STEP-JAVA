/*
Practice Problem 3: getClass()
Problem: "Payment Gateway"
*/

class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing credit card payment");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing wallet payment");
    }
}

class UPIPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Processing UPI payment");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        System.out.println("=== Payment Gateway System ===");
        
        Payment[] payments = {
            new CreditCardPayment(),
            new WalletPayment(),
            new UPIPayment(),
            new Payment()
        };
        
        System.out.println("\n--- Processing Payments ---");
        for (Payment payment : payments) {
            System.out.println("Payment Type: " + payment.getClass().getSimpleName());
            System.out.println("Full Class Name: " + payment.getClass().getName());
            payment.pay();
            System.out.println();
        }
        
        System.out.println("--- Runtime Type Checking ---");
        Payment p = new CreditCardPayment();
        System.out.println("Runtime class: " + p.getClass().getSimpleName());
        System.out.println("Is CreditCardPayment? " + (p instanceof CreditCardPayment));
        System.out.println("Is Payment? " + (p instanceof Payment));
    }
}