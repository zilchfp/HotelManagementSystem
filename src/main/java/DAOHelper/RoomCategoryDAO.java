package DAOHelper;

import ReceptionManagement.PreservationCheckin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoomCategoryDAO {
    private String name;
    private double price;
    private int totalNumber;
    private double score;
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
        String sql = "INSERT  INTO RoomCategory VALUES (?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,name);
        stm.setDouble(2,price);
        stm.setInt(3,totalNumber);
        stm.setDouble(4,score);
        int n =  stm.executeUpdate();
        return (n == 0 ? false : true);
    }


    //删

    //查

    //改动


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
}
