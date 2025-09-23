class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    
    private static int totalAccounts = 0;
    private static String bankName;
    
    public PersonalAccount(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialDeposit;
        this.totalIncome = initialDeposit;
        this.totalExpenses = 0;
        totalAccounts++;
    }
    
    public static void setBankName(String name) {
        bankName = name;
    }
    
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    
    public static String generateAccountNumber() {
        return "PFA" + String.format("%04d", totalAccounts + 1);
    }
    
    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println("Income added: $" + amount + " - " + description);
        } else {
            System.out.println("Invalid income amount");
        }
    }
    
    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println("Expense added: $" + amount + " - " + description);
        } else if (amount > currentBalance) {
            System.out.println("Insufficient funds for expense: " + description);
        } else {
            System.out.println("Invalid expense amount");
        }
    }
    
    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }
    
    public void displayAccountSummary() {
        System.out.println("=== Account Summary ===");
        System.out.println("Bank: " + bankName);
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Current Balance: $" + currentBalance);
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Net Savings: $" + calculateSavings());
        System.out.println("Savings Rate: " + (calculateSavings() / totalIncome * 100) + "%");
        System.out.println("========================");
    }
    
    public String getAccountHolderName() { return accountHolderName; }
    public String getAccountNumber() { return accountNumber; }
    public double getCurrentBalance() { return currentBalance; }
    public double getTotalIncome() { return totalIncome; }
    public double getTotalExpenses() { return totalExpenses; }
}

public class PersonalFinanceManager {
    public static void main(String[] args) {
        PersonalAccount.setBankName("Personal Finance Bank");
        
        PersonalAccount account1 = new PersonalAccount("John Doe", 5000.0);
        PersonalAccount account2 = new PersonalAccount("Jane Smith", 3000.0);
        PersonalAccount account3 = new PersonalAccount("Bob Johnson", 7000.0);
        
        System.out.println("=== Personal Finance Management System ===");
        System.out.println("Total Accounts: " + PersonalAccount.getTotalAccounts());
        
        System.out.println("\n=== Account 1 Transactions ===");
        account1.addIncome(2500.0, "Salary");
        account1.addIncome(500.0, "Freelance Work");
        account1.addExpense(800.0, "Rent");
        account1.addExpense(300.0, "Groceries");
        account1.addExpense(150.0, "Utilities");
        account1.displayAccountSummary();
        
        System.out.println("\n=== Account 2 Transactions ===");
        account2.addIncome(3200.0, "Salary");
        account2.addIncome(200.0, "Investment Returns");
        account2.addExpense(1000.0, "Rent");
        account2.addExpense(400.0, "Food");
        account2.addExpense(200.0, "Transportation");
        account2.addExpense(100.0, "Entertainment");
        account2.displayAccountSummary();
        
        System.out.println("\n=== Account 3 Transactions ===");
        account3.addIncome(4000.0, "Business Income");
        account3.addIncome(800.0, "Consulting");
        account3.addExpense(1200.0, "Office Rent");
        account3.addExpense(500.0, "Business Expenses");
        account3.addExpense(300.0, "Personal Expenses");
        account3.displayAccountSummary();
        
        System.out.println("\n=== Bank-wide Statistics ===");
        double totalBankBalance = account1.getCurrentBalance() + account2.getCurrentBalance() + account3.getCurrentBalance();
        double totalBankIncome = account1.getTotalIncome() + account2.getTotalIncome() + account3.getTotalIncome();
        double totalBankExpenses = account1.getTotalExpenses() + account2.getTotalExpenses() + account3.getTotalExpenses();
        
        System.out.println("Total Bank Balance: $" + totalBankBalance);
        System.out.println("Total Bank Income: $" + totalBankIncome);
        System.out.println("Total Bank Expenses: $" + totalBankExpenses);
        System.out.println("Overall Savings Rate: " + ((totalBankIncome - totalBankExpenses) / totalBankIncome * 100) + "%");
        
        System.out.println("\n=== Static vs Instance Variables Demonstration ===");
        System.out.println("Static Variables (Shared):");
        System.out.println("  - Bank Name: Same for all accounts");
        System.out.println("  - Total Accounts: " + PersonalAccount.getTotalAccounts());
        
        System.out.println("Instance Variables (Unique per account):");
        System.out.println("  - " + account1.getAccountHolderName() + ": Balance $" + account1.getCurrentBalance());
        System.out.println("  - " + account2.getAccountHolderName() + ": Balance $" + account2.getCurrentBalance());
        System.out.println("  - " + account3.getAccountHolderName() + ": Balance $" + account3.getCurrentBalance());
        
        System.out.println("\n=== Financial Health Analysis ===");
        PersonalAccount[] accounts = {account1, account2, account3};
        for (PersonalAccount acc : accounts) {
            double savingsRate = acc.calculateSavings() / acc.getTotalIncome() * 100;
            String healthStatus;
            if (savingsRate >= 20) healthStatus = "Excellent";
            else if (savingsRate >= 10) healthStatus = "Good";
            else if (savingsRate >= 0) healthStatus = "Fair";
            else healthStatus = "Poor";
            
            System.out.println(acc.getAccountHolderName() + ": " + healthStatus + " (" + savingsRate + "% savings rate)");
        }
    }
}