package basicSetting;

import DAOHelper.RoomCategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RoomTypeSetting" ,urlPatterns = "/basicSetting/RoomTypeSetting.do")
public class RoomTypeSetting extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String NameOfCategory =request.getParameter("NameOfCategory");
        double PriceOfCategory = Double.parseDouble(request.getParameter("PriceOfCategory"));
        int totalNumberOfCategory = Integer.parseInt(request.getParameter("totalNumberOfCategory"));
        double scoreOfCategory = Double.parseDouble(request.getParameter("scoreOfCategory"));

        boolean addSuccessfully = false;
        String nextURL,message;
        try {
            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAO();
            addSuccessfully = roomCategoryDAO.addRoomCategory(NameOfCategory,PriceOfCategory,totalNumberOfCategory,scoreOfCategory);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (addSuccessfully) {
            message = "房间类型添加成功！ 3秒后返回客房类型设置页面。";
        } else {
            message = "房间类型添加失败！ 请重试！ 3秒后返回客房类型设置页面。";
        }
        nextURL = "/basicSetting/RoomTypeSetting.jsp";

        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);
        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);
    }

}
