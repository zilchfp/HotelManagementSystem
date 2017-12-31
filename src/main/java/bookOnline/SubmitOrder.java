package bookOnline;

import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import entity.Customer;
import entity.Orders;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SubmitOrder", urlPatterns = "/bookOnline/SubmitOrder.do")
public class SubmitOrder extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean submitSuccessfully = false;
        try {
            Customer customer = (Customer) session.getAttribute("LoginedCustomer");
            OrdersDAO ordersDAO = new OrdersDAO(DBHGeneral.getConnection());
            Orders orders = new Orders();
            orders.setCustomerID(customer.getUserID());
            orders.setCustomerName(customer.getCustomerName());
            orders.setDateBegin((String) session.getAttribute("dateBegin"));
            orders.setDateEnd((String) session.getAttribute("dateEnd"));
            orders.setStatus("预定");
            orders.setType((String) session.getAttribute("type"));
            submitSuccessfully = ordersDAO.addOrder(orders);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String message, nextURL;
        if (submitSuccessfully) {
            message = "预定成功！ 3秒后返回查询界面。";
        } else {
            message = "预定失败！ 请重试！ 3秒后返回查询界面。";
        }

        nextURL = "/bookOnline/RoomQuery.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);
    }
}
