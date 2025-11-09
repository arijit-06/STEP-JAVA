public class ATMDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC123", 10000, 1234);
        ATM atm = new ATM(account);
        Customer customer = new Customer("John", atm);
        
        customer.performWithdrawal(1234, 2000);
        customer.performWithdrawal(5678, 1000);
    }
}