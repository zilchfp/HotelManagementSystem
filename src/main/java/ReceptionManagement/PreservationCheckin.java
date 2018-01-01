package ReceptionManagement;

import entity.Receptionist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet(name = "/ReceptionManagement/PreservationCheckin",urlPatterns = "/ReceptionManagement/PreservationCheckin")
public class PreservationCheckin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String orderIDCheckin = (String) session.getAttribute("orderIDCheckin");
        String bookedRoomID = request.getParameter("bookedRoomID");
        String message,nextURL;
        boolean checkinSuccessfully = false;

        if (bookedRoomID != null) {
            Receptionist receptionist = new Receptionist();
            try {
                checkinSuccessfully = receptionist.preservationCheckin(orderIDCheckin,bookedRoomID);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (checkinSuccessfully) {
                message = "入住成功！3秒后返回预定入住界面。";
            } else {
                message = "入住失败！请重试！3秒后返回预定入住界面。";
            }
        } else {
            message = "请选择入住的房间！3秒后返回预定入住界面。";
        }

        nextURL = "/receptionManagement/PreservationCheckin.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }
}
