package entity;

import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import DAOHelper.RoomDAO;

import java.sql.SQLException;

public class Receptionist {
    private String ID;
    private String name;
    private String gender;
    private String username;
    private String password;


    //前台管理
    public void preservationCheckin(String orderID) throws SQLException {
        OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
        ordersDBH.updateStatusByOrderID(orderID,"LIVING");
    }
    public void roomCheckout(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        roomDAO.updateStatusByRoomID(roomID, "AVALIABLE");

        //TODO SHOW BILLS
    }

    public void changeRoomByOrderID(String orderID, String newRoomID) throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        ordersDAO.singleUpdate("roomID",newRoomID,"OrderID",orderID);
    }

    public void changeRoomNumber(String roomID, String roomNumber) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        roomDAO.updateRoomNumberByRoomID(roomID, roomNumber);
    }

    public boolean extendCheckoutTimeByOrderID(String OrderID, String newDateEnd) throws SQLException {
        OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
        return ordersDBH.updateDateEndByOrderID(OrderID, newDateEnd);
    }

    public void fixingRoomByRoomID(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        roomDAO.updateStatusByRoomID(roomID,"FIXING");
    }

    public void fixDoneByRoomID(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        roomDAO.updateStatusByRoomID(roomID,"AVAILABLE");
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
}
