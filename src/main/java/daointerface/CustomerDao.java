package daointerface;

import model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface CustomerDao {
    Customer getCustomerById(int id);
    Boolean addCustomer(Customer c);
    Boolean removeCustomerById(int id) throws SQLException;

}
