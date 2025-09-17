public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    
    public BankAccount() {
        this.balance = 0;
    }
    
    public BankAccount(String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = (int)(Math.random() * 100000);
    }
    
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountNumber = (int)(Math.random() * 100000);
    }
    
    public void deposit(double amount) {
        balance += amount;
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }
    
    public void displayAccount() {
        System.out.println("Account Holder: " + accountHolder + ", Account Number: " + 
                          accountNumber + ", Balance: " + balance);
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount();
        BankAccount acc2 = new BankAccount("John");
        BankAccount acc3 = new BankAccount("Alice", 5000);
        
        acc2.deposit(1000);
        acc3.withdraw(500);
        
        acc1.displayAccount();
        acc2.displayAccount();
        acc3.displayAccount();
    }
}