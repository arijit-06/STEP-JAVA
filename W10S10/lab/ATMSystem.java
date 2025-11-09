class User {
    private String name;
    
    public User(String name) {
        this.name = name;
    }
    
    public void withdrawMoney(ATMSystem atm, double amount) {
        System.out.println(name + " withdraws ₹" + amount);
        atm.dispenseCash(amount);
    }
    
    public void checkBalance(ATMSystem atm) {
        System.out.println(name + " checks balance");
        atm.showBalance();
    }
    
    public void depositMoney(ATMSystem atm, double amount) {
        System.out.println(name + " deposits ₹" + amount);
        atm.acceptDeposit(amount);
    }
}

class ATMSystem {
    private double balance = 10000;
    
    public void dispenseCash(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Cash dispensed: ₹" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
    
    public void showBalance() {
        System.out.println("Current balance: ₹" + balance);
    }
    
    public void acceptDeposit(double amount) {
        balance += amount;
        System.out.println("Deposit accepted: ₹" + amount);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        User user = new User("Alice");
        ATMSystem atm = new ATMSystem();
        
        user.checkBalance(atm);
        user.withdrawMoney(atm, 2000);
        user.depositMoney(atm, 1000);
        user.checkBalance(atm);
    }
}