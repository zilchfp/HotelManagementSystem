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
    退房成功！2秒后返回退房界面。

    <%
        response.setHeader("Refresh","2; URL = /receptionManagement/Checkout.jsp");
    %>
</h1>
</body>
</html>
