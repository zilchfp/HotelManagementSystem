package basicSetting;

import DAOHelper.*;
import entity.Helper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet(name = "ManagerLogin",urlPatterns = "/basicSetting/ManagerLogin.do")
public class ManagerLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean findManager = false;
        try {
            ManagerDAO managerDAO = new ManagerDAO(DBHGeneral.getConnection());
            ResultSet resultSet = managerDAO.queryManagerByUsernamePassword(username,password);
            while (resultSet.next()) {
                findManager = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String message, nextURL;
        if (findManager) {
            message = "经理账号登录成功！ 即将为您跳转至经理管理界面！";
            nextURL = "/basicSetting/Index.jsp";

            //对一些会话期间的参数进行初始化
            try {
                Helper.loginInitializatjion(request);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            message = "经理账号登录失败！ 即将为您跳转回登录界面！";
            nextURL = "/ManagerLogin.jsp";

        }

        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);

        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);

    }

}
