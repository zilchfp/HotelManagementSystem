package entity;

import DBHelper.DBHGeneral;
import DBHelper.RoomDBH;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

public class Receptionist {
    private String ID;
    private String name;
    private String gender;


    public void roomCheckout(String roomID) throws SQLException {
        Connection c = DBHGeneral.getConnection();
        RoomDBH helper = new RoomDBH(c);
        helper.checkout(roomID);
    }

    //PRIVATE MEMBER



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