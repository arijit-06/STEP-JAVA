// Bank Account System - Assignment Problem 2
import java.util.*;

class BankAccount {
    private static int totalAccounts = 0;
    private static double totalDeposits = 0;
    private static final double MINIMUM_BALANCE = 0.0;
    
    private final String accountNumber;
    private final String accountType;
    private final String ownerId;
    private double balance;
    private String accountStatus;
    private List<Object> transactionHistory;
    
    public BankAccount(String ownerId) {
        this(ownerId, "Savings", 0.0);
    }
    
    public BankAccount(String ownerId, String accountType) {
        this(ownerId, accountType, 100.0);
    }
    
    public BankAccount(String ownerId, String accountType, double initialBalance) {
        this.accountNumber = "ACC" + String.format("%06d", ++totalAccounts);
        this.ownerId = ownerId;
        this.accountType = accountType;
        this.balance = Math.max(initialBalance, MINIMUM_BALANCE);
        this.accountStatus = "Active";
        this.transactionHistory = new ArrayList<>();
        totalDeposits += this.balance;
        System.out.println("Account created: " + accountNumber + " for " + ownerId);
    }
    
    public BankAccount deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalDeposits += amount;
            transactionHistory.add("Deposit: $" + amount);
            System.out.println("Deposited $" + amount + " to " + accountNumber);
        }
        return this;
    }
    
    public BankAccount withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Withdrew $" + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient funds for withdrawal");
        }
        return this;
    }
    
    public BankAccount transfer(BankAccount target, double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            target.balance += amount;
            this.transactionHistory.add("Transfer out: $" + amount + " to " + target.accountNumber);
            target.transactionHistory.add("Transfer in: $" + amount + " from " + this.accountNumber);
            System.out.println("Transferred $" + amount + " from " + this.accountNumber + " to " + target.accountNumber);
        }
        return this;
    }
    
    public static int getTotalAccounts() { return totalAccounts; }
    public static double getTotalDeposits() { return totalDeposits; }
    public static void displayBankStats() {
        System.out.println("=== Bank Statistics ===");
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Total Deposits: $" + String.format("%.2f", totalDeposits));
    }
    
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public String getOwnerId() { return ownerId; }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    
    public SavingsAccount(String ownerId) {
        super(ownerId, "Savings");
        this.interestRate = 0.02;
    }
    
    public SavingsAccount(String ownerId, double initialBalance) {
        super(ownerId, "Savings", initialBalance);
        this.interestRate = 0.025;
    }
    
    public SavingsAccount(String ownerId, double initialBalance, double rate) {
        super(ownerId, "Savings", initialBalance);
        this.interestRate = rate;
    }
    
    public void addInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest added: $" + String.format("%.2f", interest));
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    
    public CheckingAccount(String ownerId) {
        super(ownerId, "Checking");
        this.overdraftLimit = 100.0;
    }
    
    public CheckingAccount(String ownerId, double initialBalance) {
        super(ownerId, "Checking", initialBalance);
        this.overdraftLimit = 200.0;
    }
    
    public CheckingAccount(String ownerId, double initialBalance, double overdraft) {
        super(ownerId, "Checking", initialBalance);
        this.overdraftLimit = overdraft;
    }
    
    @Override
    public BankAccount withdraw(double amount) {
        if (amount > 0 && (getBalance() + overdraftLimit) >= amount) {
            if (getBalance() >= amount) {
                super.withdraw(amount);
            } else {
                System.out.println("Using overdraft protection for withdrawal");
                super.withdraw(amount);
            }
        } else {
            System.out.println("Withdrawal exceeds overdraft limit");
        }
        return this;
    }
}

class BusinessAccount extends BankAccount {
    private String businessName;
    private double monthlyFee;
    
    public BusinessAccount(String ownerId, String businessName) {
        super(ownerId, "Business", 500.0);
        this.businessName = businessName;
        this.monthlyFee = 25.0;
    }
    
    public BusinessAccount(String ownerId, String businessName, double initialBalance) {
        super(ownerId, "Business", initialBalance);
        this.businessName = businessName;
        this.monthlyFee = 15.0;
    }
    
    public void chargeMonthlyFee() {
        withdraw(monthlyFee);
        System.out.println("Monthly fee charged: $" + monthlyFee);
    }
    
    public String getBusinessName() { return businessName; }
}

class Transaction {
    private static int transactionCount = 0;
    private final String transactionId;
    private final String type;
    private final double amount;
    private final String fromAccount;
    private final String toAccount;
    
    public Transaction(String type, double amount, String fromAccount) {
        this(type, amount, fromAccount, null);
    }
    
    public Transaction(String type, double amount, String fromAccount, String toAccount) {
        this.transactionId = "TXN" + String.format("%08d", ++transactionCount);
        this.type = type;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }
    
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public static int getTransactionCount() { return transactionCount; }
}

class BankingSystem {
    private static final Map<String, Object> accountRegistry = new HashMap<>();
    private static final List<Transaction> allTransactions = new ArrayList<>();
    
    public static boolean processTransaction(Object transaction, Object account) {
        if (transaction instanceof Transaction && account instanceof BankAccount) {
            Transaction txn = (Transaction) transaction;
            BankAccount acc = (BankAccount) account;
            allTransactions.add(txn);
            
            if (txn.getType().equals("Deposit")) {
                acc.deposit(txn.getAmount());
            } else if (txn.getType().equals("Withdrawal")) {
                acc.withdraw(txn.getAmount());
            }
            return true;
        }
        return false;
    }
    
    public static void registerAccount(Object account) {
        if (account instanceof BankAccount) {
            BankAccount acc = (BankAccount) account;
            accountRegistry.put(acc.getAccountNumber(), account);
        }
    }
    
    public static void processAccountsByType(String accountType) {
        System.out.println("\n=== Processing " + accountType + " Accounts ===");
        for (Object obj : accountRegistry.values()) {
            if (obj instanceof SavingsAccount && accountType.equals("Savings")) {
                SavingsAccount savings = (SavingsAccount) obj;
                savings.addInterest();
            } else if (obj instanceof CheckingAccount && accountType.equals("Checking")) {
                CheckingAccount checking = (CheckingAccount) obj;
                System.out.println("Processing checking account: " + checking.getAccountNumber());
            } else if (obj instanceof BusinessAccount && accountType.equals("Business")) {
                BusinessAccount business = (BusinessAccount) obj;
                business.chargeMonthlyFee();
            }
        }
    }
    
    public static void displaySystemStats() {
        System.out.println("\n=== Banking System Statistics ===");
        System.out.println("Registered accounts: " + accountRegistry.size());
        System.out.println("Total transactions: " + Transaction.getTransactionCount());
        BankAccount.displayBankStats();
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        System.out.println("=== Bank Account System ===");
        
        // Create different account types with constructor chaining
        SavingsAccount savings1 = new SavingsAccount("John Doe");
        SavingsAccount savings2 = new SavingsAccount("Jane Smith", 1000.0);
        CheckingAccount checking1 = new CheckingAccount("Bob Wilson", 500.0);
        BusinessAccount business1 = new BusinessAccount("Alice Corp", "Tech Solutions", 2000.0);
        
        // Register accounts
        BankingSystem.registerAccount(savings1);
        BankingSystem.registerAccount(savings2);
        BankingSystem.registerAccount(checking1);
        BankingSystem.registerAccount(business1);
        
        // Demonstrate method chaining with 'this'
        System.out.println("\n=== Method Chaining Demo ===");
        savings1.deposit(200).deposit(150).withdraw(50);
        checking1.deposit(300).withdraw(100).transfer(savings1, 75);
        
        // Create and process transactions using instanceof
        Transaction deposit1 = new Transaction("Deposit", 500, savings2.getAccountNumber());
        Transaction withdrawal1 = new Transaction("Withdrawal", 200, checking1.getAccountNumber());
        
        BankingSystem.processTransaction(deposit1, savings2);
        BankingSystem.processTransaction(withdrawal1, checking1);
        
        // Process accounts by type using instanceof
        BankingSystem.processAccountsByType("Savings");
        BankingSystem.processAccountsByType("Business");
        
        // Display final statistics
        BankingSystem.displaySystemStats();
        
        // Test instanceof with mixed objects
        System.out.println("\n=== Account Type Testing ===");
        Object[] accounts = {savings1, checking1, business1, "Not an account"};
        
        for (Object obj : accounts) {
            if (obj instanceof SavingsAccount) {
                System.out.println("✓ Savings Account found");
            } else if (obj instanceof CheckingAccount) {
                System.out.println("✓ Checking Account found");
            } else if (obj instanceof BusinessAccount) {
                BusinessAccount biz = (BusinessAccount) obj;
                System.out.println("✓ Business Account: " + biz.getBusinessName());
            } else if (obj instanceof BankAccount) {
                System.out.println("✓ Generic Bank Account");
            } else {
                System.out.println("✗ Not a bank account: " + obj);
            }
        }
    }
}