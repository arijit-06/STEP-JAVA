/*
Topic 5: Abstraction in Real-world Example
Problem Statement:
Create an abstract class BankAccount with abstract method calculateInterest() and
concrete method deposit().
Create subclasses SavingsAccount and CurrentAccount that provide specific interest
calculation logic.
Test the program by creating objects and calling methods.
Hints:
● Define abstract void calculateInterest(); in BankAccount.
● Override calculateInterest() differently in SavingsAccount and CurrentAccount.
● Use constructor to set balance and test deposit/interest methods.
*/

abstract class AbstractBankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;
    protected String bankName;
    protected String branchCode;
    protected java.util.Date openingDate;
    protected boolean isActive;
    private static int nextAccountNumber = 100001;
    
    public AbstractBankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = "ACC" + nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.bankName = "Universal Bank";
        this.branchCode = "UB001";
        this.openingDate = new java.util.Date();
        this.isActive = true;
    }
    
    public abstract void calculateInterest();
    
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        
        balance += amount;
        System.out.println("Deposited $" + amount + ". New balance: $" + balance);
    }
    
    public void displayAccountInfo() {
        System.out.println("\n=== Account Information ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + getClass().getSimpleName());
        System.out.printf("Current Balance: $%.2f%n", balance);
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public boolean isActive() { return isActive; }
}

class SavingsAccount extends AbstractBankAccount {
    private double interestRate;
    
    public SavingsAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
        this.interestRate = 0.05;
    }
    
    public SavingsAccount(String accountHolderName, double initialBalance, double customInterestRate) {
        super(accountHolderName, initialBalance);
        this.interestRate = customInterestRate;
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.printf("Savings interest $%.2f added. Balance: $%.2f%n", interest, balance);
    }
}

class CurrentAccount extends AbstractBankAccount {
    private double interestRate;
    private double monthlyFee;
    
    public CurrentAccount(String accountHolderName, double initialBalance) {
        super(accountHolderName, initialBalance);
        this.interestRate = 0.01;
        this.monthlyFee = 15.00;
    }
    
    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        balance += interest;
        balance -= monthlyFee;
        System.out.printf("Current interest $%.2f added, fee $%.2f deducted. Balance: $%.2f%n", 
            interest, monthlyFee, balance);
    }
}

public class BankAbstraction {
    public static void main(String[] args) {
        System.out.println("=== Abstraction in Real-world Banking System Demo ===");
        
        SavingsAccount savings1 = new SavingsAccount("Alice Johnson", 5000);
        SavingsAccount savings2 = new SavingsAccount("Bob Smith", 15000, 0.06);
        CurrentAccount current1 = new CurrentAccount("Carol Davis", 8000);
        CurrentAccount current2 = new CurrentAccount("David Wilson", 2000);
        
        System.out.println("\n=== Savings Account 1 Demo ===");
        savings1.displayAccountInfo();
        savings1.deposit(2000);
        savings1.calculateInterest();
        
        System.out.println("\n=== Current Account 1 Demo ===");
        current1.displayAccountInfo();
        current1.deposit(3000);
        current1.calculateInterest();
        
        System.out.println("\n=== Polymorphic Banking Operations ===");
        AbstractBankAccount[] accounts = {savings1, savings2, current1, current2};
        
        System.out.println("\nCalculating interest for all accounts:");
        for (AbstractBankAccount account : accounts) {
            System.out.println("\n--- " + account.getClass().getSimpleName() + 
                " (" + account.getAccountHolderName() + ") ---");
            account.calculateInterest();
        }
        
        System.out.println("\n=== Final Account Status ===");
        double totalBalance = 0;
        for (AbstractBankAccount account : accounts) {
            System.out.printf("%s - %s: $%.2f%n", 
                account.getClass().getSimpleName(),
                account.getAccountHolderName(),
                account.getBalance());
            totalBalance += account.getBalance();
        }
        System.out.printf("\nTotal Bank Deposits: $%.2f%n", totalBalance);
        
        System.out.println("\n=== Key Learning Points ===");
        System.out.println("1. Abstract BankAccount class provides common banking structure");
        System.out.println("2. calculateInterest() is abstract - each account type implements differently");
        System.out.println("3. deposit() is concrete - shared functionality across all account types");
        System.out.println("4. Polymorphism enables uniform handling of different account types");
    }
}