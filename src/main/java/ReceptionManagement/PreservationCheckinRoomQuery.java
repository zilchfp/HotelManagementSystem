package ReceptionManagement;

import entity.Receptionist;
import entity.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet(name = "/ReceptionManagement/PreservationCheckinRoomQuery" ,
        urlPatterns = "/ReceptionManagement/PreservationCheckinRoomQuery.do")
public class PreservationCheckinRoomQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String orderIDCheckin = request.getParameter("orderIDCheckin");
        boolean querySuccessfully = false;
        String message,nextURL;
        Receptionist receptionist = new Receptionist();
        try {
            ArrayList<Room> availableRoomQueryResult = receptionist.preservationCheckinRoomQuery(orderIDCheckin);

            if (availableRoomQueryResult != null) {
                querySuccessfully = true;
                request.setAttribute("AvailableQueryResult",availableRoomQueryResult);
                session.setAttribute("orderIDCheckin",orderIDCheckin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (querySuccessfully) {
            RequestDispatcher rd = request.getRequestDispatcher("/receptionManagement/PreservationCheckinRoomQueryResult.jsp");
                    rd.forward(request,response);
        } else {
            message = "查询失败，请重试。3秒后返回预定入住界面。";
            nextURL = "/receptionManagement/PreservationCheckin.jsp";

            request.setAttribute("nextURL",nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
