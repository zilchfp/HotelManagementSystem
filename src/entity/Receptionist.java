package entity;

import DBHelper.DBHInitialize;
import DBHelper.RoomDBH;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Receptionist {
    private String ID;
    private String name;
    private String gender;


    public void roomCheckout(String roomID) throws SQLException {
        Connection c = DBHInitialize.getConnection();
        RoomDBH helper = new RoomDBH(c);
        helper.checkout(roomID);
    }


    //GETTER AND SETTER
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
