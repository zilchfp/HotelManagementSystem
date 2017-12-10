package basicSetting;

import DBHelper.CustomerDBH;
import DBHelper.DBHGeneral;
import entity.GeneralHelp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static java.lang.System.out;

@WebServlet("/basicSetting/CustomerAccountModify.do")
public class CustomerAccountModify extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userIDModify = request.getParameter("userIDModify");
        String usernameModify = request.getParameter("usernameModify");
        String passwordModify = request.getParameter("passwordModify");
        String IDNumberModify = request.getParameter("IDNumberModify");

//        if (usernameModify) {
//            out.println("userNameModify is null");
//        } else {
//            out.println("usernameModify:"+usernameModify+"__");
//        }

        try {
            Connection c = DBHGeneral.getConnection();

            if (!usernameModify.equals("")) {
                CustomerDBH customerDBH = new CustomerDBH(c);
                customerDBH.UpdateUsername(usernameModify, userIDModify);
            } ;
            if (!passwordModify.equals("")) {
                CustomerDBH customerDBH = new CustomerDBH(c);
                customerDBH.UpdatePassword(passwordModify, userIDModify);
            };
            if (!IDNumberModify.equals("")) {
                CustomerDBH customerDBH = new CustomerDBH(c);
                customerDBH.UpdateIDNumber(IDNumberModify, userIDModify);
            };

            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
