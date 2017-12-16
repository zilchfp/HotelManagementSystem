package DBHelper;

import entity.Receptionist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ReceptionistDBH {
    public ReceptionistDBH(Connection c) {
        //拓展性不好，当属性数量增长时，容易代码膨胀
        this.connection = c;
        this.ID = null;
        this.gender = null;
        this.name = null;
    }

    public ResultSet Query(String sql) throws SQLException {
        Vector<String> attributeList = GetAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }

    public void Delete(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        Vector<String> attributeList = GetAttributeList();
        String sql = "delete from Receptionist where ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.execute();
    }

    public void Modify(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        Vector<String> attributeList = GetAttributeList();
        String sql = "delete from Receptionist where ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.execute();
    }

    //数据库的增删查改
    //增
    public void AddReceptionist(Receptionist receptionist) throws SQLException {
        this.ID = receptionist.getID();
        this.name = receptionist.getName();
        this.gender = receptionist.getName();
        this.username = receptionist.getUsername();
        this.password = receptionist.getPassword();
        String sql = "insert into Receptionist values (?,?,?,?,?)";
        Vector<String> attributeList = GetAttributeList();
        Helper.execute(connection, attributeList, sql);
    }

    //删
    public void DeleteByID(String ReceptionistID) throws SQLException {
        this.ID = ReceptionistID;
        String sql = "delete from Receptionist where ID = ?";
        Vector<String> attributeList = GetAttributeList();
        Helper.execute(connection, attributeList, sql);

    }

    //查

    //改


    //PRIVATE MEMBERS
    private String ID;
    private String name;
    private String gender;
    private String username;
    private String password;
    private Connection connection;


    private Vector<String> GetAttributeList() {
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
