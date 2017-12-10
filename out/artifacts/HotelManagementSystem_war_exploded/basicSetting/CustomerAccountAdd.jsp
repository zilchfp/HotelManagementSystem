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
    客户账号增加
</h1>
请输入要增加的客户账号ID:
<form action="/basicSetting/CustomerAccountAdd.do" method="post" >
    客户用户名：<input type="text" size="10" name="customerUsernameAdd">
    客户账号密码：<input type="text" size="10" name="customerPasswordAdd">
    客户身份证：<input type="text" size="10" name="customerIDNumberAdd">
    <input type="submit" value="提交">
    <br>
</form>
</body>
</html>
