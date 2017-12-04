<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>receptionManagementLogin</title>
</head>
<body>
<h1>
    前台管理
</h1>
<form action="/receptionManagement/Login.do" method="post">
    <table>
        <tr><td>用户名：</td>
            <td><input type="text" name="receptionistName"/></td>
        </tr>
        <tr><td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" name="receptionistPassword"/></td>
        </tr>
        <tr><td><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>
