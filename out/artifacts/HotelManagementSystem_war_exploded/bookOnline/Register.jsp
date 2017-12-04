<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>客户注册</title>
</head>
<body>
<h1>
    客户注册
</h1>
<form action = "/bookOnline/Register.do" method = "post">

    姓名：<input type = "text" size = "20" name = "customerName" />
    <br>
    <br>
    性别：<input type = "radio" name = "customerGender" value="male" /> 男
         <input type = "radio" name = "customerGender" value="female" /> 女
    <br>
    <br>
    身份证号码：<input type = "text" size = "30" name = "customerID" />
    <br>
    <br>
    <input type = "submit"  value="注册账号"/>
</form>


</body>
</html>
