<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <h1>
    欢迎使用酒店信息管理系统
  </h1>
  <br>

  <form action = "basicSetting/Login.jsp" method="get">
    <input type = "submit" value= "基础设置"/>
  </form>

  <form action="/bookOnline/Login.jsp" method="get">
    <input type = "submit" value = "在线预订" />
  </form>

  <form action = "receptionManagement/Login.jsp" method="get">
    <input type = "submit" value= "前台管理"/>
  </form>

  <form action = "roomManagement/Login.jsp" method="get">
    <input type = "submit" value= "客房管理"/>
  </form>

  </body>
</html>
