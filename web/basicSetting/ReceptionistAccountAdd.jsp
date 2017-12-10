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
    接待员账号增加
</h1>
请输入要增加的接待员账号ID:
<form action="/basicSetting/ReceptionistAccountAdd.do" method="post" >
    <input type="text" size="10" name="receptionistIDAdd">
    <input type="submit" value="提交">
    <br>
</form>
</body>
</html>
