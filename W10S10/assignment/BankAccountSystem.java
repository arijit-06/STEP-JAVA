import java.util.*;

class Account {
    private String accountNumber;
    private double balance;
    private String accountType;
    
    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". Balance: ₹" + balance);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + ". Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
}

class Customer {
    private String name;
    private String customerId;
    private List<Account> accounts;
    
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }
    
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added for " + name);
    }
    
    public void showAccounts() {
        System.out.println("Accounts for " + name + ":");
        for (Account account : accounts) {
            System.out.println("- " + account.getAccountNumber());
        }
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;
    
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added to " + bankName);
    }
    
    public void showCustomers() {
        System.out.println("Customers of " + bankName + ": " + customers.size());
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank");
        Customer customer = new Customer("John Doe", "CUST001");
        Account account = new Account("ACC123", 5000, "Savings");
        
        customer.addAccount(account);
        bank.addCustomer(customer);
        
        account.deposit(2000);
        account.withdraw(1500);
        customer.showAccounts();
        bank.showCustomers();
    }
}