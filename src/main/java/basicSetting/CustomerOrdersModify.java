package basicSetting;

import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import entity.Orders;

import javax.persistence.criteria.Order;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet(name = "CustomerOrdersModify" ,urlPatterns = "/basicSetting/CustomerOrdersModify.do")
public class CustomerOrdersModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderID = request.getParameter("orderID");
        String roomID = request.getParameter("roomID");
        String customerID = request.getParameter("customerID");
        String customerName = request.getParameter("customerName");
        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");
        String roomType = request.getParameter("roomType");
        String orderStatus = request.getParameter("orderStatus");

        String message, nextURL;
        boolean updateSuccessfully = false;
        try {

            Orders orders = new Orders();
                orders.setOrderID(orderID);
                orders.setRoomID(roomID);
                orders.setCustomerID(customerID);
                orders.setCustomerName(customerName);
                orders.setDateBegin(dateBegin);
                orders.setDateEnd(dateEnd);
                orders.setType(roomType);
                orders.setStatus(orderStatus);
            OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
            updateSuccessfully =  ordersDAO.updateOrderByID(orderID,orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (updateSuccessfully) {
            message = "订单信息修改成功！ 3秒后重新返回订单管理界面。";
            nextURL = "/basicSetting/BookManagement.jsp";
        } else {
            message = "订单信息修改失败！ 请重试！ 3秒后重新返回订单修改界面。";
            nextURL = "/basicSetting/CustomerOrdersModify.jsp";
        }
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);

        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }
}
