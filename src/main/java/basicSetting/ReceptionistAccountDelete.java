package basicSetting;

import DAOHelper.DBHGeneral;
import DAOHelper.ReceptionistDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/basicSetting/ReceptionistAccountDelete.do")
public class ReceptionistAccountDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String receptionistIDDelete = request.getParameter("receptionistIDDelete");
        boolean deleteSuccessfully = false;
        try {
            Connection c = DBHGeneral.getConnection();
            ReceptionistDAO receptionistDAO = new ReceptionistDAO(c);
            deleteSuccessfully = receptionistDAO.DeleteByID(receptionistIDDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String message,nextURL;
        if (deleteSuccessfully) {
            message = "删除成功！ 3秒后返回接待员账号管理界面。";
            nextURL = "/basicSetting/ReceptionistSetting.jsp";
        } else {
            message = "删除失败！ 请重试！ 3秒返回接待员账号删除界面。";
            nextURL = "/basicSetting/ReceptionistAccountDelete.jsp";
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
