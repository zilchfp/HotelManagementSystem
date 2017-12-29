package DAOHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {
    private String ID;
    private String username;
    private String password;
    private String name;
    private String gender;
    private Connection connection;

    public ManagerDAO(Connection connection) throws SQLException {
        this.ID = null;
        this.username = null;
        this.password = null;
        this.password = null;
        this.password = null;
        this.name = null;
        this.gender = null;
        this.connection = DBHGeneral.getConnection();
    }

    //查询
    public ResultSet queryManagerByUsernamePassword(String username, String password) throws SQLException {
        String sql = "select * from Manager where username=? and password=?;";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,username);
        stm.setString(2,password);
        return stm.executeQuery();
    };




    //Getter and Setter

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
