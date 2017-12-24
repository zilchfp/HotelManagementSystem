import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import DAOHelper.ReceptionistDAO;
import DAOHelper.RoomDBH;
import entity.Customer;

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
            ReceptionistDAO receptionistDAO = new ReceptionistDAO(c);
//            receptionist.setID(GeneralHelp.getRandomUserID());
//            receptionist.setGender("Femal");
//            receptionist.setName("Hello");
//            receptionist.setUsername("hellow");
//            receptionist.setPassword("xixixi");
            receptionistDAO.deleteByID("100010");


            OrdersDAO ordersDBH = new OrdersDAO(c);
//            Orders orders = new Orders();
//            orders.setRoomID("1");
//            orders.setCustomerID("1");
//            orders.setCustomerName("orders");
//            orders.setDateBegin("17-1-11");
//            orders.setDateEnd("17-1-15");
//            orders.setStatus("BOOKED");

            RoomDBH roomDBH = new RoomDBH(DBHGeneral.getConnection());

            Customer customer = new Customer("1");
            ResultSet resultSet = customer.getAllOrders();
            while (resultSet.next()) {
                out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
