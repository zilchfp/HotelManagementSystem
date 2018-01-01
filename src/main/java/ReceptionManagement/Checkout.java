package ReceptionManagement;

import entity.Bill;
import entity.Receptionist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagemnt/Checkout.do")
public class Checkout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String RoomID = request.getParameter("checkoutRoomID");
        HttpSession session = request.getSession();
        out.println(RoomID);
        boolean checkoutSuccessfully = false;
        String message,nextURL;
        Receptionist receptionist = new Receptionist();
//        try {
//            if (true) {
//                checkoutSuccessfully = true;
//                String OrderID = "999";
//                Bill bill = receptionist.calculateBillByOrderID(OrderID);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            Bill bill = receptionist.getBillByRoomID(RoomID);
            if (bill != null) {
                String orderID = bill.getOrderID();
                boolean updateRoomStatusSuccessfully = receptionist.roomCheckout(RoomID);
                boolean dateEndMakesure = receptionist.updateOrderInformationByOrderID(orderID);
                boolean calculateAccount = receptionist.calculateBillByOrderID(orderID);
                checkoutSuccessfully = updateRoomStatusSuccessfully && dateEndMakesure && calculateAccount;
                session.setAttribute("checkoutBill",bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (checkoutSuccessfully) {
                message = "退房成功！ 3秒后显示账单。";
                nextURL = "/receptionManagement/CheckoutShowBill.jsp";
        } else {
            message = "退房失败！ 请重试！ 3秒后回到退房界面。";
            nextURL = "/receptionManagement/Checkout.jsp";
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
