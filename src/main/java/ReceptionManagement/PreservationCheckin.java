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

@WebServlet(name = "/ReceptionManagement/PreservationCheckin",urlPatterns = "/ReceptionManagement/PreservationCheckin")
public class PreservationCheckin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIDCheckin = request.getParameter("orderIDCheckin");

        Receptionist receptionist = new Receptionist();
        try {
            receptionist.preservationCheckin(orderIDCheckin);
            //TODO
            //跳转到入住成功
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(orderIDCheckin);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
