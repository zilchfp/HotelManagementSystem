package basicSetting;

import entity.Manager;
import entity.Receptionist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/basicSetting/ReceptionistAccountAdd.do")
public class ReceptionistAccountAdd extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean addSuccessfully = false;
        String message,nextURL;
        String receptionistUsernameAdd = request.getParameter("receptionistUsernameAdd");
        String receptionistPasswordAdd = request.getParameter("receptionistPasswordAdd");
        String receptionistNameAdd = request.getParameter("receptionistNameAdd");
        String receptionistGenderAdd = request.getParameter("receptionistGenderAdd");
        Receptionist receptionist = new Receptionist();
        receptionist.setUsername(receptionistUsernameAdd);
        receptionist.setPassword(receptionistPasswordAdd);
        receptionist.setName(receptionistNameAdd);
        receptionist.setGender(receptionistGenderAdd);


        Manager manager = new Manager();
        try {
            addSuccessfully = manager.addReceptionist(receptionist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (addSuccessfully) {
            message = "接待员账号添加成功！ 3秒后返回接待员账号管理界面。";
            nextURL = "/basicSetting/ReceptionistSetting.jsp";
        } else {
            message = "接待员账号添加失败！ 请重试！ 3秒后返回接待员账号管理界面。";
            nextURL = "/basicSetting/ReceptionistAccountAdd.jsp";
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
