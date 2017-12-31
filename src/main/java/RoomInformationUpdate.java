import DAOHelper.DBHGeneral;
import DAOHelper.RoomDAO;
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

@WebServlet(name = "RoomInformationUpdate",urlPatterns = "/basicSetting/RoomInformationUpdate.do")
public class RoomInformationUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Room room = (Room) session.getAttribute("resultRoomOfSetting");
        String roomID  = room.getID();
        String roomType  = request.getParameter("roomType");
        String roomFloor  = request.getParameter("roomFloor");
        String roomDirection  = request.getParameter("roomDirection");
        String roomDescription  = request.getParameter("roomDescription");
        String roomStatus  = request.getParameter("roomStatus");

        room.setType(roomType);
        room.setFloor(roomFloor);;
        room.setDirection(roomDirection);
        room.setDescription(roomDescription);
        room.setStatus(roomStatus);

        String message, nextURL;
        boolean successful = false;
        try {
            RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
            successful = (roomDAO.updateRoomInformation(room) == true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (successful) {
            message = "房间信息更新成功! 3秒后返回客房信息设置页.";
        } else {
            message = "房间信息更新失败! 请重试! 3秒后返回客房信息设置页.";
        }
        nextURL = "/basicSetting/RoomInformationSettingID.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }

}
