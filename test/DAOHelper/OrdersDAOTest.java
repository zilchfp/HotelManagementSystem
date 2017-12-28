package DAOHelper;

import entity.Orders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrdersDAOTest {
    //“tar” for “Target”
    private Orders orders = new Orders();
    private String targetOderID = "999";
    private String targetRoomID = "1";
    private String targetCustomerID = "999";
    private String targetCustomerName = "test";
    private String targetDateBegin = "2017-12-12";
    private String targetDateEnd = "2017-12-21";
    private String targetStatus = "test";
    private OrdersDAO ordersDAO;
    private Connection connection = DBHGeneral.getConnection();

    OrdersDAOTest() throws SQLException {
    }


    private boolean tarDataExampleExist() throws SQLException {
        String sqlExist = "SELECT * FROM Orders WHERE OrderID=?";
        PreparedStatement stmExist = connection.prepareStatement(sqlExist);
        stmExist.setString(1, targetOderID);
        ResultSet resultSetExist = stmExist.executeQuery();
        return resultSetExist.next();
    }
    private void insertDataExample() throws SQLException {
        String sql = "insert into Orders values (?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, targetOderID);
        stm.setString(2, targetRoomID);
        stm.setString(3, targetCustomerID);
        stm.setString(4, targetCustomerName);
        stm.setString(5, targetDateBegin);
        stm.setString(6, targetDateEnd);
        stm.setString(7, targetStatus);
        stm.execute();
    }
    private void restoreDataExample() throws SQLException {
        String sql = "UPDATE Orders SET roomID=?,customerID=?," +
                "customerName=?,dateBegin=?, dateEnd=?, status=? WHERE OrderID='999'";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, targetRoomID);
        stm.setString(2, targetCustomerID);
        stm.setString(3, targetCustomerName);
        stm.setString(4, targetDateBegin);
        stm.setString(5, targetDateEnd);
        stm.setString(6, targetStatus);
        stm.executeUpdate();
    }

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        this.ordersDAO = new OrdersDAO(connection);
        orders.setOrderID(targetOderID);
        orders.setRoomID(targetRoomID);
        orders.setCustomerID(targetCustomerID);
        orders.setCustomerName(targetCustomerName);
        orders.setDateBegin(targetDateBegin);
        orders.setDateBegin(targetDateEnd);
        orders.setStatus(targetStatus);
        if (!tarDataExampleExist()) {
            insertDataExample();
        }
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (!tarDataExampleExist()) {
            insertDataExample();
            return;
        } else {
            restoreDataExample();
        }
    }

    @Test
    void addOrder() throws SQLException {
        ordersDAO.deleteByID(targetOderID);
        assertEquals(false,tarDataExampleExist());

        ordersDAO.addOrder(orders);
        assertEquals(true,tarDataExampleExist());
    }

    @Test
    void deleteByID() throws SQLException {
        ordersDAO.deleteByID(targetOderID);
        assertEquals(false,tarDataExampleExist());
    }

    @Test
    void queryByOrderID() throws SQLException {
        ResultSet r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(targetOderID,r.getString("OrderID"));
        assertEquals(targetRoomID,r.getString("roomID"));
        assertEquals(targetCustomerID,r.getString("customerID"));
        assertEquals(targetCustomerName,r.getString("customerName"));
        assertEquals(targetStatus,r.getString("status"));
    }

    @Test
    void queryByCustomerID() throws SQLException {
        ResultSet r = ordersDAO.queryByCustomerID("999");
        r.next();
        assertEquals(targetOderID,r.getString("OrderID"));
        assertEquals(targetRoomID,r.getString("roomID"));
        assertEquals(targetCustomerID,r.getString("customerID"));
        assertEquals(targetCustomerName,r.getString("customerName"));
        assertEquals(targetStatus,r.getString("status"));
    }

    @Test
    void updateDateBeginByOrderID() throws SQLException {
        ResultSet r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        String newDate = "2017-12-10";
        assertEquals(targetDateBegin, r.getString("dateBegin"));

        ordersDAO.updateDateBeginByOrderID(targetOderID,newDate);
        r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(newDate, r.getString("dateBegin"));

        ordersDAO.updateDateBeginByOrderID(targetOderID, targetDateBegin);
        r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(targetDateBegin, r.getString("dateBegin"));
    }

    @Test
    void updateDateEndByOrderID() throws SQLException {
        String newDate = "2017-12-25";
        ordersDAO.updateDateEndByOrderID(targetOderID,newDate);
        ResultSet r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(newDate, r.getString("dateEnd"));
    }

    @Test
    void updateCustomerNameByOrderID() throws SQLException {
        String newName = "testNewName";
        ordersDAO.updateCustomerNameByOrderID(targetOderID,newName);
        ResultSet r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(newName, r.getString("customerName"));
    }

    @Test
    void updateStatusByOrderID() throws SQLException {
        String newStatus = "LIVING";
        ordersDAO.updateStatusByOrderID(targetOderID,newStatus);
        ResultSet r = ordersDAO.queryByOrderID(targetOderID);
        r.next();
        assertEquals(newStatus, r.getString("status"));
    }

    @Test
    void singleUpdate() {
    }

    @Test
    void resultSetToArrayList() {
    }

}