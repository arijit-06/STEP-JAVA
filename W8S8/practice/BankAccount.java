/*
Problem 2: Bank Account with Abstract Methods
Problem Statement:
Design an abstract class BankAccount with abstract method calculateInterest(). 
Subclasses SavingsAccount and CurrentAccount should implement it differently. 
Demonstrate abstraction by handling different account types.
Understanding: Abstract class with both abstract and non-abstract methods.
*/

// File: BankAccount.java
abstract class AbstractBankAccount {
    protected double balance;
    
    // TODO: Create constructor to set balance
    public BankAccount(double balance) {
        this.balance = balance;
        System.out.println("Bank Account created with balance: $" + balance);
    }
    
    // TODO: Create abstract method calculateInterest()
    public abstract void calculateInterest();
    
    // TODO: Create non-abstract method displayBalance() -> print balance
    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
    
    // Additional method to get balance
    public double getBalance() {
        return balance;
    }
}

// File: SavingsAccount.java
class SavingsAccount extends AbstractBankAccount {
    public SavingsAccount(double balance) {
        super(balance);
        System.out.println("Savings Account initialized");
    }
    
    // TODO: Implement calculateInterest() -> interest = balance * 0.04
    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        balance += interest;
        System.out.println("Savings Account Interest (4%): $" + interest);
        System.out.println("New balance after interest: $" + balance);
    }
}

// File: CurrentAccount.java
class CurrentAccount extends AbstractBankAccount {
    public CurrentAccount(double balance) {
        super(balance);
        System.out.println("Current Account initialized");
    }
    
    // TODO: Implement calculateInterest() -> interest = balance * 0.02
    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        balance += interest;
        System.out.println("Current Account Interest (2%): $" + interest);
        System.out.println("New balance after interest: $" + balance);
    }
}

// File: BankTest.java
public class BankAccount {
    public static void main(String[] args) {
        System.out.println("=== Bank Account Abstraction Demo ===");
        
        // TODO: Create BankAccount reference -> SavingsAccount
        System.out.println("\n--- Creating Savings Account ---");
        AbstractBankAccount savings = new SavingsAccount(10000);
        // TODO: Call displayBalance() and calculateInterest()
        savings.displayBalance();
        savings.calculateInterest();
        
        System.out.println("\n--- Creating Current Account ---");
        // TODO: Create BankAccount reference -> CurrentAccount
        AbstractBankAccount current = new CurrentAccount(15000);
        // TODO: Call displayBalance() and calculateInterest()
        current.displayBalance();
        current.calculateInterest();
        
        System.out.println("\n=== Abstraction Benefits ===");
        System.out.println("- Same interface (BankAccount) for different account types");
        System.out.println("- Each account type implements interest calculation differently");
        System.out.println("- Common functionality (displayBalance) shared through abstract class");
    }
}