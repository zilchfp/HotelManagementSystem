<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RoomQuery</title>
</head>
<body>
<h1>
    空房查询
</h1>

<form action="/bookOnline/RoomQuery.do" method="post">
    请输入起始时间：
    <br>
    入住日期：<input type="date" value="datetime-local" name="dateBegin"/>
    <br>
    离店日期：<input type="date" value="datetime-local" name="dateEnd"/>
    <br>
    <br>
    <input type="submit" value="查询">
</form>


</body>
</html>
