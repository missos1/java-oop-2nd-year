package Banking;

public class SavingsAccount extends Account {

    /**
     * Constructor 1.
     * 
     * @param accountNumber the new account number
     * @param balance the new account balance
     */
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * Withdraw money from the account.
     * 
     * </p>If the withdraw amount is greater than 1000.0,
     * an {@code InvalidFundingAmountException} is thrown.
     * If the balance is less than 5000.0, an
     * {@code InsufficientFundsException} is thrown.</p>
     * 
     * @param amount withdrawed amount
     */
    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 1000.0) {
                throw new InvalidFundingAmountException(1000.0);
            }

            if (balance < 5000.0) {
                throw new InsufficientFundsException(5000.0);
            }

            double initialBalance = balance;
            doWithdrawing(amount);
            addTransaction(new Transaction(Transaction.TYPE_WITHDRAW_SAVINGS, 
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
            addTransaction(new Transaction(Transaction.TYPE_DEPOSIT_SAVINGS, 
            amount, initialBalance, balance));
        } catch (BankException exception) {
            System.out.println(exception);
        }
    }
}
