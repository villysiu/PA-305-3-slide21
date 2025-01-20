package utility;

import java.sql.*;

public class ConnectionDao {
    public static Connection connection = null;

    public static Connection getConnection() {
        final String dburl = "jdbc:mysql://localhost:3306/customerItemDB";
        final String dbuser = null;
        final String dbpassword = null;


        try{
            connection = DriverManager.getConnection(dburl, dbuser, dbpassword);
            System.out.println("Connected to Database Successfully");
        }catch (SQLException e){
            System.out.println(e);
            e.printStackTrace();

        }

        return connection;
    }
}
