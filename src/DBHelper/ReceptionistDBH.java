package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ReceptionistDBH {
    private String ID;
    private String name;
    private String gender;
    private Connection connection;

    public ReceptionistDBH(Connection c) {
        //拓展性不好，当属性数量增长时，容易代码膨胀
        this.connection = c;
        this.ID = null;
        this.gender = null;
        this.name = null;
    }

    public ResultSet Query(String sql) throws SQLException {
        Vector<String> attributeList = getAttributeList();
        PreparedStatement stm = connection.prepareStatement(sql);
        int cnt = 1;
        for (int i = 0; i < attributeList.size(); i++) {
            String s = attributeList.elementAt(i);
            System.out.println("i:"+i+" cnt :" + cnt + " s:" + s);
            if (s != null) {
                stm.setString(cnt,s);
                cnt++;
            }
        }
        ResultSet res = stm.executeQuery();
        return res;
    }

    private Vector<String> getAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.ID);
        attributeList.add(this.name);
        attributeList.add(this.gender);
        return attributeList;
    }


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
