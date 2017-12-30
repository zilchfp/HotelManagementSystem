package basicSetting;

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

import static java.lang.System.out;

@WebServlet(name = "RoomPreservationAdd",urlPatterns = "/basicSetting/RoomPreservationAdd.do")
public class RoomPreservationAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<RoomCategory> roomCategoryArrayList = new ArrayList<>();
        String[] typeName =request.getParameterValues("addLockedNumber");
        for (int i = 0; i < typeName.length; i++) {
            out.println(typeName[i]);
        }
//        try {
//            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
//            roomCategoryArrayList = roomCategoryDAO.getRoomPreservationInitialize();
//            request.setAttribute("roomCategoryArrayList",roomCategoryArrayList);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/RoomPreservation.jsp");
//        rd.forward(request,response);
    }
}
