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
    response.setHeader("Refresh","3; URL = /basicSetting/ManagerLogin.jsp");
%>


</body>
</html>
