package bookOnline;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        Connection connection = null;
        try {
            connection = DBHGeneral.getConnection();
            RoomDAO roomDAO = new RoomDAO(connection);
            //获得原有的各类型的房间数量
            HashMap<String,Integer> originalNumberOfType = roomDAO.getRoomTypeWithNumber();
            for (Map.Entry<String, Integer> entry : originalNumberOfType.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                out.println(key + "  " + value);
            }
            //用各类型的总房间数减去该时间段各类型不可用的房间数,即可求出该时间段各类型可用的房间数
            ResultSet resultSet = roomDAO.getRoomUnavailableBetween(dateBegin,dateEnd);
            HashMap<String,String> typeAndNumber = new HashMap<>();
            while (resultSet.next()) {
                String number = resultSet.getString(1);
                Integer num = Integer.valueOf(number);
                String type = resultSet.getString(2);
                Integer object = originalNumberOfType.get(type);
                num = object - num;
                number = num.toString();
                typeAndNumber.put(type,number);
            }
            request.setAttribute("AvailableQueryResult",typeAndNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/RoomQueryResult.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
