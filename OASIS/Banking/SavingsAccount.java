package Banking;

public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        try {
            doWithdrawing(amount);
        } catch (BankException exception) {
            
        }
    }

    public void deposit(double amount) {
        
    }
}
