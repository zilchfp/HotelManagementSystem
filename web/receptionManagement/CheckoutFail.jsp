<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-9
  Time: 下午11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    退房失败！3秒后跳转回退房界面......
</h1>
<%
    response.setHeader("Refresh","3; URL = /receptionManagemtn/Checkout.jsp");
%>
</body>
</html>
