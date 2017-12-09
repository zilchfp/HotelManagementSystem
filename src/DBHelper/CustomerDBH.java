package DBHelper;

import java.sql.*;
import java.util.Vector;

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