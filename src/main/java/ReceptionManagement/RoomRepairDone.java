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

@WebServlet(name = "RoomRepairDone", urlPatterns = "/ReceptionManagement/RoomRepairDone.do")
public class RoomRepairDone extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomRepairDoneOfRoomID = request.getParameter("roomRepairDoneOfRoomID");
        Receptionist receptionist = new Receptionist();
        boolean repairSuccessfully = false;
        try {
            repairSuccessfully = receptionist.fixDoneByRoomID(roomRepairDoneOfRoomID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String message,nextURL;
        if (repairSuccessfully) {
            message = "房间状态设置成功！ 所选房间已可用！ 3秒后返回维修管理界面！";

        } else {
            message = "房间状态设置失败！ 请重试！3秒后返回维修管理界面！";

        }
        nextURL = "/receptionManagement/RepairManagement.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }

}
