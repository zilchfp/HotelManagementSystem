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
        try {
            OrdersDAO ordersDBH = new OrdersDAO(DBHGeneral.getConnection());
            ResultSet resultSet = ordersDBH.queryByCustomerID(IDOfCustomerRoomQuery);
            ArrayList<Orders> ordersArrayList = ordersDBH.resultSetToArrayList(resultSet);
            request.setAttribute("CustomerOrdersQueryResult", ordersArrayList);
            out.println(ordersArrayList.get(1).getCustomerID());
            out.println(ordersArrayList.get(1).getOrderID());
            RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/CustomerOrdersQueryResult.jsp");
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
