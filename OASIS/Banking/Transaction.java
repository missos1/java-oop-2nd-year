package Banking;

public class Transaction {
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;

    /**
     * Constructor.
     * 
     * @param type transaction type
     * @param amount transaction amount
     * @param initialBalance balance before transaction
     * @param finalBalance balance after transaction
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * Returns the transaction type in String format.
     * 
     * @param type transaction type
     * @return transaction type in String format
     */
    private String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
            default:
                break;
        }
        return "Rút tiền tiết kiệm";
    }

    /**
     * Returns the transaction summary in String format.
     * 
     * @return transaction summary in String format
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(type)
        + ". Số dư ban đầu: $" 
        + String.format("%.2f", initialBalance) + ". Số tiền: $"
        + String.format("%.2f", amount) + ". Số dư cuối: $" 
        + String.format("%.2f", finalBalance) + ".";
    }
}
