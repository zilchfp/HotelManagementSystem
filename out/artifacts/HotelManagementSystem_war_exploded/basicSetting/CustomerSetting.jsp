<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-10
  Time: 下午2:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    客户账户管理
</h1>

<form action="CustomerAccountAdd.jsp" method="get" >
    <input type="submit" value="客户账号增加">
    <br>
</form>

<form action="CustomerAccountModify.jsp" method="get" >
    <input type="submit" value="客户账号修改">
    <br>
</form>

<form action="CustomerAccountDelete.jsp" method="get" >
    <input type="submit" value="客户账号删除">
    <br>
</form>


</body>
</html>
