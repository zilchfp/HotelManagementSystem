package entity;

import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import DAOHelper.RoomDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Receptionist {
    private String ID;
    private String name;
    private String gender;
    private String username;
    private String password;


    //前台管理
    public boolean preservationCheckin(String orderID, String roomID) throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        boolean updateStatusSuccessfully = ordersDAO.updateStatusByOrderID(orderID,"在住");
        boolean updateRoomIDSuccessfully = ordersDAO.updateRoomIDByOrderID(orderID,roomID);
        return (updateRoomIDSuccessfully && updateStatusSuccessfully);
    }

    public ArrayList<Room> preservationCheckinRoomQuery(String orderID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        return roomDAO.getAvailableRoomByOrdersID(orderID);
    }


    //CHECKOUT
    public boolean roomCheckout(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        return roomDAO.updateStatusByRoomID(roomID, "可用");
    }
    public boolean calculateBillByOrderID(String orderID) throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        return ordersDAO.updateOrderAccountByID(orderID);
    }

    public Bill getBillByRoomID(String roomID) throws SQLException {
        String sql ="SELECT Orders.customerID, Orders.customerName, " +
                    "       Orders.OrderID,Room.ID,Room.number," +
                    "       Room.type,Room.floor, " +
                    "       Orders.dateBegin, Orders.dateEnd " +
                    "FROM Orders " +
                    "LEFT JOIN Room " +
                    "ON Orders.roomID = Room.ID " +
                    "WHERE Orders.status = '在住'  AND roomID = ? ";
        Connection connection = DBHGeneral.getConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1,roomID);
        ResultSet r = stm.executeQuery();
        Bill bill = new Bill();
        while (r.next()) {
            bill.setCustomerID(r.getString("customerID"));
            bill.setCustomerName(r.getString("customerName"));
            bill.setOrderID(r.getString("OrderID"));
            bill.setID(r.getString("ID"));
            bill.setType(r.getString("type"));
            bill.setFloor(r.getString("floor"));
            bill.setDateBegin(r.getString("dateBegin"));
            bill.setDateEnd(r.getString("dateEnd"));
            bill.setRoomNumber(r.getString("number"));
        }
        return bill;
    }

    public boolean changeRoomByOrderID(String orderID, String newRoomID) throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        return ordersDAO.singleUpdate("roomID",newRoomID,"OrderID",orderID);
    }

    public boolean updateOrderInformationByOrderID(String orderID) throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String nowDate = dateFormat.format(date);
        return (ordersDAO.updateDateEndByOrderID(orderID,nowDate)
                && ordersDAO.updateStatusByOrderID(orderID,"退房"));

    }




    public void changeRoomNumber(String roomID, String roomNumber) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        roomDAO.updateRoomNumberByRoomID(roomID, roomNumber);
    }

    public boolean extendCheckoutTimeByOrderID(String OrderID, String newDateEnd) throws SQLException {
        OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
        return ordersDBH.updateDateEndByOrderID(OrderID, newDateEnd);
    }

    public boolean fixingRoomByRoomID(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        return roomDAO.updateStatusByRoomID(roomID,"维修中");
    }

    public boolean fixDoneByRoomID(String roomID) throws SQLException {
        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        return  roomDAO.updateStatusByRoomID(roomID,"可用");
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
