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

姓名：
<%
    Customer customer = (Customer) session.getAttribute("customer");
    System.out.println(customer.getUsername());
%>
<br>

性别：
<br>

身份证号：
<br>

</body>
</html>
