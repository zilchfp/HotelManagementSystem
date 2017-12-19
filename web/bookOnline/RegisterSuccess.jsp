<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-14
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    注册成功！3秒后跳转至登录界面。
</h1>
<%
    response.setHeader("Refresh","3; URL = /bookOnline/Index.jsp");
%>
</body>
</html>
