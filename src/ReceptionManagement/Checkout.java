package ReceptionManagement;

import DAOHelper.DBHGeneral;
import DAOHelper.RoomDBH;
import entity.Receptionist;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/ReceptionManagemnt/Checkout.do")
public class Checkout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String roomID = request.getParameter("checkoutRoomID");

        Receptionist receptionist = new Receptionist();
        try {
            receptionist.roomCheckout(roomID);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //检查是否退房成功
        try {
            Connection c = DBHGeneral.getConnection();
            RoomDBH helper = new RoomDBH(c);
            helper.setID(roomID);
            String sql = "select * from Room where ID=?";
            ResultSet res = helper.query(sql);
            while (res.next()) {
                if (res.getString("status").equals("AVALIABLE")) {
                    out.println("checkout successfuley");

                    //TO DO
                    //

                } else {
                    out.println("checkout fail");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
