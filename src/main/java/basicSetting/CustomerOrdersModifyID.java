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
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "CustomerOrdersModifyID" ,urlPatterns = "/basicSetting/CustomerOrdersModifyID.do")
public class CustomerOrdersModifyID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String IDOfOrderRoomModify = request.getParameter("IDOfOrderRoomModify");

        Orders queryOrder = new Orders();
        try {
            OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
            ResultSet resultSet = ordersDAO.queryByOrderID(IDOfOrderRoomModify);
            while (resultSet.next()) {
                queryOrder.setOrderID(resultSet.getString(1));
                queryOrder.setRoomID(resultSet.getString(2));
                queryOrder.setCustomerID(resultSet.getString(3));
                queryOrder.setCustomerName(resultSet.getString(4));
                queryOrder.setDateBegin(resultSet.getString(5));
                queryOrder.setDateEnd(resultSet.getString(6));
                queryOrder.setStatus(resultSet.getString(7));
                queryOrder.setType(resultSet.getString(8));
            }

            request.setAttribute("queryOrder",queryOrder);
            RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/CustomerOrdersModifyResult.jsp");
            rd.forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
