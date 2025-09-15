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
        System.out.println("Bank: " + bankName + ", Total Accounts: " + totalAccounts);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount + ", New Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double calculateInterest() {
        return balance * interestRate / 100;
    }

    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber + ", Holder: " + accountHolder +
                ", Balance: $" + balance + ", Interest: $" + calculateInterest());
    }

    public static void main(String[] args) {
        BankAccount.setBankName("ABC Bank");
        BankAccount.setInterestRate(3.5);

        BankAccount acc1 = new BankAccount("ACC001", "John", 1000.0);
        BankAccount acc2 = new BankAccount("ACC002", "Jane", 2000.0);

        BankAccount.displayBankInfo();

        acc1.deposit(500);
        acc1.displayAccountInfo();

        acc2.withdraw(300);
        acc2.displayAccountInfo();

        System.out.println("Total accounts: " + BankAccount.getTotalAccounts());
        BankAccount.displayBankInfo();
    }
}