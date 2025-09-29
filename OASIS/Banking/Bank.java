package Banking;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    public void readCustomerList(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            
        }
    }

    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        String customersInfo = "";
        for (Customer c : customerList) {
            customersInfo += c.getCustomerInfo() + "\n";
        }

        return customersInfo;
    }

    public String getCustomersInfoByNameOrder() {
        customerList.sort(Comparator.comparing(Customer::getFullName));
        String customersInfo = "";
        for (Customer c : customerList) {
            customersInfo += c.getCustomerInfo() + "\n";
        }

        return customersInfo;
    }
}