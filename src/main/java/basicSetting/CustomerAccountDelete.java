package basicSetting;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;

import javax.servlet.RequestDispatcher;
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
        String message, nextURL;
        boolean deleteFlag = false;
        try {
            Connection c = DBHGeneral.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(c);
            deleteFlag = customerDAO.deleteByUserID(customerIDDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (deleteFlag) {
            message = "删除操作成功!3秒后返回客户账号管理界面。";
            nextURL = "/basicSetting/CustomerSetting.jsp";
        } else {
            message = "删除操作失败! 无对应的客户账号ID! 请重试!";
            nextURL = "/basicSetting/CustomerAccountDelete.jsp";
        }

        request.setAttribute("message",message);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("nextURL",nextURL);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/General/intermediatePage.jsp");
        requestDispatcher.forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
