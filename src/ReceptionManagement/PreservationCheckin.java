package ReceptionManagement;

import entity.Receptionist;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagement/PreservationCheckin")
public class PreservationCheckin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String checkInID = request.getParameter("orderIDCheckin");

        Receptionist receptionist = new Receptionist();
        try {
            receptionist.preservationCheckin(checkInID);
            //TODO
            //跳转到入住成功
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println(checkInID);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
