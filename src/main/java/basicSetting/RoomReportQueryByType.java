package basicSetting;

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
import java.util.ArrayList;

@WebServlet(name = "RoomReportQueryByType", urlPatterns = "/basicSetting/RoomReportQueryByType.do")
public class RoomReportQueryByType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roomTypeOfQuerying = request.getParameter("roomTypeOfQuerying");
        boolean hasResult = false;
        String message = "", nextURL;
        try {
            RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
            ArrayList<Room> roomQueryResultByType = roomDAO.getAllRoomByType(roomTypeOfQuerying);
            if ((roomQueryResultByType != null) && (roomQueryResultByType.size() > 0)) {
                hasResult = true;
                session.setAttribute("roomQueryResultByType",roomQueryResultByType);
                message = "正在查询，请稍后。";
            } else {
                if (roomQueryResultByType == null) {
                    message = "操作失败！请重试。3秒后返回房态统计界面。";
                }
                if (roomQueryResultByType.size() == 0) {
                    message = "查询结果为空。3秒后返回房态统计界面。";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (hasResult) {
            nextURL = "/basicSetting/RoomReportResult.jsp";
            request.setAttribute("intermediateTimer",1);
        } else {
            nextURL = "/basicSetting/RoomReport.jsp";
            request.setAttribute("intermediateTimer",3);
        }
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);
    }
}
