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
    response.setHeader("Refresh","3; URL = /basicSetting/Index.jsp");
%>

</body>
</html>
