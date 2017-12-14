<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-14
  Time: 下午10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    客房信息设置
</h1>
请输入要设置的客房ID：
<form action="/basicSetting/RoomInformationQuery.do" method="post">

    <input type="text" size="10" name="IDOfSettingRoom">
    <input type="submit" name="提交">
</form>

<br>
<select name="S_ONE" id="S_ONE" onchange=your_js_function() >
    <OPTION value=2 selected>hahahaha</OPTION>
    <OPTION value=3>hehe</OPTION>
    <OPTION value=4>asasd</OPTION>
    <OPTION value=5>fvfdfgfdg</OPTION>
</select>

</body>
</html>
