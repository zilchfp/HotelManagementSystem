package bookOnline;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;
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

import static java.lang.System.out;

@WebServlet("/bookOnline/Login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean findCustomer = false;
        Connection conn;
        HttpSession session = request.getSession();
        String nextURL = "", message = "";
        try {
            String username = request.getParameter("nameCustomerLogin");
            //数据库查询
            conn = DBHGeneral.getConnection();
            CustomerDAO helper = new CustomerDAO(conn);
            ResultSet res = helper.getAllCustomers();

            //查询结果处理
            String passwordCustomerLogin = request.getParameter("passwordCustomerLogin");
//            out.println("name:"+username+"  password:"+passwordCustomerLogin);

            while (res.next()) {
                String resPassword = res.getString("password");
                boolean passwordIsRight = passwordCustomerLogin.equals(resPassword);
                if (passwordIsRight) {
                    Customer customer = new Customer(res);
                    session.setAttribute("LoginCustomer",customer);
                    customer.loginInitialize(request, response);

                    nextURL = "/bookOnline/Index.jsp";
                    message = "登录成功!欢迎您!即将为你跳转至主页。";
                }
            }
            conn.close();
        } catch (SQLException e) {
            nextURL = "/CustomerLogin.jsp";
            message = "登录失败!账号或密码错误!3秒后跳转回登录界面";
            e.printStackTrace();
        }
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);

        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
