package daointerface;

import model.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    List<Item> getAllItems() throws SQLException;
    Boolean addItem(Item i);
    Boolean removeItemById(int id);

}
