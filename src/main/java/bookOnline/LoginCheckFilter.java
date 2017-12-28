package bookOnline;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.lang.System.out;

@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/bookOnline/23112")
public class LoginCheckFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        Boolean hasLogin = (Boolean) session.getAttribute("hasLogin");
        if (hasLogin != null && hasLogin) {
            chain.doFilter(req, resp);
        } else {
            out.println("not login");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(req,resp);
        }

        chain.doFilter(req,resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
