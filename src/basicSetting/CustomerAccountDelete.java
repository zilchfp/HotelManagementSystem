package basicSetting;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/basicSetting/CustomerAccountDelete.do")
public class CustomerAccountDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerIDDelete = request.getParameter("customerIDDelete");

        try {
            Connection c = DBHGeneral.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(c);
            customerDAO.deleteByUserID(customerIDDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
