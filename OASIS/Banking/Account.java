package Banking;

import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();
    public static final String CHECKING = "CHECKING"; 
    public static final String SAVINGS = "SAVINGS"; 

    /**
     * Constructor 1.
     */
    public Account() {
    }

    /**
     * Constructor 2.
     * 
     * @param accountNumber the new account number
     * @param balance the new account balance
     */
    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * Abstract withdraw class for inheritance. 
     * 
     * @param amount
     */
    public abstract void withdraw(double amount);

    /**
     * Abstract deposit class for inheritance. 
     * 
     * @param amount
     */
    public abstract void deposit(double amount);

    /**
     * Depositing money into the account's balance.
     * 
     * @param amount deposited amount
     * @throws InvalidFundingAmountException if number is negative throws invalid exception
     */
    public void doDepositing(double amount) throws InvalidFundingAmountException {
        if (amount < 0.0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance += amount;
    }

    /**
     * Withdrawing money from the balance.
     * 
     * @param amount withdrew amount
     * @throws InvalidFundingAmountException if number is negative 
     * throws invalid exception
     * @throws InsufficientFundsException if the balance isn't sufficed
     * throws insufficient exception
     */
    public void doWithdrawing(double amount) throws InvalidFundingAmountException, InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount);
        }

        if (amount < 0.0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance -= amount;
    }

    /**
     * Add transaction to the list.
     * 
     * @param transaction the transaction needed to be added
     */
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * Returns the transaction history in String format.
     * 
     * @return transaction history in String format
     */
    public String getTransactionHistory() {
        String transactionHisString = "Lịch sử giao dịch của tài khoản" + accountNumber + ":\n";
        for (Transaction t : transactionList) {
            transactionHisString += t.getTransactionSummary() + "\n";
        }

        return transactionHisString;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Account) {
            Account account = (Account) obj;
            return this.accountNumber == account.accountNumber;
        }

        return false;
    }
}