package DAOHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Helper {

    public static ResultSet getResult(Connection connection, Vector<String> attributeList, String sql) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        ResultSet res = stm.executeQuery();
        return res;
    }

    public static void execute(Connection connection, Vector<String> attributeList, String sql) throws SQLException {
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.execute();
    }

    public static void addStrings(PreparedStatement stm, Vector<String> attributeList) throws SQLException {
        int cnt = 1;
        for (int i = 0; i < attributeList.size(); i++) {
            String s = attributeList.elementAt(i);
            if (s != null) {
//                System.out.println("i:"+i+" cnt :" + cnt + " attribute changed:" + s);
                stm.setString(cnt,s);
                cnt++;
            }
        }
    }

    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date); //2016-11-16
    }

}
