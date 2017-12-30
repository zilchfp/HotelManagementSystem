package basicSetting;

import DAOHelper.DBHGeneral;
import DAOHelper.RoomCategoryDAO;
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
import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet("/basicSetting/RoomInformationQuery.do")
public class RoomInformationQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String IDOfSettingRoom = request.getParameter("IDOfSettingRoom");
        try {
            Connection connection = DBHGeneral.getConnection();
            RoomDAO helper = new RoomDAO(connection);
            Room resRoom = helper.roomQueryByID(IDOfSettingRoom);
            session.setAttribute("resultRoomOfSetting",resRoom);
            connection.close();

            //获取全部房间类型属性
            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
            ArrayList<String> allRoomType =  roomCategoryDAO.getAllCategory();
            request.setAttribute("allRoomType",allRoomType);

            RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/RoomInformationSetting.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.print(IDOfSettingRoom);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
