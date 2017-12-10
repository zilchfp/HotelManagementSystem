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
    <title>basicSettingLogin</title>
</head>
<body>
<h1>
    基础设置
</h1>
经理账户登录：
<form action="Index.jsp" method="post">
    <table>
        <tr><td>用户名：</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr><td>密&nbsp;&nbsp;码：</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr><td><input type="submit" value="登录"/></td>
            <td><input type="reset" value="注册"/></td>
        </tr>
    </table>
</form>
</body>
</html>
