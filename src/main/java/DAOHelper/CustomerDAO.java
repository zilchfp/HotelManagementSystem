package DAOHelper;

import entity.Customer;
import entity.Helper;

import java.sql.*;
import java.util.*;

import static java.lang.System.out;

public class CustomerDAO {
    private String userID;
    private String username;
    private String password;
    private String IDNumber;
    private String customerName;
    private Connection connection = DBHGeneral.getConnection();

    public CustomerDAO() throws SQLException {
        //拓展性不好，当属性数量增长时，容易代码膨胀
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
            this.userID = Helper.getRandomUserID();
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
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    //删
    public boolean deleteByUserID(String userID) throws SQLException {
        //这涉及到外键约束，导致无法删除
        String sql = "delete from Customer where userID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,userID);
        int a = stm.executeUpdate();
        return (a == 0 ? false : true);
    }

    //查
    public ResultSet queryByUsername(String username) throws SQLException {
        this.username = username;
        String sql = "select * from Customer where username = ?";
        Vector<String> attributeList = getAttributeList();
        return DAOHelper.Helper.getResult(connection, attributeList, sql);
    }
    public Customer queryByUserID(String userID) throws SQLException {
        this.userID = userID;
        String sql = "select * from Customer where userID = ?";
        Vector<String> attributeList = getAttributeList();
        ResultSet r = DAOHelper.Helper.getResult(connection, attributeList, sql);
        Customer c = new Customer();
        boolean isEmpty = true;
        while (r.next()) {
            isEmpty = false;
            c.setUserID(r.getString("userID"));
            c.setUsername(r.getString("username"));
            c.setPassword(r.getString("password"));
            c.setIDNumber(r.getString("IDNumber"));
            c.setCustomerName(r.getString("customerName"));
        }
        if (isEmpty) return null;
            else return c;
    }
    public ResultSet getAllCustomers() throws SQLException {
        String sql = "select * from Customer";
        Vector<String> attributeList = getAttributeList();
        return DAOHelper.Helper.getResult(connection, attributeList, sql);
    }
    public ArrayList<String> getAllCustomersID() throws SQLException {
        String sql = "select userID from Customer";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        ArrayList<String> ans = new ArrayList<>();
        while (r.next()) {
            ans.add(r.getString(1));
        }
        return ans;
    }
    public ResultSet queryCustomersLiving() throws SQLException {
        String sql ="select userID,IDNumber,Customer.customerName,roomID,dateBegin,dateEnd " +
                    "from Customer " +
                    "left join Orders " +
                    "on Customer.userID = Orders.customerID " +
                    "where (Orders.status='在住') and (dateEnd >= ?)" +
                    "order by userID";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, DAOHelper.Helper.getToday());
        return stm.executeQuery();
    }
    public HashMap<String,Integer> getUnavailableRoomTypeWithNumber(String dataBegin, String dateEnd) throws SQLException {
        String sql = "select type,COUNT(OrderID) as number " +
                    "from Customer " +
                    "left join Orders " +
                    "on Customer.userID = Orders.customerID " +
                    "where  (Orders.status='在住' OR Orders.status='预定') AND " +
                "( (dateBegin <= ? AND dateEnd >= ?) OR  " +
                "  (dateBegin <= ? AND dateEnd >= ?) OR " +
                "  (dateBegin <= ? AND dateEnd >= ?) OR " +
                "  (dateBegin <= ? AND dateEnd >= ?)) " +
                "   group by type ";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, dataBegin);
        stm.setString(2, dataBegin);
        stm.setString(3, dateEnd);
        stm.setString(4, dateEnd);
        stm.setString(5, dataBegin);
        stm.setString(6, dateEnd);
        stm.setString(7, dateEnd);
        stm.setString(8, dataBegin);


        ResultSet resultSet = stm.executeQuery();
        HashMap<String,Integer> map = new HashMap<>();

        while (resultSet.next()) {
            String type = resultSet.getString(1);
            int num = resultSet.getInt(2);
            map.put(type,num);
            out.println(type + "  " + num);
        }
        return map;
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
