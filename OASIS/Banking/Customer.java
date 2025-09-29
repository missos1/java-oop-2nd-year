package Banking;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Account> accountList = new ArrayList<>();
    private long idNumber;
    private String fullName;

    /**
     * Constructor 1.
     */
    public Customer() {
    }

    /**
     * Constructor 2.
     * 
     * @param idNumber customer's id number
     * @param fullName customer's full name
     */
    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    /**
     * Returns customer info in string format. Example:
     * Số CMND: 123456787. Họ tên: Hoàng Văn C.
     * 
     * @return info in string format
     */
    public String getCustomerInfo() {
        return "Số CMND: " + idNumber
         + ". Họ tên: " + fullName + ".";
    }

    /**
     * Adds an account to the customer's account list. 
     * 
     * @param account the new account needed to be added
     */
    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Removes an account from the customer's account list.
     * 
     * @param account the desired account to remove;
     */
    public void removeAccount(Account account) {
        accountList.remove(account);
    }

    /**
     * Returns the customer's ID number.
     *
     * @return the customer's ID number
     */
    public long getIdNumber() {
        return idNumber;
    }

    /**
     * Sets the customer's ID number.
     *
     * @param idNumber the customer's ID number to set
     */
    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * Returns the customer's full name.
     *
     * @return the customer's full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the customer's full name.
     *
     * @param fullName the customer's full name to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Returns the list of accounts associated with the customer.
     *
     * @return the list of the customer's accounts
     */
    public List<Account> getAccountList() {
        return accountList;
    }
}