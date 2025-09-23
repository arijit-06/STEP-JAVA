// File: BankAccountSystem.java
// ASSIGNMENT 1: Bank Account Management System

public class BankAccountSystem {
    
    public static class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;
        private static int totalAccounts = 0;
        private static String bankName = "National Bank";
        private static double interestRate = 0.03;
        
        public BankAccount(String holderName, double initialBalance) {
            this.accountNumber = generateAccountNumber();
            this.holderName = holderName;
            this.balance = initialBalance;
            totalAccounts++;
        }
        
        private static String generateAccountNumber() {
            return "ACC" + String.format("%06d", totalAccounts + 1);
        }
        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + " to " + accountNumber);
            }
        }
        
        public boolean withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " from " + accountNumber);
                return true;
            }
            return false;
        }
        
        public static double calculateInterest(double principal) {
            return principal * interestRate;
        }
        
        public void applyInterest() {
            double interest = calculateInterest(balance);
            balance += interest;
            System.out.println("Interest applied: $" + interest);
        }
        
        public void displayAccount() {
            System.out.println("Account: " + accountNumber + ", Holder: " + holderName + ", Balance: $" + balance);
        }
        
        public static int getTotalAccounts() { return totalAccounts; }
        public static void setBankName(String name) { bankName = name; }
        public static void setInterestRate(double rate) { interestRate = rate; }
        public double getBalance() { return balance; }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Bank Account Management System ===");
        
        BankAccount acc1 = new BankAccount("Alice Johnson", 1000);
        BankAccount acc2 = new BankAccount("Bob Smith", 1500);
        BankAccount acc3 = new BankAccount("Carol Davis", 2000);
        
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
        
        System.out.println("\nTotal accounts: " + BankAccount.getTotalAccounts());
        
        acc1.deposit(500);
        acc2.withdraw(200);
        acc3.applyInterest();
        
        System.out.println("\nAfter transactions:");
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}