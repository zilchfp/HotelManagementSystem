<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Boolean customerHasLogined = (Boolean) session.getAttribute("customerHasLogined");
    if (!customerHasLogined) {
        RequestDispatcher rd = request.getRequestDispatcher("UnLogin.jsp");
        rd.forward(request,response);
    }

%>
