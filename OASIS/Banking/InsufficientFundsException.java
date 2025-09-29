package Banking;

public class InsufficientFundsException extends BankException{
    
    /**
     * Constructor.
     * 
     * @param amount money in dollars
     */ 
    public InsufficientFundsException(double amount) {
        super(String.format("Số dư tài khoản không đủ $%.2f để thực hiện giao dịch", amount));
    }
}
