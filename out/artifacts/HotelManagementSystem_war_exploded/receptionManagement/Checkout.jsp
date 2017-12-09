<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-9
  Time: 下午11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    退房管理
</h1>
请输入房间编号：
<form action="/ReceptionManagemnt/Checkout.do" method="post">
    <input type="text" size="10" name="checkoutRoomID">
    <input type="submit" value="提交">
</form>

</body>
</html>
