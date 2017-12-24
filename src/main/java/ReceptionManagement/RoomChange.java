package ReceptionManagement;

import entity.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagement/RoomChange")
public class RoomChange extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderIDChangeRoom = request.getParameter("orderIDChangeRoom");
        String roomChangeOfRoomID = request.getParameter("roomChangeOfRoomID");
        out.println(orderIDChangeRoom+"  "+roomChangeOfRoomID);
        Receptionist receptionist = new Receptionist();
        try {
            receptionist.changeRoomByOrderID(orderIDChangeRoom, roomChangeOfRoomID);
            //TODO
            //换房成功
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
