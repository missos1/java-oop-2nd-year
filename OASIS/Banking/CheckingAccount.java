package Banking;

public class CheckingAccount extends Account {
    /**
     * Constructor.
     * 
     * @param accountNumber the new account number
     * @param balance the new account balance
     */
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw money from the account.
     * 
     * @param amount withdrawed amount
     */
    @Override
    public void withdraw(double amount) {
        try {
            double initialBalance = balance;
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_CHECKING, 
            amount, initialBalance, balance));
        } catch (BankException exception) {
            System.out.println(exception);
        }
    }

    /**
     * Deposit money into the account.
     * 
     * @param amount deposited amount
     */
    @Override
    public void deposit(double amount) {
        try {
            double initialBalance = balance;
            doDepositing(amount);
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_CHECKING, 
            amount, initialBalance, balance));
        } catch (BankException exception) {
            System.out.println(exception);
        }
    }
}

