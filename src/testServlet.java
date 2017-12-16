import DBHelper.DBHGeneral;
import DBHelper.OrdersDBH;
import DBHelper.ReceptionistDBH;
import entity.GeneralHelp;
import entity.Orders;
import entity.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Connection c = DBHGeneral.getConnection();
            ReceptionistDBH receptionistDBH = new ReceptionistDBH(c);
//            receptionist.setID(GeneralHelp.getRandomUserID());
//            receptionist.setGender("Femal");
//            receptionist.setName("Hello");
//            receptionist.setUsername("hellow");
//            receptionist.setPassword("xixixi");
            receptionistDBH.DeleteByID("100010");


            OrdersDBH ordersDBH = new OrdersDBH(c);
            Orders orders = new Orders();
            orders.setRoomID("1");
            orders.setCustomerID("1");
            orders.setCustomerName("orders");
            orders.setDateBegin("12-10-11");
            orders.setDateEnd("12-11-12");
            orders.setStatus("BOOKED");
            //ordersDBH.AddOrder(orders);
            //            ordersDBH.DeleteByID("406537966173648292");
            ResultSet resultSet = ordersDBH.QueryByID("3066393220243293899");
            while (resultSet.next()) {
                out.println(resultSet.getString(1));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
