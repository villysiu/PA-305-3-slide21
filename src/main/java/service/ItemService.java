package service;

import daointerface.ItemDao;
import daointerface.impl.ItemDaoImpl;
import model.Customer;
import model.Item;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ItemService {
    private final ItemDao itemDao;
    public ItemService() {
        this.itemDao = new ItemDaoImpl();
    }


    public void getAllItems() throws SQLException {
        List<Item> items = itemDao.getAllItems();
        for(Item item : items) {
            System.out.println(item.toString());
        }
    }

    public void addItem(Scanner scanner){

        Item item = new Item();
        System.out.println("Please enter item name: ");
        String name = scanner.nextLine();
        item.setName(name);
        System.out.println("Please enter item price: ");
        double price = Double.parseDouble(scanner.nextLine());
        item.setPrice(price);

        if(itemDao.addItem(item))
            System.out.println("Item added successfully!");
        else
            System.out.println("Item not added successfully!");
    }
    public void removeItemById(Scanner scanner) throws SQLException {

        System.out.println("Please enter the item id to remove:");
        int id = Integer.parseInt(scanner.nextLine());


        if(itemDao.removeItemById(id))
            System.out.println("Item deleted successfully!");
        else
            System.out.println("Item not deleted successfully!");

    }

}
