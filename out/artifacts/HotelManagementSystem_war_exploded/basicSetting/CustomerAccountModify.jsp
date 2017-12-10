<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-10
  Time: 上午11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    客户账号修改
</h1>

<form action="/basicSetting/CustomerAccountModify.do" method="post" >
请输入要修改的客户账号ID:<input type="text" size="10" name="userIDModify" required>
    客户姓名: <input type="text" size="10" name="usernameModify" >
    客户账号密码: <input type="text" size="10" name="passwordModify" >
    客户身份证号码: <input type="text" size="10" name="IDNumberModify" >
    <input type="submit" value="提交">
    <br>
</form>
</body>
</html>
