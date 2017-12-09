package ReceptionManagement;

import DBHelper.DBHInitialize;
import DBHelper.ReceptionistDBH;
import DBHelper.RoomDBH;
import entity.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ReceptionManagemnt/Checkout.do")
public class Checkout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roomID = request.getParameter("checkoutRoomID");

        Receptionist receptionist = new Receptionist();
        try {
            receptionist.roomCheckout(roomID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
