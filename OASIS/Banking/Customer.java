package Banking;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private List<Account> accountList = new ArrayList<>();
    private long idNumber;
    private String fullName;

    public Customer() {
    }

     public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo(){
        return "Số CMND: " + idNumber
         + ". Họ tên: " + fullName + ".";
    }

    public void addAccount(Account account){
        accountList.add(account);
    }

    public void removeAccount(Account account){
        accountList.remove(account);
    }

    public long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}