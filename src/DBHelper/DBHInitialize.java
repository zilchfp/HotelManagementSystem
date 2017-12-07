package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHInitialize {
    public static Connection getConnection () throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/HotelManagementSystem?" +
                "user=javaweb&password=password");
        return c;
    }

    public void close(Connection c) throws SQLException {
        c.close();
    }
}
