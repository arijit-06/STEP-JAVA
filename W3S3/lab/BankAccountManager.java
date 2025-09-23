class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    
    public BankAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }
    
    public static String generateAccountNumber() {
        return "ACC" + String.format("%03d", totalAccounts + 1);
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    public double checkBalance() {
        return balance;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: $" + balance);
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
}

public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[5];
        
        accounts[0] = new BankAccount("Alice Johnson", 1000.0);
        accounts[1] = new BankAccount("Bob Smith", 1500.0);
        accounts[2] = new BankAccount("Carol Davis", 2000.0);
        accounts[3] = new BankAccount("David Wilson", 750.0);
        accounts[4] = new BankAccount("Eva Brown", 1200.0);
        
        System.out.println("=== Initial Account Information ===");
        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
        }
        
        System.out.println("\n=== Performing Transactions ===");
        accounts[0].deposit(500);
        accounts[0].displayAccountInfo();
        
        accounts[1].withdraw(200);
        accounts[1].displayAccountInfo();
        
        accounts[2].withdraw(2500); // Should fail
        accounts[2].displayAccountInfo();
        
        System.out.println("\n=== Static vs Instance Variables ===");
        System.out.println("Total accounts created (static): " + BankAccount.getTotalAccounts());
        System.out.println("Each account has unique number and balance (instance variables)");
        
        System.out.println("\n=== Account Numbers (Generated using static counter) ===");
        for (BankAccount acc : accounts) {
            System.out.println(acc.getAccountHolderName() + " - " + acc.getAccountNumber());
        }
        
        System.out.println("\n=== Balance Summary ===");
        double totalBalance = 0;
        for (BankAccount acc : accounts) {
            totalBalance += acc.checkBalance();
        }
        System.out.println("Total balance across all accounts: $" + totalBalance);
    }
}