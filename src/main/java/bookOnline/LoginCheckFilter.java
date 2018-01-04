package bookOnline;

import com.sun.org.apache.xpath.internal.operations.Bool;
import entity.Customer;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.System.out;

@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/bookOnline/*")
public class LoginCheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Customer loginedCustomer = (Customer) session.getAttribute("LoginedCustomer");
        String requestPath = request.getServletPath();
        if (loginedCustomer != null
                || requestPath.endsWith("Login")
                || requestPath.endsWith("Login.do")
                || requestPath.endsWith("Register.jsp")
                || requestPath.endsWith("Register.do")) {
            chain.doFilter(req, resp);
        } else {
            String nextURL,message;
            nextURL = "/CustomerLogin.jsp";
            message = "您尚未登录！请先登录！3秒后返回登录界面。";
            request.setAttribute("nextURL",nextURL);
            request.setAttribute("intermediateTimer",3);
            request.setAttribute("message",message);
            RequestDispatcher rd = request.getRequestDispatcher("/General/intermediatePage.jsp");
            rd.forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
