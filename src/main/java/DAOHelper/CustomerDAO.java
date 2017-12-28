package DAOHelper;

import entity.Customer;
import entity.GeneralHelp;

import java.sql.*;
import java.util.Vector;

public class CustomerDAO {
    private String userID;
    private String username;
    private String password;
    private String IDNumber;
    private String customerName;
    private Connection connection;

    public CustomerDAO(Connection c) {
        //拓展性不好，当属性数量增长时，容易代码膨胀
        this.connection = c;
        this.userID = null;
        this.username = null;
        this.password = null;
        this.IDNumber = null;
        this.customerName = null;
    }


    //数据库的增删查改操作
    //增
    public boolean addCustomer(Customer c) throws SQLException {
        if (c.getUserID() == null) {
            this.userID = GeneralHelp.getRandomUserID();
        } else {
            this.userID = c.getUserID();  //For TestCase
        }
        this.username = c.getUsername();
        this.password = c.getPassword();
        this.IDNumber = c.getIDNumber();
        this.customerName = c.getCustomerName();
        String sql = "insert into Customer values (?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,this.userID);
        stm.setString(2,this.username);
        stm.setString(3,this.password);
        stm.setString(4,this.IDNumber);
        stm.setString(5,this.customerName);
        return stm.execute();
    }

    //删
    public boolean deleteByUserID(String userID) throws SQLException {
        //这涉及到外键约束，导致无法删除
        String sql = "delete from Customer where userID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,userID);
        return stm.execute();
    }

    //查
    public ResultSet queryByUsername(String username) throws SQLException {
        this.username = username;
        String sql = "select * from Customer where username = ?";
        Vector<String> attributeList = getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    public ResultSet queryByUserID(String userID) throws SQLException {
        this.userID = userID;
        String sql = "select * from Customer where userID = ?";
        Vector<String> attributeList = getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    public ResultSet getAllCustomers() throws SQLException {
        String sql = "select * from Customer";
        Vector<String> attributeList = getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    public ResultSet queryCustomersLiving() throws SQLException {
        String sql ="select userID,IDNumber,Customer.customerName,roomID,dateBegin,dateEnd " +
                    "from Customer " +
                    "left join Orders " +
                    "on Customer.userID = Orders.customerID " +
                    "where (Orders.status='LIVING')" +
                    "order by userID";
        PreparedStatement stm = connection.prepareStatement(sql);
        return stm.executeQuery();
    }

    //改
    public void updateUsername(String Username, String ID) throws SQLException {
        String sql = " update Customer set username=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,Username);
        stm.setString(2,ID);
        stm.executeUpdate();
    }
    public void updatePassword(String Password, String ID) throws SQLException {
        String sql = " update Customer set password=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,Password);
        stm.setString(2,ID);
        stm.executeUpdate();
    }
    public void updateIDNumber(String IDNumber, String ID) throws SQLException {
        String sql = " update Customer set IDNumber=? where userID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,IDNumber);
        stm.setString(2,ID);
        stm.executeUpdate();
    }


    public void showOrder() {

    }


    //PRIVATE MEMBERS
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
