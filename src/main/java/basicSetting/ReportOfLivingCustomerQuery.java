package basicSetting;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;
import com.sun.xml.internal.bind.v2.model.core.ID;
import entity.CustomerReport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.IDN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.System.out;

@WebServlet("/basicSetting/ReportOfLivingCustomer.do")
public class ReportOfLivingCustomerQuery extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CustomerDAO customerDAO = new CustomerDAO();
            ArrayList<CustomerReport> customerReportArrayList = new ArrayList<>();

            ResultSet r = customerDAO.queryCustomersLiving();
            while (r.next()) {
                String userID = r.getString("userID");
                String IDNumber = r.getString("IDNumber");
                String customerName = r.getString("customerName");
                String roomID = r.getString("roomID");
                String dateBegin = r.getString("dateBegin");
                String dateEnd = r.getString("dateEnd");

                CustomerReport customerReport =
                                                new CustomerReport.
                                                    Builder(userID).
                                                    IDNumber(IDNumber).
                                                    customerName(customerName).
                                                    roomID(roomID).
                                                    dateBegin(dateBegin).
                                                    dateEnd(dateEnd).
                                                    build();
                customerReportArrayList.add(customerReport);
            }
            request.setAttribute("customerReportArrayList",customerReportArrayList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("/basicSetting/ReportOfLivingCustomer.jsp");
        rd.forward(request,response);
    }
}
