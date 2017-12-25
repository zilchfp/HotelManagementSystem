package DAOHelper;

import entity.GeneralHelp;
import entity.Orders;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class OrdersDAOTest {
    //“tar” for “Target”
    private Orders orders = new Orders();
    private String tarOderID = "999";
    private String tarRoomID = "1";
    private String tarCustomerID = "999";
    private String tarCustomerName = "test";
    private String tarDateBegin = "2017-12-12";
    private String tarDateEnd = "2017-12-21";
    private String tarStatus = "test";
    private OrdersDAO ordersDAO;
    private Connection connection = DBHGeneral.getConnection();

    OrdersDAOTest() throws SQLException {
    }


    private boolean tarDataExampleExist() throws SQLException {
        String sqlExist = "SELECT * FROM Orders WHERE OrderID=?";
        PreparedStatement stmExist = connection.prepareStatement(sqlExist);
        stmExist.setString(1,tarOderID);
        ResultSet resultSetExist = stmExist.executeQuery();
        return resultSetExist.next();
    }
    private void insertDataExample() throws SQLException {
        String sql = "insert into Orders values (?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,tarOderID);
        stm.setString(2,tarRoomID);
        stm.setString(3,tarCustomerID);
        stm.setString(4,tarCustomerName);
        stm.setString(5,tarDateBegin);
        stm.setString(6,tarDateEnd);
        stm.setString(7,tarStatus);
        stm.execute();
    }
    private void restoreDataExample() throws SQLException {
        String sql = "UPDATE Orders SET roomID=?,customerID=?," +
                "customerName=?,dateBegin=?, dateEnd=?, status=? WHERE OrderID='999'";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,tarRoomID);
        stm.setString(2,tarCustomerID);
        stm.setString(3,tarCustomerName);
        stm.setString(4,tarDateBegin);
        stm.setString(5,tarDateEnd);
        stm.setString(6,tarStatus);
        stm.executeUpdate();
    }

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        this.ordersDAO = new OrdersDAO(connection);
        orders.setOrderID(tarOderID);
        orders.setRoomID(tarRoomID);
        orders.setCustomerID(tarCustomerID);
        orders.setCustomerName(tarCustomerName);
        orders.setDateBegin(tarDateBegin);
        orders.setDateBegin(tarDateEnd);
        orders.setStatus(tarStatus);
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
        ordersDAO.deleteByID(tarOderID);
        assertEquals(false,tarDataExampleExist());

        ordersDAO.addOrder(orders);
        assertEquals(true,tarDataExampleExist());
    }

    @Test
    void deleteByID() throws SQLException {
        ordersDAO.deleteByID(tarOderID);
        assertEquals(false,tarDataExampleExist());
    }

    @Test
    void queryByOrderID() throws SQLException {
        ResultSet r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        assertEquals(tarOderID,r.getString("OrderID"));
        assertEquals(tarRoomID,r.getString("roomID"));
        assertEquals(tarCustomerID,r.getString("customerID"));
        assertEquals(tarCustomerName,r.getString("customerName"));
        assertEquals(tarStatus,r.getString("status"));
    }

    @Test
    void queryByCustomerID() throws SQLException {
        ResultSet r = ordersDAO.queryByCustomerID("999");
        r.next();
        assertEquals(tarOderID,r.getString("OrderID"));
        assertEquals(tarRoomID,r.getString("roomID"));
        assertEquals(tarCustomerID,r.getString("customerID"));
        assertEquals(tarCustomerName,r.getString("customerName"));
        assertEquals(tarStatus,r.getString("status"));
    }

    @Test
    void updateDateBeginByOrderID() throws SQLException {
        ResultSet r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        String newDate = "2017-12-10";
        assertEquals(tarDateBegin, r.getString("dateBegin"));

        ordersDAO.updateDateBeginByOrderID(tarOderID,newDate);
        r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        assertEquals(newDate, r.getString("dateBegin"));

        ordersDAO.updateDateBeginByOrderID(tarOderID,tarDateBegin);
        r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        assertEquals(tarDateBegin, r.getString("dateBegin"));
    }

    @Test
    void updateDateEndByOrderID() throws SQLException {
        String newDate = "2017-12-25";
        ordersDAO.updateDateEndByOrderID(tarOderID,newDate);
        ResultSet r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        assertEquals(newDate, r.getString("dateEnd"));
    }

    @Test
    void updateCustomerNameByOrderID() throws SQLException {
        String newName = "testNewName";
        ordersDAO.updateCustomerNameByOrderID(tarOderID,newName);
        ResultSet r = ordersDAO.queryByOrderID(tarOderID);
        r.next();
        assertEquals(newName, r.getString("customerName"));
    }

    @Test
    void updateStatusByOrderID() throws SQLException {
        String newStatus = "LIVING";
        ordersDAO.updateStatusByOrderID(tarOderID,newStatus);
        ResultSet r = ordersDAO.queryByOrderID(tarOderID);
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