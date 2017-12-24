import DAOHelper.DBHGeneral;
import DAOHelper.OrdersDAO;
import DAOHelper.ReceptionistDAO;
import DAOHelper.RoomDBH;
import entity.Customer;
import entity.GeneralHelp;

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
            RoomDBH roomDBH = new RoomDBH(DBHGeneral.getConnection());
            roomDBH.updateRoomNumberByRoomID("1","304");
            out.println("test");

            ReceptionistDAO receptionistDAO = new ReceptionistDAO(DBHGeneral.getConnection());
            receptionistDAO.queryByID("10000");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
