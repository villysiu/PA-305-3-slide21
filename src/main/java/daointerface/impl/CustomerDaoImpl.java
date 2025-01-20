package daointerface.impl;

import daointerface.CustomerDao;
import model.Customer;
import org.springframework.stereotype.Repository;
import utility.ConnectionDao;

import java.sql.*;

public class CustomerDaoImpl implements CustomerDao {
    Connection connection = null;
    PreparedStatement ps =null;
    ResultSet rs = null;

    @Override
    public Customer getCustomerById(int id) {
        try{
            connection = ConnectionDao.getConnection();
            ps = connection.prepareStatement("SELECT * FROM customer WHERE id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            Customer customer = new Customer();
            while(rs.next()){
                customer.setId(id);
                customer.setEmail(rs.getString("email"));
                customer.setFname(rs.getString("fname"));
                customer.setLname(rs.getString("lname"));
            }
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean addCustomer(Customer c) {
        try{
            connection = ConnectionDao.getConnection();
            ps = connection.prepareStatement("INSERT INTO customer (fName, lName, email) Values (?,?,?)");
            ps.setString(1, c.getFname());
            ps.setString(2, c.getLname());
            ps.setString(3, c.getEmail());

            ps.executeUpdate();
            return true;

        }catch (SQLException e){
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean removeCustomerById(int id) {

        try{
            connection = ConnectionDao.getConnection();
            ps = connection.prepareStatement("DELETE FROM customer WHERE id=?");
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
