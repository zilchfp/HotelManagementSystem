package ReceptionManagement;

import entity.Receptionist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagement/RoomExtend")
public class RoomExtend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderIDExtend = request.getParameter("orderIDExtend");
        String DateEndExtend = request.getParameter("DateEndExtend");
        String nextURL, message;
        boolean extendSuccessfully = false;

        if (DateEndExtend != null) {
            Receptionist receptionist = new Receptionist();
            try {
                extendSuccessfully = receptionist.extendCheckoutTimeByOrderID(orderIDExtend,DateEndExtend);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (extendSuccessfully) {
                message = "续住成功! 3秒后跳转至续住管理界面";
            } else {
                message = "续住失败! 请重试! 3秒后跳转至续住管理界面";
            }
        } else {
            message = "请选择";
        }
        nextURL = "/receptionManagement/RoomExtend.jsp";
        request.setAttribute("nextURL",nextURL);
        request.setAttribute("intermediateTimer",3);
        request.setAttribute("message",message);

        RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
