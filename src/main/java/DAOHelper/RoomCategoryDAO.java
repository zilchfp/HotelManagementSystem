package DAOHelper;

import ReceptionManagement.PreservationCheckin;
import entity.Room;
import entity.RoomCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class RoomCategoryDAO {
    private String name;
    private double price;
    private int totalNumber;
    private double score;
    private int lockedNumber = 0;
    private Connection connection;


    public RoomCategoryDAO() throws SQLException {
        this.name = null;
        this.price = 0;
        this.totalNumber = 0;
        this.connection = DBHGeneral.getConnection();
        this.score = 0;
    }

    //数据库增删查改
    //增
    public boolean addRoomCategory(String name, double price, int totalNumber, double score) throws SQLException {
        String sql = "INSERT  INTO RoomCategory VALUES (?,?,?,?,?) ";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,name);
        stm.setDouble(2,price);
        stm.setInt(3,totalNumber);
        stm.setDouble(4,score);
        stm.setInt(5,lockedNumber);
        int n =  stm.executeUpdate();
        return (n == 0 ? false : true);
    }


    //删

    //查
    public ArrayList<String> getAllCategory() throws SQLException {
        String sql = "SELECT name from RoomCategory";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        ArrayList<String> answer = new ArrayList<>();
        while (r.next()){
            answer.add(r.getString(1));
        }
        return answer;
    }
    public HashMap<String,Double> getTypeAndPrice() throws SQLException {
        String sql = "SELECT name,price from RoomCategory";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        HashMap<String,Double> answer = new HashMap<>();
        while (r.next()){
            answer.put(r.getString(1),r.getDouble(2));
        }
        return answer;
    }
    public ArrayList<RoomCategory> getRoomPreservationInitialize() throws SQLException {
        String sql = "SELECT name,totalNumber,lockedNumber from RoomCategory order by name ";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet r = stm.executeQuery();
        ArrayList<RoomCategory> answer = new ArrayList<>();
        while (r.next()){
            RoomCategory c = new RoomCategory();
            c.setName(r.getString(1));
            c.setTotalNumber(r.getInt(2));
            c.setLockedNumber(r.getInt(3));
            answer.add(c);
        }
        return answer;
    }

    //改


    //Getter And Setter


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getLockedNumber() {
        return lockedNumber;
    }

    public void setLockedNumber(int lockedNumber) {
        this.lockedNumber = lockedNumber;
    }
}
