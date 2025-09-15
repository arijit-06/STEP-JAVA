public class BankAccountSystem {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private static int totalAccounts = 0;
    private static int accountCounter = 0;

    public BankAccountSystem(String accountHolderName, double initialDeposit) {
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient funds");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static String generateAccountNumber() {
        accountCounter++;
        return String.format("ACC%03d", accountCounter);
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: $" + balance);
    }

    public static void main(String[] args) {
        BankAccountSystem[] accounts = new BankAccountSystem[3];
        accounts[0] = new BankAccountSystem("John Doe", 1000);
        accounts[1] = new BankAccountSystem("Jane Smith", 2000);
        accounts[2] = new BankAccountSystem("Bob Johnson", 1500);

        for (BankAccountSystem acc : accounts) {
            acc.displayAccountInfo();
            acc.deposit(500);
            acc.withdraw(200);
            System.out.println("Balance: $" + acc.checkBalance());
            System.out.println();
        }

        System.out.println("Total Accounts: " + BankAccountSystem.getTotalAccounts());
    }
}