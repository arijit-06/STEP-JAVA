/*
Problem 3: getClass()
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
        // 1. Create array of Payment references with CreditCardPayment and WalletPayment
        Payment[] payments = {
            new CreditCardPayment(),
            new WalletPayment(),
            new UPIPayment(),
            new Payment()
        };
        
        System.out.println("=== Payment Gateway Processing ===");
        
        // 2. Loop, call getClass().getSimpleName(), and pay()
        for (Payment payment : payments) {
            System.out.println("\nPayment Type: " + payment.getClass().getSimpleName());
            System.out.println("Full Class Name: " + payment.getClass().getName());
            payment.pay();
        }
        
        System.out.println("\n=== Runtime Type Checking ===");
        for (Payment payment : payments) {
            String className = payment.getClass().getSimpleName();
            System.out.println("\nProcessing " + className + ":");
            
            if (payment instanceof CreditCardPayment) {
                System.out.println("- Applying 2% processing fee for credit card");
            } else if (payment instanceof WalletPayment) {
                System.out.println("- No processing fee for wallet payment");
            } else if (payment instanceof UPIPayment) {
                System.out.println("- Instant processing for UPI payment");
            } else {
                System.out.println("- Standard processing for generic payment");
            }
            
            payment.pay();
        }
    }
}