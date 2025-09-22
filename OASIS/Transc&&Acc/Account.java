import java.util.ArrayList;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionArray = new ArrayList<>();
    
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }

        balance += amount;
    }

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

    public void addTransaction(double amount, String operation) {
        // if (Transaction.DEPOSIT.equals(operation)) {
        //     deposit(amount);
        //     transactionArray.add(new Transaction(operation, amount, balance));
        // } else if (Transaction.WITHDRAW.equals(operation)){
        //     withdraw(amount);
        //     transactionArray.add(new Transaction(operation, amount, balance));
        // } else {
        //     System.out.println("Yeu cau khong hop le!");
        // }

        System.out.print(Transaction.DEPOSIT.equals(operation) + "\n");
        System.out.print(Transaction.WITHDRAW.equals(operation));

    }

    public void printTransaction() {
        for (int i = 0; i < transactionArray.size(); i++) {
            double balanceUnrounded =  transactionArray.get(i).getBalance();
            double amountUnrounded =  transactionArray.get(i).getAmount();
            double balanceRounded = Math.round(balanceUnrounded * 100.0) / 100.0;
            double amountRounded = Math.round(amountUnrounded * 100.0) / 100.0;

            String operationCheck = transactionArray.get(i).getOperation();
            String operationFinal = (operationCheck.equals(Transaction.DEPOSIT)) ? " Nap tien " : " Rut tien ";
            System.out.println("Giao dich " + (i + 1) + ":" + operationFinal + "$" + amountRounded
            + ". So du luc nay: $" + balanceRounded);
        }
    }

    public static void main(String[] args) {
        Account acc= new Account();  
        acc.addTransaction(2000.255,"deposit");  
        acc.addTransaction(1000,"withdraw");  
        acc.printTransaction();
    }
}