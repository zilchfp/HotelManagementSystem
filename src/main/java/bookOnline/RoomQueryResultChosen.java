package bookOnline;

import DAOHelper.RoomCategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@WebServlet(name = "RoomQueryResultChosen", urlPatterns = "/bookOnline/RoomQueryResultChosen.do")
public class RoomQueryResultChosen extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String chosedRoomType = request.getParameter("booked");
        String message,nextURL;
        HashMap<String,Integer> AvailableQueryResult = (HashMap<String, Integer>) session.getAttribute("AvailableQueryResult");
        int numChosed = AvailableQueryResult.get(chosedRoomType);
        if (numChosed == 0) {
            message = "该房间类型已售空，请选择其他类型的房间，3秒后返回可用房间查询界面。";
            nextURL = "/bookOnline/RoomQuery.jsp";
            request.setAttribute("nextURL",nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }

        try {
            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
            HashMap<String,Double> typeAndPrice = roomCategoryDAO.getTypeAndPrice();
            for (Map.Entry<String,Double> entry : typeAndPrice.entrySet()) {
                if (entry.getKey().equals(chosedRoomType)) {
                    session.setAttribute("type",entry.getKey());
                    session.setAttribute("price",entry.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Customer Information




        RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/BookRoom.jsp");
        rd.forward(request,response);
    }

}
