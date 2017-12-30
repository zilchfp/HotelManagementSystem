package bookOnline;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;
import DAOHelper.RoomDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@WebServlet(name = "RoomQuery", urlPatterns = "/bookOnline/RoomQuery.do")
public class RoomQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Date formate : "yyyy-mm-dd"
        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");

        //Check the validation of the range of date
        if (dateBegin.compareTo(dateEnd) > 0) {
            String nextURL = null, message = null;
            nextURL = "/bookOnline/RoomQuery.jsp";
            message = "输入日期范围非法！ 请重新输入！ 3秒后跳转回可用房查询界面";

            request.setAttribute("nextURL",nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }

        //QueryRoom
        Connection connection = null;
        try {
            connection = DBHGeneral.getConnection();
            RoomDAO roomDAO = new RoomDAO(connection);
            //从房间表获得原有的各类型的房间数量
            HashMap<String,Integer> originalNumberOfType = roomDAO.getAllRoomTypeWithNumber();

            //因为顾客与在住房间一一对应,故通过客户表获得在住的不可用的各类型的房间数量
            CustomerDAO customerDAO = new CustomerDAO();
            HashMap<String, Integer> unavailableNumberofType =customerDAO.getUnavailableRoomTypeWithNumber();

            //用各类型的总房间数减去该时间段各类型不可用的房间数,即可求出该时间段各类型可用的房间数
            for (Map.Entry<String, Integer> entry : unavailableNumberofType.entrySet()) {
                String type = entry.getKey();
                Integer num = entry.getValue();
                if (originalNumberOfType.containsKey(type)) {
                    originalNumberOfType.put(type, originalNumberOfType.get(type) - num);
                }
            }
            request.setAttribute("AvailableQueryResult",originalNumberOfType);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/RoomQueryResult.jsp");
        rd.forward(request,response);
    }
}
