package daointerface.impl;

import daointerface.ItemDao;
import model.Customer;
import model.Item;
import utility.ConnectionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    Connection connection = null;
    PreparedStatement ps =null;
    ResultSet rs = null;

    @Override
    public List<Item> getAllItems() throws SQLException {
        connection = ConnectionDao.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM item");

        List<Item> itemsList = new ArrayList<>();

        while(rs.next()){
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getDouble("price"));
            itemsList.add(item);

        }
        return itemsList;
    }

    @Override
    public Boolean addItem(Item i) {
        try{
            connection = ConnectionDao.getConnection();
            ps = connection.prepareStatement("INSERT INTO item (name, price) Values (?,?)");
            ps.setString(1, i.getName());
            ps.setDouble(2, i.getPrice());

            ps.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean removeItemById(int id) {
        try{
            connection = ConnectionDao.getConnection();
            ps = connection.prepareStatement("DELETE FROM item WHERE id=?");
            ps.setInt(1, id);

            if(ps.executeUpdate() == 1)
                return true;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
