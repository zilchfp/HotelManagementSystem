package bookOnline;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date begin = null;
        try {
            begin = sdf.parse(dateBegin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date end = null;
        try {
            end = sdf.parse(dateEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (begin.before(end)) {
            System.out.println("succ ");
        }


        RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/RoomQueryResult.jsp");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
