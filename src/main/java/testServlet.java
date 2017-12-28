import DAOHelper.DBHGeneral;
import DAOHelper.ReceptionistDAO;
import DAOHelper.RoomDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            RoomDAO roomDAO = new RoomDAO(DBHGeneral.getConnection());
            roomDAO.updateRoomNumberByRoomID("1","304");
            out.println("test");

            ReceptionistDAO receptionistDAO = new ReceptionistDAO(DBHGeneral.getConnection());
            receptionistDAO.queryByID("10000");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
