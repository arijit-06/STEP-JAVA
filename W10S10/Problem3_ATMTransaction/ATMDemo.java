public class ATMDemo {
    public static void main(String[] args) {
        // Step 1 - Create BankAccount object with sample data
        BankAccount account = new BankAccount("ACC123456", 10000.0, 1234);

        // Step 2 - Create ATM object linked to BankAccount
        ATM atm = new ATM(account);

        // Step 3 - Create Customer object associated with ATM
        Customer customer = new Customer("John Doe", atm);

        // Step 4 - Call performWithdrawal() with correct PIN
        customer.performWithdrawal(1234, 2000.0);

        // Step 5 - Call performWithdrawal() with incorrect PIN
        customer.performWithdrawal(9999, 1000.0);
    }
}