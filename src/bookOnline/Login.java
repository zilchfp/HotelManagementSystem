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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/bookOnline/Login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean findCustomer = false;
        Connection conn;
        HttpSession session = request.getSession();

        try {
            String username = request.getParameter("nameCustomerLogin");
            //数据库查询
            conn = DBHGeneral.getConnection();
            CustomerDBH helper = new CustomerDBH(conn);
            ResultSet res = helper.QueryByUsername(username);

            //查询结果处理
            String passwordCustomerLogin = request.getParameter("passwordCustomerLogin");
            while (res.next()) {
                String resPassword = res.getString("password");
                boolean passwordIsRight = passwordCustomerLogin.equals(resPassword);
                if (passwordIsRight) {
                    Customer customer = new Customer(res);
                    session.setAttribute("customer",customer);
                    customer.LoginInitialize(request, response);
                    findCustomer = true;
                    RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/LoginSuccess.jsp");
                    rd.forward(request, response);
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!findCustomer) {
            RequestDispatcher rd = request.getRequestDispatcher("/bookOnline/LoginFail.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
