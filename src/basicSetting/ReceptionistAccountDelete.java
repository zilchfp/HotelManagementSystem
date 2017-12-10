package basicSetting;

import DBHelper.DBHGeneral;
import DBHelper.ReceptionistDBH;

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

        try {
            Connection c = DBHGeneral.getConnection();
            ReceptionistDBH receptionistDBH = new ReceptionistDBH(c);
            receptionistDBH.Delete(receptionistIDDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
