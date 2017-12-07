package entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
//    private static String userID;
//    private static String username;
//    private static String password;
//    private static String IDNumber;


    private String userID;
    private String username;
    private String password;
    private String IDNumber;

    public Customer (ResultSet res) throws SQLException {
        this.userID = res.getString("userID");
        this.username = res.getString("username");
        this.password = res.getString("password");
        this.IDNumber = res.getString("IDNumber");
        System.out.println("create succss");
    }


    //用户登录时的相关初始化工作
    public void LoginInitialize(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("hasLogin",true);
        session.setAttribute("customer",this);
    }




    //getter and setter
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIDNumber() {
        return IDNumber;
    }
}
