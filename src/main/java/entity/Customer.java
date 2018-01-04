package entity;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private String userID;
    private String username;
    private String password;
    private String IDNumber;
    private String customerName;

    public Customer (ResultSet res) throws SQLException {
        this.userID = res.getString("userID");
        this.username = res.getString("username");
        this.password = res.getString("password");
        this.IDNumber = res.getString("IDNumber");
        this.customerName = res.getString("customerName");
    }

    public Customer (String username,String  password,String IDNumber, String customerName) {
        // TODO
        //这里生成的ID有可能与原数据库的的ID冲突，这里因为选的是long产生的随机ID，所以在数据较小的情况下暂时没有问题
        this.userID = Helper.getRandomUserID();
        this.username = username;
        this.password = password;
        this.IDNumber = IDNumber;
        this.customerName = customerName;
    }

    public Customer (String username,String  password,String IDNumber) {
        // TODO
        //这里生成的ID有可能与原数据库的的ID冲突，这里因为选的是long产生的随机ID，所以在数据较小的情况下暂时没有问题
        this.userID = Helper.getRandomUserID();
        this.username = username;
        this.password = password;
        this.IDNumber = IDNumber;
    }

    public Customer (String userID) {
        this.userID = userID;
        this.username = null;
        this.password = null;
        this.IDNumber = null;
    }

    public Customer() {

    }


    public boolean register() throws SQLException {
        Connection connection = DBHGeneral.getConnection();
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.addCustomer(this);
    }

    public void remove() throws SQLException {
        Connection connection = DBHGeneral.getConnection();
        String userID = this.getUserID();
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.deleteByUserID(this.getUserID());
        connection.close();
    }

    public ResultSet getAllOrders() throws SQLException {
        OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
        return ordersDBH.queryByCustomerID(this.userID);
    }


    //PRIVATE MEMBER


    //getter and setter
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
