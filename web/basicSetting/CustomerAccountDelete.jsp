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
    客户账号删除
</h1>
请输入要删除的客户账号ID:
<form action="/basicSetting/CustomerAccountDelete.do" method="post" >
    ID: <input type="text" size="10" name="customerIDDelete" required/>
    <input type="submit" value="提交">
    <br>
</form>
</body>
</html>