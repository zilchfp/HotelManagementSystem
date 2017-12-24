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
    private Orders orders = new Orders();
    private String tarOderID = "999";
    private String tarRoomID = "1";
    private String tarCustomerID = "999";
    private String tarCustomerName = "test";
    private String tarDateBegin = "2017-12-12";
    private String tarDateEnd = "2017-12-21";
    private String tarStatus = "test";
    private OrdersDAO ordersDAO;


    @BeforeEach
    void setUp() throws SQLException {
        orders.setOrderID(tarOderID);
        orders.setRoomID(tarRoomID);
        orders.setCustomerID(tarCustomerID);
        orders.setCustomerName(tarCustomerName);
        orders.setDateBegin(tarDateBegin);
        orders.setDateBegin(tarDateEnd);
        orders.setStatus(tarStatus);
        this.ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() throws SQLException {
        Connection c = DBHGeneral.getConnection();
        String sql = "UPDATE Orders SET OrderID=?,roomID=?,customerID=?," +
                    "customerName=?,dateBegin=?, dateEnd=?, status=?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1,tarOderID);
        stm.setString(2,tarRoomID);
        stm.setString(3,tarCustomerID);
        stm.setString(4,tarCustomerName);
        stm.setString(5,tarDateBegin);
        stm.setString(6,tarDateEnd);
        stm.setString(7,tarStatus);
    }

    @Test
    void addOrder() {
    }

    @Test
    void deleteByID() {
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