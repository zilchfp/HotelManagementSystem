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

        /*
        * 创建时间：12.7
        * 暂时不对数据库表进行设计，简单地将所有属性放在一个表中进行处理
        */
        //setup DB connection

        boolean findCustomer = false;
        Connection conn;
        HttpSession session = request.getSession();

        try {
            //数据库查询
            conn = DBHGeneral.getConnection();
            CustomerDBH helper = new CustomerDBH(conn);

            String sql = "select * from Customer where username = ?";
            helper.setUsername(request.getParameter("nameCustomerLogin"));
            ResultSet res = helper.Query(sql);

            String passwordCustomerLogin = request.getParameter("passwordCustomerLogin");

            //查询结果处理
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
