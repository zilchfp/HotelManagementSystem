package basicSetting;

import DAOHelper.DBHGeneral;
import DAOHelper.RoomCategoryDAO;
import entity.RoomCategory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "RoomPreservationInitialize",urlPatterns = "/basicSetting/RoomPreservationInitialize.do")
public class RoomPreservationInitialize extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
            ArrayList<RoomCategory>  roomCategoryArrayList = roomCategoryDAO.getRoomPreservationInitialize();
            request.setAttribute("roomCategoryArrayList",roomCategoryArrayList);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/RoomPreservation.jsp");
        rd.forward(request,response);
    }
}
