package entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

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
    }

    public Customer(String username,String  password,String IDNumber) {
        // TODO
        //这里生成的ID有可能与原数据库的的ID冲突，这里因为选的是long产生的随机ID，所以在数据较小的情况下暂时没有问题
        this.userID = GeneralHelp.getRandomUserID();
        this.username = username;
        this.password = password;
        this.IDNumber = IDNumber;
    }


    //用户登录时的相关初始化工作
    public void LoginInitialize(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("hasLogin",true);
        session.setAttribute("customer",this);
    }



    //PRIVATE MEMBER


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
