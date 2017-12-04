<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午7:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Fail</title>
</head>
<body>
<h1>
    您尚未登录！请登录后再进行操作，3秒后跳转回登录界面......
</h1>
<%
    response.setHeader("Refresh","3; URL = /roomManagement/Login.jsp");
%>


</body>
</html>
