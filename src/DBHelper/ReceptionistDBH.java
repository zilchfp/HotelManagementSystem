package DBHelper;

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
        Vector<String> attributeList = getAttributeList();
        return QueryHelper.getResult(connection, attributeList, sql);
    }

    public void Delete(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        Vector<String> attributeList = getAttributeList();
        String sql = "delete from Receptionist where ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        QueryHelper.addStrings(stm, attributeList);
        stm.execute();
    }

    public void Modify(String ReceptionistID) throws SQLException {
        this.setID(ReceptionistID);
        Vector<String> attributeList = getAttributeList();
        String sql = "delete from Receptionist where ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        QueryHelper.addStrings(stm, attributeList);
        stm.execute();
    }


    //PRIVATE MEMBERS
    private String ID;
    private String name;
    private String gender;
    private Connection connection;


    private Vector<String> getAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.ID);
        attributeList.add(this.name);
        attributeList.add(this.gender);
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

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
