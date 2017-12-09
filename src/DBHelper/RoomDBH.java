package DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static java.lang.System.out;

public class RoomDBH {
    private String ID;
    private String number;
    private String type;
    private String floor;
    private String direction;
    private String description;
    private String status;
    private Connection connection;


    public RoomDBH(Connection c) {
        this.ID = null;
        this.number = null;
        this.type = null;
        this.floor = null;
        this.direction = null;
        this.description = null;
        this.status = null;
        this.connection = c;
    }

    /*
    客房类型设置：设置客房分类信息：客房类型、房价、空余房间数—经理
    客房信息设置：房间号，房间类型、楼层、朝向、房间特征描述、房间状态是否空置等—经理

    在线浏览房间信息：可以查询酒店房间信息，按时间搜索有效空余房间—订房客户

    预订：凭借身份证号在线预订空余房间，录入入住和离店日期，房价、房间类型，一旦预订将锁定直至入住日。—订房客户

    预订入住：根据身份证号直接调出预订单，并按客户要求如楼层、朝向等分配房间直接入住。--前台接待员

    退房管理：将房间设置为可用，显示结账账单。--前台接待员

    可用房查询：根据日期、房型查阅可用房间--前台接待员

    房态统计：用表格或图形显示整个酒店房间状态，可以分客房类型、楼层朝向等进行分类查询统计。—经理
     */

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

    public void checkout(String roomID) throws SQLException {
        //String sql = "update Room set status=\"AVALIABLE\" where ID=？";
        //String sql = "update Room set status=\"AVALIABLE\" where ID=？";
        String sql = "select * from Room";

        Connection conn = DBHInitialize.getConnection();
        RoomDBH helper = new RoomDBH(conn);
        //String sql = "select * from Customer where username = ?";

        ResultSet res = helper.Query(sql);
        if (res == null) {
            out.println("res is null");
        }
        while (res.next()) {
            String s = res.getString(description);
            if (s == null) {
                out.println("s is null");
            } else {
                out.println(s);
            }
        }
    }

    //PRIVATE

    private Vector<String> getAttributeList() {
        Vector<String> attributeList;
        attributeList = new Vector<>();
        attributeList.add(this.ID);
        attributeList.add(this.number);
        attributeList.add(this.type);
        attributeList.add(this.floor);
        attributeList.add(this.direction);
        attributeList.add(this.description);
        attributeList.add(this.status);
        return attributeList;
    }



    //GETTER AND SETTER
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
