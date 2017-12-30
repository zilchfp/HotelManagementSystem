package basicSetting;

import DAOHelper.CustomerDAO;
import entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/basicSetting/CustomerAccountModifyID.do")
public class CustomerAccountModifyID extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIDModify = request.getParameter("queryRoomID");
        String message, nextURL;
        boolean querySuccessfully = false;
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            Customer oriCustomer = customerDAO.queryByUserID(userIDModify);
            if (oriCustomer == null) {
            } else {
                querySuccessfully = true;
                request.setAttribute("oriCustomer",oriCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (querySuccessfully) {
            RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/CustomerAccountModify.jsp");
            rd.forward(request, response);
        } else {
            nextURL = "/basicSetting/CustomerAccountModifyID.jsp";
            message = "无改ID的客户的相关信息，请重新查询！";
            request.setAttribute("nextURL", nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }


    }
}
