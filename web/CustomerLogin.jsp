<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>bookOnlineLogin</title>
</head>
<body>
<h1>
    在线预定
</h1>

    <table>
        <form action="/bookOnline/Login.do" method="post">
            <tr><td>用户名：</td>
                <td><input type="text" name="nameCustomerLogin"/></td>
            </tr>
            <tr><td>密&nbsp;&nbsp;码：</td>
                <td><input type="password" name="passwordCustomerLogin"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"/></td>
        </form>

        <form action="bookOnline/Register.jsp" method="get">
                <td><input type="submit" value="注册"/></td>
        </form>
        </tr>
    </table>


</body>
</html>
