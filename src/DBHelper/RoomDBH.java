package DBHelper;

import entity.GeneralHelp;
import entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class RoomDBH {

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
    在线浏览房间信息：可以查询酒店房间信息，按时间搜索有效空余房间—订房客户
    预订：凭借身份证号在线预订空余房间，录入入住和离店日期，房价、房间类型，一旦预订将锁定直至入住日。—订房客户

    预订入住：根据身份证号直接调出预订单，并按客户要求如楼层、朝向等分配房间直接入住。--前台接待员
    退房管理：显示结账账单。--前台接待员
    可用房查询：根据日期、房型查阅可用房间--前台接待员

    客房类型设置：设置客房分类信息：客房类型、房价、空余房间数—经理
    客房信息设置：房间号，房间类型、楼层、朝向、房间特征描述、房间状态是否空置等—经理
    房态统计：用表格或图形显示整个酒店房间状态，可以分客房类型、楼层朝向等进行分类查询统计。—经理
     */

    //增删查改
    //增
    public boolean addRoom() throws SQLException {
        String sql = "insert into Room values (?,?,?,?,?,?,?);";
        this.setID(GeneralHelp.getRandomUserID());
        Vector<String> attributeList = this.getAttributeList();
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.executeUpdate();
        return true;
    }

    //删除


    //查
    public ResultSet query(String sql) throws SQLException {
        Vector<String> attributeList = this.getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    public Room roomQuery(String roomID) throws SQLException {
        String sql = "select * from Room where ID=?";
        this.setID(roomID);
        ResultSet res = this.query(sql);
        Room resultRoom = new Room();
        while(res.next()) {
            resultRoom.setID(res.getString(1));
            resultRoom.setNumber(res.getString(2));
            resultRoom.setType(res.getString(3));
            resultRoom.setFloor(res.getString(4));
            resultRoom.setDirection(res.getString(5));
            resultRoom.setDescription(res.getString(6));
            resultRoom.setStatus(res.getString(7));
        }

        return resultRoom;

    }

    //改
    public void update(String sql) throws SQLException {
        Vector<String> attributeList = getAttributeList();
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.executeUpdate();
    }
    public void updateStatusByRoomID(String roomID, String status) throws SQLException {
        String sql = " update Room set status=? where ID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,status);
        stm.setString(2,roomID);
        stm.executeUpdate();
    }
    public void updateRoomNumberByRoomID(String roomID, String roomNumber) throws SQLException {
        String sql = " update Room set number=? where ID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,roomNumber);
        stm.setString(2,roomID);
        stm.executeUpdate();
    }

    //Private Member
    private String ID;
    private String number;
    private String type;
    private String floor;
    private String direction;
    private String description;
    private String status;
    private Connection connection;

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
