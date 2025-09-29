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

    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    private String getTransactionTypeString(int type) {
        switch (type) {
            case TYPE_DEPOSIT_CHECKING:
                return "Nạp tiền vãng lai";
            case TYPE_WITHDRAW_CHECKING:
                return "Rút tiền vãng lai";
            case TYPE_DEPOSIT_SAVINGS:
                return "Nạp tiền tiết kiệm";
        }
        return "Rút tiền tiết kiệm";
    }

    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(type)
        + ". Số dư ban đầu: $" 
        + String.format("%.2f", initialBalance) + ". Số tiền: $"
        + String.format("%.2f", amount) + ". Số dư cuối: $" 
        + String.format("%.2f", finalBalance) + ".";
    }
}
