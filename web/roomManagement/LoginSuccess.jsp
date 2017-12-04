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
    <title>Login Success</title>
</head>
<body>
<h1>
    接待员登录成功！3秒后跳转至主页面......
</h1>

<%
    response.setHeader("Refresh","3; URL = /roomManagement/Index.jsp");
%>

</body>
</html>
