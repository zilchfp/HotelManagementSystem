package DBHelper;

import entity.Customer;

import java.sql.*;
import java.util.Vector;

import static java.lang.System.out;

public class CustomerDBH {
    private String userID;
    private String username;
    private String password;
    private String IDNumber;
    private Connection connection;

    public CustomerDBH(Connection c) {
        //拓展性不好，当属性数量增长时，容易代码膨胀
        this.connection = c;
        this.userID = null;
        this.username = null;
        this.password = null;
        this.IDNumber = null;

    }


    //增删查改
    //增
    public void AddCustomer(Customer c) throws SQLException {
        this.userID = c.getUserID();
        this.username = c.getUsername();
        this.password = c.getPassword();
        this.IDNumber = c.getIDNumber();
        String sql = "insert into Customer values (?,?,?,?)";
        Vector<String> attributeList = getAttributeList();
        QueryHelper.execute(connection, attributeList, sql);
    }

    //删
    public void DeleteByUserID(String userID) throws SQLException {
        this.userID = userID;
        String sql = "delete from Customer where userID = ?";
        Vector<String> attributeList = getAttributeList();
        QueryHelper.execute(connection, attributeList, sql);
    }

    //查
    public ResultSet QueryByUsername(String username) throws SQLException {
        this.username = username;
        String sql = "select * from Customer where username = ?";
        Vector<String> attributeList = getAttributeList();
        return QueryHelper.getResult(connection, attributeList, sql);
    }
    public ResultSet QueryByUserID(String userID) throws SQLException {
        this.userID = userID;
        String sql = "select * from Customer where userID = ?";
        Vector<String> attributeList = getAttributeList();
        return QueryHelper.getResult(connection, attributeList, sql);
    }

    //改
    public void UpdateUsername(String Username, String ID) throws SQLException {
        String sql = " update Customer set username=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,Username);
        stm.setString(2,ID);
        stm.executeUpdate();
    }
    public void UpdatePassword(String Password, String ID) throws SQLException {
        String sql = " update Customer set password=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,Password);
        stm.setString(2,ID);
        stm.executeUpdate();
    }
    public void UpdateIDNumber(String IDNumber, String ID) throws SQLException {
        String sql = " update Customer set IDNumber=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,IDNumber);
        stm.setString(2,ID);
        stm.executeUpdate();
    }

    public void Update(String sql) throws SQLException {

    }


    public void showOrder() {

    }

    private Vector<String> getAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.userID);
        attributeList.add(this.username);
        attributeList.add(this.password);
        attributeList.add(this.IDNumber);
        return attributeList;
    }




    //GETTER AND SETTER
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
}
