package DAOHelper;

import entity.Receptionist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import static java.lang.System.out;

public class ReceptionistDAO {
    public ReceptionistDAO(Connection c) {
        //拓展性不好，当属性数量增长时，容易代码膨胀
        this.connection = c;
        this.ID = null;
        this.gender = null;
        this.name = null;
    }

    public ResultSet Query(String sql) throws SQLException {
        Vector<String> attributeList = getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }

    public boolean DeleteByID(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        String sql = "delete from Receptionist WHERE ID = ? ;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,ReceptionistID);
        int n = stm.executeUpdate();
        return (n == 0 ? false:true);
    }

    public void Modify(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        Vector<String> attributeList = getAttributeList();
        String sql = "delete from Receptionist where ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.execute();
    }

    //数据库的增删查改
    //增
    public void addReceptionist(Receptionist receptionist) throws SQLException {
        this.ID = receptionist.getID();
        this.name = receptionist.getName();
        this.gender = receptionist.getName();
        this.username = receptionist.getUsername();
        this.password = receptionist.getPassword();
        String sql = "insert into Receptionist values (?,?,?,?,?)";
        Vector<String> attributeList = getAttributeList();
        Helper.execute(connection, attributeList, sql);
    }

    //删
    public void deleteByID(String ReceptionistID) throws SQLException {
        this.ID = ReceptionistID;
        String sql = "delete from Receptionist where ID = ?";
        Vector<String> attributeList = getAttributeList();
        Helper.execute(connection, attributeList, sql);

    }

    //查

    public Receptionist queryByID(String receptionistID) throws SQLException {
        this.setID(receptionistID);
        ResultSet resultSet = this.Query("select * from Receptionist where ID=?");
        Receptionist receptionist = new Receptionist();
        while(resultSet.next()) {
            receptionist.setID(resultSet.getString(1));
            receptionist.setName(resultSet.getString(2));
            receptionist.setGender(resultSet.getString(3));
            receptionist.setUsername(resultSet.getString(4));
            receptionist.setPassword(resultSet.getString(5));
        }
        return receptionist;
    }

    public ResultSet queryReceptionistByUsernamePassword(String username, String password) throws SQLException {
        String sql = "select * from Receptionist where username=? and password=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,username);
        stm.setString(2,password);
        return stm.executeQuery();
    };

    public ArrayList<String> getAllReceptionistID() throws SQLException {
        String sql = "SELECT  ID from Receptionist ORDER  BY ID ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        ArrayList<String> ans = new ArrayList<>();
        while (r.next()) {
            ans.add(r.getString(1));
        }
        return  ans;
    }

    //改
    public void updateWholeReceptionistByID(String receptionistID) throws SQLException {
        //获取原来的接待员信息
        Receptionist originalReceptionist = queryByID(receptionistID);
        out.println(originalReceptionist.getPassword());

    }

    //PRIVATE MEMBERS
    private String ID;
    private String name;
    private String gender;
    private String username;
    private String password;
    private Connection connection;


    private Vector<String> getAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.ID);
        attributeList.add(this.name);
        attributeList.add(this.gender);
        attributeList.add(this.username);
        attributeList.add(this.password);
        return attributeList;
    }

    //GETTER AND SETTER
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
