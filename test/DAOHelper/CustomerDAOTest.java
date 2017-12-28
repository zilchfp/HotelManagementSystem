package DAOHelper;

import entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOTest {
    private String targetUserID = "999";
    private String targetUsername = "test999";
    private String targetPassword = "testpsw";
    private String targetIDNumber = "999999";
    private String targetCustomerName = "testName";
    private Connection connection = DBHGeneral.getConnection();
    private CustomerDAO customerDAO;
    private Customer customer = new Customer();

    private boolean tarDataExampleExist() throws SQLException {
        String sqlExist = "SELECT * FROM Customer WHERE userID=?";
        PreparedStatement stmExist = connection.prepareStatement(sqlExist);
        stmExist.setString(1, targetUserID);
        ResultSet resultSetExist = stmExist.executeQuery();
        return resultSetExist.next();
    }
    private void insertDataExample() throws SQLException {
        String sql = "insert into Customer values (?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, targetUserID);
        stm.setString(2, targetUsername);
        stm.setString(3, targetPassword);
        stm.setString(4, targetIDNumber);
        stm.setString(5, targetCustomerName);
        stm.execute();
    }
    private void restoreDataExample() throws SQLException {
        String sql = "UPDATE Customer SET username=?," +
                "password=?,IDNumber=?, customerName=? WHERE userID='999'";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, targetUsername);
        stm.setString(2, targetPassword);
        stm.setString(3, targetIDNumber);
        stm.setString(4, targetCustomerName);
        stm.executeUpdate();
    }

    CustomerDAOTest() throws SQLException {
    }

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        this.customerDAO = new CustomerDAO(connection);
        customer.setUserID(targetUserID);
        customer.setUsername(targetUsername);
        customer.setPassword(targetPassword);
        customer.setIDNumber(targetIDNumber);
        customer.setCustomerName(targetCustomerName);
        if (!tarDataExampleExist()) {
            insertDataExample();
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (!tarDataExampleExist()) {
            insertDataExample();
        } else {
            restoreDataExample();
        }
    }

    @Test
    void addCustomer() throws SQLException {
        customerDAO.deleteByUserID(targetUserID);
        assertEquals(false,tarDataExampleExist());

        customerDAO.addCustomer(customer);
        assertEquals(true,tarDataExampleExist());
    }

    @Test
    void deleteByUserID() throws SQLException {
        customerDAO.deleteByUserID(targetUserID);
        assertEquals(false,tarDataExampleExist());
    }

    @Test
    void queryByUsername() throws SQLException {
        ResultSet r = customerDAO.queryByUsername(targetUsername);
        r.next();
        assertEquals(targetUserID,r.getString("userID"));
    }

    @Test
    void queryByUserID() throws SQLException {
        ResultSet r = customerDAO.queryByUsername(targetUsername);
        r.next();
        assertEquals(targetUsername,r.getString("username"));
    }

    @Test
    void updateUsername() throws SQLException {
        String newUsername = "newTestName";
        customerDAO.updateUsername(newUsername, targetUserID);
        ResultSet r = customerDAO.queryByUserID(targetUserID);
        r.next();
        assertEquals(newUsername,r.getString("username"));
    }

    @Test
    void updatePassword() throws SQLException {
        String newPassword = "newTestPassword";
        customerDAO.updatePassword(newPassword, targetUserID);
        ResultSet r = customerDAO.queryByUserID(targetUserID);
        r.next();
        assertEquals(newPassword,r.getString("password"));
    }

    @Test
    void updateIDNumber() throws SQLException {
        String newIDNumber = "9999999";
        customerDAO.updateIDNumber(newIDNumber, targetUserID);
        ResultSet r = customerDAO.queryByUserID(targetUserID);
        r.next();
        assertEquals(newIDNumber,r.getString("IDNumber"));
    }


    @Test
    void queryCustomersLiving() {
    }

}