package bookOnline;

import DAOHelper.DBHGeneral;

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

@WebServlet(name = "RoomQuery", urlPatterns = "/bookOnline/RoomQuery.do")
public class RoomQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");

//        System.out.println(dateBegin);
//        System.out.println(dateEnd);
//        2017-12-07         2017-12-08

        // TO DO
        //这里的查询需要连接表进行筛选

//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date begin = null;
//        try {
//            begin = sdf.parse(dateBegin);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date end = null;
//        try {
//            end = sdf.parse(dateEnd);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        if (begin.before(end)) {
//            out.println("succ ");
//        }
//
//        try {
//            Connection connection = DBHGeneral.getConnection();
//            String sql =
////                    "SELECT * FROM Room WHERE "
//                    "SELECT * " +
//                            "FROM "+
//                         "(select Orders.dateBegin,Orders.dateEnd from Orders left join Room " +
//                         "on Room.ID=Orders.roomID " +
//                         "where Orders.status='FINISHED' or Orders.status='BOOKED' " +
//                         "order by dateBegin,dateEnd)" +
//                            "WHERE dateEnd<'14-11-11';";
//         //   select Orders.dateBegin,Orders.dateEnd from Orders left join Room on Room.ID= Orders.roomID where Orders.status='FINISHED' or Orders.status='BOOKED' order by dateBegin,dateEnd;
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet resultSet = stm.executeQuery();
//            while (resultSet.next()) {
//                out.println(resultSet.getString(1));
//                out.println(resultSet.getString(2));
////                out.println(resultSet.getString(3));
////                out.println(resultSet.getString(4));
////                out.println(resultSet.getString(5));
////                out.println(resultSet.getString(6));
////                out.println(resultSet.getString(7));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


        Connection connection = null;
        try {
            connection = DBHGeneral.getConnection();
            String sql ="select count(type),type from Room group by type";

            PreparedStatement stm = null;
            stm = connection.prepareStatement(sql);
            ResultSet resultSet = stm.executeQuery();
            ArrayList<Integer> numberList = new ArrayList<>();
            ArrayList<String> typeList = new ArrayList<>();
            HashMap<String,String> typeAndNumber = new HashMap<>();
            while (resultSet.next()) {
                String number = resultSet.getString(1);
                String type = resultSet.getString(2);
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
