package entity;

import DAOHelper.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Helper {

    public static void loginedCustomer(HttpServletRequest request, String customerID) throws SQLException {
        Customer LoginedCustomer = new Customer();
        CustomerDAO customerDAO = new CustomerDAO();
        LoginedCustomer = customerDAO.queryByUserID(customerID);
        HttpSession session = request.getSession();
        session.setAttribute("LoginedCustomer",LoginedCustomer);;
    }


    public static void loginInitializatjion(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<String> arrayListAllCustomerID =  customerDAO.getAllCustomersID();
        session.setAttribute("AllCustomerID",arrayListAllCustomerID);

        OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
        ArrayList<String> arrayListAllOrdersID =  ordersDAO.getAllOrdersID();
        session.setAttribute("AllOrdersID",arrayListAllOrdersID);

        RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
        ArrayList<String> arrayListAllRoomID = roomDAO.getAllRoomID();
        session.setAttribute("AllRoomID",arrayListAllRoomID);

        RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
        ArrayList<String> arrayListAllRoomType = roomCategoryDAO.getAllCategory();
        session.setAttribute("AllRoomType",arrayListAllRoomType);


        ReceptionistDAO receptionistDAO = new ReceptionistDAO(DBHGeneral.getConnection());
        ArrayList<String> arrayListReceptionistID = receptionistDAO.getAllReceptionistID();
        session.setAttribute("AllReceptionistID",arrayListReceptionistID);



    }
//TODO  需要检测生成的ID是否已经在表中
    public static String getRandomUserID () {
        Random randomGenerator = new Random();
        long n = 0;
        do {
            n = randomGenerator.nextLong();
        } while (n < 0);
        String s = String.valueOf(n);
        return s;
    }
}
