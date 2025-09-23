import java.util.ArrayList;

public class Account {
    private double balance;
    private final ArrayList<Transaction> transitionList = new ArrayList<>();
    
    /**
     * Deposit into balance method.
     * @param amount amount deposited
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        balance += amount;
    }

    /**
     * Withdraw into balance method.
     * @param amount amount withdrawed
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }
        balance -= amount;
    }

    /**
     * Adding transaction to the transaction array.
     * @param amount the amount of the transaction
     * @param operation type of transaction, either deposit or withdrawal 
     */
    public void addTransaction(double amount, String operation) {
        if (null == operation) {
            System.out.println("Yeu cau khong hop le!");
        } else {
            switch (operation) {
            case Transaction.DEPOSIT:
                deposit(amount);
                transitionList.add(new Transaction(operation, amount, balance));
                break;
            case Transaction.WITHDRAW:
                withdraw(amount);
                transitionList.add(new Transaction(operation, amount, balance));
                break;
            default:
                System.out.println("Yeu cau khong hop le!");
                break;
            }
        }
        // System.out.print(Transaction.DEPOSIT.equals(operation) + "\n");
        // System.out.print(Transaction.WITHDRAW.equals(operation));
    }


    /**
     * Prints the transaction array.
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); i++) {
            double balanceUnrounded =  transitionList.get(i).getBalance();
            double amountUnrounded =  transitionList.get(i).getAmount();
            double balanceRounded = Math.round(balanceUnrounded * 100.0) / 100.0;
            double amountRounded = Math.round(amountUnrounded * 100.0) / 100.0;
            String operationCheck = transitionList.get(i).getOperation();
            String operationFinal = (operationCheck.equals(Transaction.DEPOSIT)) ? " Nap tien " : " Rut tien ";

            System.out.printf(
                "Giao dich %d:%s$%.2f. So du luc nay: $%.2f.%n", 
                (i + 1), 
                operationFinal, 
                amountRounded, 
                balanceRounded
            );
        }
    }

    // /**
    //  * Main function.
    //  * @param args takes in cmd
    //  */
    // public static void main(String[] args) {
    //     Account account= new Account();  
    //     account.addTransaction(2000.255,"deposit");  
    //     account.addTransaction(5000.6585,"deposit");  
    //     account.addTransaction(1000.215,"deposit");  
    //     account.addTransaction(2000.255,"deposit");  
    //     account.addTransaction(2000.215,"deposit");  
    //     account.addTransaction(8000,"withdraw");  
    //     account.printTransaction();
    // }
}