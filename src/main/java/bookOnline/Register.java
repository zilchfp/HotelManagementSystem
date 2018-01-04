package bookOnline;

import entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/bookOnline/Register.do")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String customerIDNumber = request.getParameter("customerIDNumber");
        String customerPassword = request.getParameter("password");
        String customerName = request.getParameter("customerName");
        boolean registerSuccessfully = false;
        String message,nextURL;
        try {
            Customer customer = new Customer(username, customerPassword, customerIDNumber,customerName);
            registerSuccessfully = customer.register();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (registerSuccessfully) {
            message = "注册成功！ 3秒后返回登录界面！";
            nextURL = "/CustomerLogin.jsp";
        } else {
            message = "注册失败！ 请重试！ 3秒后返回注册界面！";
            nextURL = "/bookOnline/Register.jsp?";
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
