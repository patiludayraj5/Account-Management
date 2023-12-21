class Account {
    private String accountName;
    private double balance;

    public Account(String accountName, double balance) {
        this.accountName = accountName;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Error: Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }

    public void credit(double amount) {
        balance += amount;
        System.out.println("Credited $" + amount + " to " + accountName + ". New balance: $" + balance);
    }

    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Debited $" + amount + " from " + accountName + ". New balance: $" + balance);
        } else {
            System.out.println("Debit amount exceeded account balance. Transaction failed.");
        }
    }

    public double getBalance() {
        return balance;
    }
    public String getAccountName(){
        return accountName;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        // Test the Account class with debit method
        Account account1 = new Account("Uday's Account", 1000.0);
        Account account2 = new Account("Rakesh's Account", 500.0);

        System.out.println("Initial Balances:");
        displayBalance(account1);
        displayBalance(account2);

        // Perform debit transactions
        account1.debit(200.0); // Successful debit
        account2.debit(700.0); // Debit amount exceeds balance

        System.out.println("\nFinal Balances:");
        displayBalance(account1);
        displayBalance(account2);
    }

    private static void displayBalance(Account account) {
        System.out.println(account.getAccountName() + " balance: $" + account.getBalance());
    }
}
