package service;

import daointerface.CustomerDao;
import daointerface.impl.CustomerDaoImpl;
import model.Customer;

import java.sql.SQLException;
import java.util.Scanner;


public class CustomerService {


    private final CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDaoImpl();
    }

    public void getCustomerById(Scanner scanner) {

        System.out.println("Please enter the customer id to search:");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerDao.getCustomerById(id);
        System.out.println(customer.toString());
    }
    public void addCustomer(Scanner scanner) {

        Customer customer = new Customer();
        System.out.println("Please enter your customer email: ");
        String email = scanner.nextLine();
        customer.setEmail(email);
        System.out.println("Please enter your customer first name: ");
        String firstName = scanner.nextLine();
        customer.setFname(firstName);
        System.out.println("Please enter your customer last name: ");
        String lastName = scanner.nextLine();
        customer.setLname(lastName);

        if(customerDao.addCustomer(customer))
            System.out.println("Customer added successfully");
        else
            System.out.println("Customer add failed");


    }
    public void removeCustomerById(Scanner scanner) throws SQLException {

        System.out.println("Please enter the customer id to remove:");
        int id = Integer.parseInt(scanner.nextLine());

        if(customerDao.removeCustomerById(id))
            System.out.println("Customer removed successfully");
        else
            System.out.println("Customer remove failed");

    }


}
