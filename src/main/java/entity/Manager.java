package entity;

import DAOHelper.CustomerDAO;
import DAOHelper.DBHGeneral;

import java.sql.Connection;
import java.sql.SQLException;

public class Manager {
    private String ID;
    private String username;
    private String password;
    private String name;
    private String gender;


    public boolean addCustomerAccount(Customer customer) throws SQLException {
        Connection c = DBHGeneral.getConnection();
        CustomerDAO customerDAO = new CustomerDAO();
        return customerDAO.addCustomer(customer);
    }

    public void addRoom() {

    }
    public void deleteRoom() {

    }

    public void addReceptionist() {

    }
}
