package DAOHelper;

import entity.GeneralHelp;
import entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class RoomDAO {

    public RoomDAO(Connection c) {
        this.ID = null;
        this.number = null;
        this.type = null;
        this.floor = null;
        this.direction = null;
        this.description = null;
        this.status = null;
        this.connection = c;
    }

    //增删查改
    //***************************************************************
    //增加
    //***************************************************************
    public boolean addNewRoom() throws SQLException {
        String sql = "insert into Room values (?,?,?,?,?,?,?);";
        this.setID(GeneralHelp.getRandomUserID());
        Vector<String> attributeList = this.getAttributeList();
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.executeUpdate();
        return true;
    }
    //***************************************************************
    //删除
    //***************************************************************
    public void deleteRoomByID(String roomID) throws SQLException {
        String sql = "DELETE FROM Room WHERE ID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,roomID);
        stm.execute();
    }

    //***************************************************************
    //查询
    //***************************************************************
    public ResultSet query(String sql) throws SQLException {
        Vector<String> attributeList = this.getAttributeList();
        return Helper.getResult(connection, attributeList, sql);
    }
    public Room roomQueryByID(String roomID) throws SQLException {
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
    public HashMap<String, Integer> getAllRoomTypeWithNumber() throws SQLException {
        String sql ="select type,COUNT(ID) from Room group by type order by type;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet resultSet = stm.executeQuery();
        HashMap<String,Integer> map = new HashMap<>();
        while (resultSet.next()) {
            String type = resultSet.getString(1);
            int num = resultSet.getInt(2);
            map.put(type,num);
        }
        return map;
    }
    public ResultSet getRoomUnavailableBetween(String dateBegin, String dateEnd) throws SQLException {
        String sql ="select count(type),type from Room group by type where ";
        PreparedStatement stm = connection.prepareStatement(sql);
        return stm.executeQuery();
    }
    public ArrayList<String> getAllRoomID() throws SQLException {
        String sql = "select ID from Room ORDER BY ID ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        ArrayList<String> ans = new ArrayList<>();
        while (r.next()) {
            ans.add(r.getString(1));
        }
        return ans;
    }

    //***************************************************************
    //修改
    //***************************************************************
    public void update(String sql) throws SQLException {
        Vector<String> attributeList = getAttributeList();
        PreparedStatement stm = connection.prepareStatement(sql);
        Helper.addStrings(stm, attributeList);
        stm.executeUpdate();
    }
    public boolean updateRoomInformation(Room room) throws SQLException {
        String sql = "UPDATE Room " +
                     "SET number=?, type=?, floor=?, direction=?, description=?, status=? " +
                     "WHERE ID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,room.getNumber());
        stm.setString(2,room.getType());
        stm.setString(3,room.getFloor());
        stm.setString(4,room.getDirection());
        stm.setString(5,room.getDescription());
        stm.setString(6,room.getStatus());
        stm.setString(7,room.getID());
        int n = stm.executeUpdate();
        return (n == 0 ? false : true);
    }
    public boolean updateStatusByRoomID(String roomID, String status) throws SQLException {
        String sql = " update Room set status=? where ID=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,status);
        stm.setString(2,roomID);
        int n = stm.executeUpdate();
        return (n == 0 ? false : true);
    }
    public void updateRoomNumberByRoomID(String roomID, String roomNumber) throws SQLException {
        String sql = " update Room set number = ? where ID=?";
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
