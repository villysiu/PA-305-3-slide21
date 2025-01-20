package com.villysiu.pa3053slide21;

import model.Customer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.CustomerService;
import service.ItemService;
import utility.ConnectionDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws SQLException {


        CustomerService customerService = new CustomerService();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<3; i++) {
            customerService.addCustomer(scanner);
        }

        customerService.getCustomerById(scanner);
        customerService.removeCustomerById(scanner);


        ItemService itemService = new ItemService();

        for(int i=0;i<3; i++){
            itemService.addItem(scanner);
        }
        itemService.getAllItems();
        itemService.removeItemById(scanner);

        scanner.close();





    }

}
