<%@ page import="entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PersonalInformation</title>
</head>
<body>
<h1>
    个人信息
</h1>

ID：${sessionScope.customer.userID}

<%
    Customer customer = (Customer) session.getAttribute("customer");
    System.out.println(customer.getUsername());
%>
<br>

姓名：${sessionScope.customer.username}
<br>

身份证号：${sessionScope.customer.IDNumber}
<br>

</body>
</html>
