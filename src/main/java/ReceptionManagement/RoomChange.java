package ReceptionManagement;

import entity.Receptionist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagement/RoomChange.do")
public class RoomChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIDChangeRoom = request.getParameter("orderIDChangeRoom");
        String roomChangeOfRoomID = request.getParameter("roomChangeOfRoomID");
        String  message,nextURL;
        boolean changeRoomSuccessfully = false;

        out.println(orderIDChangeRoom+"  "+roomChangeOfRoomID);
        Receptionist receptionist = new Receptionist();
        try {
            changeRoomSuccessfully = receptionist.changeRoomByOrderID(orderIDChangeRoom, roomChangeOfRoomID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (changeRoomSuccessfully) {
            message = "换房成功！ 3秒后返回换房页面。";
        } else {
            message = "换房失败！ 3秒后返回换房页面。";
        }
        nextURL = "/receptionManagement/RoomChange.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }
}
