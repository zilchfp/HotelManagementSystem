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

@WebServlet("/basicSetting/CustomerAccountModify.do")
public class CustomerAccountModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIDModify = request.getParameter("userIDModify");
        String usernameModify = request.getParameter("usernameModify");
        String passwordModify = request.getParameter("passwordModify");
        String IDNumberModify = request.getParameter("IDNumberModify");
        String customerNameModify = request.getParameter("customerNameModify");

        try {
            Connection c = DBHGeneral.getConnection();

            if (!usernameModify.equals("")) {
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.updateUsername(usernameModify, userIDModify);
            } ;
            if (!passwordModify.equals("")) {
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.updatePassword(passwordModify, userIDModify);
            };
            if (!IDNumberModify.equals("")) {
                CustomerDAO customerDAO = new CustomerDAO();
                customerDAO.updateIDNumber(IDNumberModify, userIDModify);
            };

            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
