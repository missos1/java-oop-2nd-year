package Banking;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<>();

    /**
     * Reads customer list from an inputStream with format:
     * [Name] [Id]
     * [AccountNumber] [AccountType] [balance] nth lines
     * and continue with the next customers.
     * 
     * @param inputStream input list
     */
    public void readCustomerList(InputStream inputStream) {
        Scanner sc = new Scanner(inputStream);

        Customer currentCustomer = null;

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if(line.isEmpty()) {
                continue;
            }

            String[] parts = line.split("\\s+");

            try {

                long accountNumber = Long.parseLong(parts[0]);
                String accountType = parts[1];
                double balance = Double.parseDouble(parts[2]);

                Account acc;
                if (Account.CHECKING.equals(accountType)) {
                    acc = new CheckingAccount(accountNumber, balance);
                } else {
                    acc = new SavingsAccount(accountNumber, balance);
                }

                if (currentCustomer != null) {
                    currentCustomer.addAccount(acc);
                }
            } catch (NumberFormatException e) {
                StringBuilder nameBuilder = new StringBuilder();

                for (int i = 0; i < parts.length - 1; i++) {
                    nameBuilder.append(parts[i]).append(" ");
                }

                String name = nameBuilder.toString().trim();
                long idNumber = Long.parseLong(parts[parts.length - 1]);

                currentCustomer = new Customer(idNumber, name);
                customerList.add(currentCustomer);
            }
        }
        sc.close();
    }

    /**
     * Sorts and return customers info in ascending id order.
     * 
     * @return customers info in ascending id order
     */
    public String getCustomersInfoByIdOrder() {
        customerList.sort(Comparator.comparingLong(Customer::getIdNumber));
        String customersInfo = "";
        for (Customer c : customerList) {
            customersInfo += c.getCustomerInfo() + "\n";
        }

        return customersInfo;
    }

    /**
     * Sorts and return customers info in alphabetical order.
     * 
     * @return customers info in alphabetical order
     */
    public String getCustomersInfoByNameOrder() {
        customerList.sort(Comparator.comparing(Customer::getFullName));
        String customersInfo = "";
        for (Customer c : customerList) {
            customersInfo += c.getCustomerInfo() + "\n";
        }

        return customersInfo;
    }
}