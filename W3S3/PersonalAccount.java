public class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    private static int totalAccounts = 0;
    private static String bankName = "Personal Bank";
    private static int accountCounter = 0;

    public PersonalAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialBalance;
        this.totalIncome = initialBalance;
        this.totalExpenses = 0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        if (amount > 0) {
            currentBalance += amount;
            totalIncome += amount;
            System.out.println("Income added: $" + amount + " - " + description);
        }
    }

    public void addExpense(double amount, String description) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println("Expense added: $" + amount + " - " + description);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("=== Account Summary ===");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + currentBalance);
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Savings: $" + calculateSavings());
        System.out.println("Bank: " + bankName);
    }

    public static void setBankName(String name) {
        bankName = name;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        accountCounter++;
        return "PA" + String.format("%06d", accountCounter);
    }

    public static void main(String[] args) {
        setBankName("MyPersonal Finance Bank");

        PersonalAccount[] accounts = {
            new PersonalAccount("John Doe", 5000),
            new PersonalAccount("Jane Smith", 3000),
            new PersonalAccount("Bob Johnson", 7000)
        };

        accounts[0].addIncome(2000, "Salary");
        accounts[0].addExpense(500, "Groceries");
        accounts[0].addExpense(300, "Utilities");

        accounts[1].addIncome(1500, "Freelance");
        accounts[1].addExpense(200, "Gas");

        accounts[2].addIncome(3000, "Bonus");
        accounts[2].addExpense(1000, "Rent");

        System.out.println("=== All Account Summaries ===");
        for (PersonalAccount account : accounts) {
            account.displayAccountSummary();
            System.out.println();
        }

        System.out.println("Total Accounts Created: " + getTotalAccounts());
        System.out.println("Bank Name (shared): " + bankName);
    }
}