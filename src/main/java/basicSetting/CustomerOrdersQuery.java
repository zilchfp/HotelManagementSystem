package basicSetting;

import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import entity.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet("/basicSetting/CustomerOrdersQuery.do")
public class CustomerOrdersQuery extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IDOfCustomerRoomQuery = request.getParameter("IDOfCustomerRoomQuery");
        HttpSession session = request.getSession();
        boolean hasOrders = false;
        try {
            OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
            ResultSet resultSet = ordersDBH.queryByCustomerID(IDOfCustomerRoomQuery);
            ArrayList<Orders> ordersArrayList = ordersDBH.resultSetToArrayList(resultSet);
            if (ordersArrayList.size() != 0) {
                out.println("orderArryList is not null");
                hasOrders = true;
                request.setAttribute("CustomerOrdersQueryResult", ordersArrayList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (hasOrders) {
            RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/CustomerOrdersQueryResult.jsp");
            rd.forward(request, response);
        } else {
            String message = "没有该客户订单的相关信息。3秒后返回订单查询界面。";
            String nextURL = "/basicSetting/CustomerOrdersQuery.jsp";
            request.setAttribute("nextURL",nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }
    }
}
