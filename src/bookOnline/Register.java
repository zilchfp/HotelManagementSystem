package bookOnline;

import DBHelper.CustomerDBH;
import DBHelper.DBHGeneral;
import entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/bookOnline/Register.do")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        String customerID = request.getParameter("customerID");
        String customerPassword = request.getParameter("customerPassword");

        try {
            Customer customer = new Customer(customerName, customerPassword, customerID);
            customer.register();
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("注册失败");
        }

        out.println("注册成功");
        RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/RegisterSuccess.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
