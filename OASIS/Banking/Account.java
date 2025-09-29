package Banking;

import java.util.List;
import java.util.ArrayList;

public abstract class Account {
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();
    public static final String CHECKING = "CHECKING"; 
    public static final String SAVINGS = "SAVINGS"; 

    
    public Account() {

    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    public void doDeposting(double amount) throws InvalidFundingAmountException {
        if (amount < 0.0) {
            throw new InvalidFundingAmountException(amount);
        }
        balance += amount;
    }

    public void doWithdrawing(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount)
        }

        if (amount < 0.0)
        balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public String getTransactionHistory() {
        String transactionHisString = "Lịch sử giao dịch của tài khoản 1234567890:\n";
        for (Transaction t : transactionList) {
            transactionHisString += t.getTransactionSummary() + "\n";
        }

        return transactionHisString;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Account) {
            Account account = (Account) obj;
            return this.accountNumber == account.accountNumber;
        }

        return false;
    }
}