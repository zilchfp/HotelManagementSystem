package basicSetting;

import entity.Customer;
import entity.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerAccountAdd",urlPatterns = "/basicSetting/CustomerAccountAdd.do")
public class CustomerAccountAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerUsernameAdd = request.getParameter("customerUsernameAdd");
        String customerPasswordAdd = request.getParameter("customerPasswordAdd");
        String customerIDNumberAdd = request.getParameter("customerIDNumberAdd");
        String customerNameAdd = request.getParameter("customerNameAdd");

        Customer customer = new Customer(customerUsernameAdd, customerPasswordAdd, customerIDNumberAdd, customerNameAdd);
        Manager manager = new Manager();
        boolean addFlag = false;
        String message, nextURL;
        try {
            addFlag = manager.addCustomerAccount(customer);

        } catch (SQLException e) {
            addFlag = false;
            e.printStackTrace();
        }

        if (addFlag) {
            message = "操作成功！3秒后跳转到客户账号管理界面。";
            nextURL  = "/basicSetting/CustomerSetting.jsp";
        } else {
            message = "操作失败！3秒后返回到客户账号添加界面。";
            nextURL = "/basicSetting/CustomerAccountAdd.jsp";
        }
        request.setAttribute("message",message);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("nextURL",nextURL);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/General/intermediatePage.jsp");
        requestDispatcher.forward(request,response);
    }
}
