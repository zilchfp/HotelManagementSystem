package entity;

import DBHelper.CustomerDBH;
import DBHelper.DBHGeneral;

import java.sql.Connection;
import java.sql.SQLException;

public class Manager {
    private String ID;
    private String username;
    private String password;
    private String name;
    private String gender;


    public void addCustomerAccount(Customer customer) throws SQLException {
        Connection c = DBHGeneral.getConnection();
        CustomerDBH customerDBH = new CustomerDBH(c);
        customerDBH.addCustomer(customer);
    }

    public void addRoom() {

    }
    public void deleteRoom() {

    }

    public void addReceptionist() {

        String sql = "\n" +
                "    insert into Receptionist values (\"10010\",\"HaHa\",\"Male\");";
    }
}
