package DBHelper;

import entity.GeneralHelp;
import entity.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class OrdersDBH {
    private String OrderID;
    private String roomID;
    private String customerID;
    private String customerName;
    private String dateBegin;
    private String dateEnd;
    private String status;
    private Connection connection;

    public OrdersDBH(Connection c) {
        this.connection = c;
        this.OrderID = null;
        this.roomID = null;
        this.customerID = null;
        this.customerName = null;
        this.dateBegin = null;
        this.dateEnd = null;
        this.status = null;
    }

    //数据库的增删查改
    //增
    public void AddOrder(Orders orders) throws SQLException {
        this.OrderID = GeneralHelp.getRandomUserID();
        this.roomID = orders.getRoomID();
        this.customerID = orders.getCustomerID();
        this.customerName = orders.getCustomerName();
        this.dateBegin = orders.getDateBegin();
        this.dateEnd = orders.getDateEnd();
        this.status = orders.getStatus();
        String sql = "insert into Orders values (?,?,?,?,?,?,?)";
        Vector<String> attributeList = GetAttributeList();
        Helper.execute(connection, attributeList, sql);
    }

    //删
    public void DeleteByID(String OrdersID) throws SQLException {
        this.OrderID = OrdersID;
        String sql = "delete from Orders where OrderID = ?";
        Vector<String> attributeList = GetAttributeList();
        Helper.execute(connection, attributeList, sql);

    }

    //查
    public ResultSet QueryByID(String OrderID) throws SQLException {
        this.OrderID = OrderID;
        String sql = "select * from Orders where OrderID = ?";
        Vector<String> attributeList = GetAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    //改




    //PRIVATE MEMBERS

    private Vector<String> GetAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.OrderID);
        attributeList.add(this.roomID);
        attributeList.add(this.customerID);
        attributeList.add(this.customerName);
        attributeList.add(this.dateBegin);
        attributeList.add(this.dateEnd);
        attributeList.add(this.status);
        return attributeList;
    }

    //SETTER AND GETTER
    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
