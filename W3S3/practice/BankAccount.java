public class BankAccount {
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++;
    }
    
    public static void setBankName(String name) {
        bankName = name;
    }
    
    public static void setInterestRate(double rate) {
        interestRate = rate;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static void displayBankInfo() {
        System.out.println("Bank: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    public double calculateInterest() {
        return balance * (interestRate / 100);
    }
    
    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Interest: $" + calculateInterest());
    }
    
    public static void main(String[] args) {
        BankAccount.setBankName("First National Bank");
        BankAccount.setInterestRate(3.5);
        
        BankAccount acc1 = new BankAccount("ACC001", "Alice Johnson", 1000.0);
        BankAccount acc2 = new BankAccount("ACC002", "Bob Smith", 1500.0);
        BankAccount acc3 = new BankAccount("ACC003", "Carol Davis", 2000.0);
        
        System.out.println("=== Bank Information (Static) ===");
        BankAccount.displayBankInfo();
        
        System.out.println("\n=== Account Operations ===");
        acc1.displayAccountInfo();
        acc1.deposit(500);
        acc1.displayAccountInfo();
        
        System.out.println("\n=== Demonstrating Static vs Instance ===");
        System.out.println("Static members (shared): Bank name and total accounts");
        System.out.println("Instance members (unique): Account details and balance");
        
        // Static method called with and without objects
        System.out.println("Total accounts (via class): " + BankAccount.getTotalAccounts());
        System.out.println("Total accounts (via object): " + acc1.getTotalAccounts());
    }
}