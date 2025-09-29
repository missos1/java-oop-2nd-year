package Banking;

public class InvalidFundingAmountException extends BankException {

    /**
     * Constructor.
     * 
     * @param amount money in dollars
     */ 
    public InvalidFundingAmountException(double amount) {
        super(String.format("Số tiền không hợp lệ: $%.2f", amount));
    }
}
