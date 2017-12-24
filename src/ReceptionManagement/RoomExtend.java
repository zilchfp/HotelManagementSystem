package ReceptionManagement;

import entity.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagement/RoomExtend")
public class RoomExtend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIDExtend = request.getParameter("orderIDExtend");
        String DateEndExtend = request.getParameter("DateEndExtend");
        out.println(DateEndExtend);
        Receptionist receptionist = new Receptionist();
        try {
            receptionist.extendCheckoutTimeByOrderID(orderIDExtend,DateEndExtend);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
