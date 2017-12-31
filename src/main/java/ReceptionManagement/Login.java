package ReceptionManagement;

import DAOHelper.DBHGeneral;
import DAOHelper.ReceptionistDAO;
import entity.GeneralHelp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Login", urlPatterns = "/receptionManagement/Login.do")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receptionistName = request.getParameter("receptionistName");
        String receptionistPassword = request.getParameter("receptionistPassword");

        String message, nextURL;
        boolean LoginSuccessfully = false;

        try {
            ReceptionistDAO receptionistDAO = new ReceptionistDAO(DBHGeneral.getConnection());
            ResultSet resultSet = receptionistDAO.queryReceptionistByUsernamePassword(receptionistName,receptionistPassword);
            while (resultSet.next()) {
                LoginSuccessfully = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (LoginSuccessfully) {
            try {
                GeneralHelp.loginInitializatjion(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            message = "欢迎您! 接待员账号登录成功! 即将为您跳转至接待员管理界面.";
            nextURL = "/receptionManagement/Index.jsp";
        } else {
            message = "接待员账号或密码错误! 3秒后跳转至接待员登录界面!";
            nextURL = "/ReceptionistLogin.jsp";
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
