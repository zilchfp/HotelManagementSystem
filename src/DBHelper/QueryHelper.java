package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class QueryHelper {

    public static ResultSet getResult(Connection connection, Vector<String> attributeList, String sql) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(sql);
        QueryHelper.addStrings(stm, attributeList);
        ResultSet res = stm.executeQuery();
        return res;
    }

    public static void addStrings(PreparedStatement stm, Vector<String> attributeList) throws SQLException {
        int cnt = 1;
        for (int i = 0; i < attributeList.size(); i++) {
            String s = attributeList.elementAt(i);
            if (s != null) {
                System.out.println("i:"+i+" cnt :" + cnt + " s:" + s);
                stm.setString(cnt,s);
                cnt++;
            }
        }
    }

}
