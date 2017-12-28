package DAOHelper;

import entity.GeneralHelp;
import entity.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class OrdersDAO {
    private String OrderID;
    private String roomID;
    private String customerID;
    private String customerName;
    private String dateBegin;
    private String dateEnd;
    private String status;
    private String type;
    private Connection connection;

    public OrdersDAO(Connection c) {
        this.connection = c;
        this.OrderID = null;
        this.roomID = null;
        this.customerID = null;
        this.customerName = null;
        this.dateBegin = null;
        this.dateEnd = null;
        this.status = null;
        this.type = null;
    }
    //数据库的增删查改
    //增
    public boolean addOrder(Orders orders) throws SQLException {
        if (orders.getOrderID() == null) {
            this.OrderID = GeneralHelp.getRandomUserID();  //FOR TestCase
        } else {
            this.OrderID = orders.getOrderID();
        }
        this.roomID = orders.getRoomID();
        this.customerID = orders.getCustomerID();
        this.customerName = orders.getCustomerName();
        this.dateBegin = orders.getDateBegin();
        this.dateEnd = orders.getDateEnd();
        this.status = orders.getStatus();
        this.type = orders.getType();
        String sql = "insert into Orders values (?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,this.OrderID);
        stm.setString(2,this.roomID);
        stm.setString(3,this.customerID);
        stm.setString(4,this.customerName);
        stm.setString(5,this.dateBegin);
        stm.setString(6,this.dateEnd);
        stm.setString(7,this.status);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    //删
    public boolean deleteByID(String OrdersID) throws SQLException {
        this.OrderID = OrdersID;
        String sql = "delete from Orders where OrderID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,OrderID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    //查
    public ResultSet queryByOrderID(String OrderID) throws SQLException {
        String sql = "select * from Orders where OrderID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,OrderID);
        ResultSet resultSet = stm.executeQuery();
        return resultSet;
    }
    public ResultSet queryByCustomerID(String customerID) throws SQLException {
        String sql = "select * from Orders where customerID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,customerID);
        ResultSet resultSet = stm.executeQuery();
        return resultSet;
    }



    //改
    public boolean updateDateBeginByOrderID(String OrderID, String dateBegin) throws SQLException {
        String sql = "update Orders set dateBegin=? where OrderID=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,dateBegin);
        stm.setString(2,OrderID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    public boolean updateDateEndByOrderID(String OrderID, String dateEnd) throws SQLException {
        String sql = "update Orders set dateEnd=? where OrderID=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,dateEnd);
        stm.setString(2,OrderID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    public boolean updateCustomerNameByOrderID(String OrderID, String customerName) throws SQLException {
        String sql = "update Orders set customerName=? where OrderID=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,customerName);
        stm.setString(2,OrderID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    public boolean updateStatusByOrderID(String OrderID, String status) throws SQLException {
        String sql = "update Orders set status=? where OrderID=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,status);
        stm.setString(2,OrderID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    public boolean singleUpdate(String setAttribute, String setValue,
                                String whereAttribute, String whereValue) throws SQLException {
        String sql = "update Orders set " +
                        setAttribute+"=? where " +
                        whereAttribute+"=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,setValue);
        stm.setString(2,whereValue);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }



    public ArrayList<Orders> resultSetToArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Orders> ordersArrayList = new ArrayList<>();
        while (resultSet.next()) {
            Orders o = new Orders();
            o.setOrderID(resultSet.getString(1));
            o.setRoomID(resultSet.getString(2));
            o.setCustomerID(resultSet.getString(3));
            o.setCustomerName(resultSet.getString(4));
            o.setDateBegin(resultSet.getString(5));
            o.setDateEnd(resultSet.getString(6));
            o.setStatus(resultSet.getString(7));
            ordersArrayList.add(o);
        }
        return ordersArrayList;
    }


    //PRIVATE MEMBERS
    private Vector<String> getAttributeList() {
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
