<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<h1>
    基础设置
</h1>
<%--：设置客房分类信息：客房类型、房价、空余房间数—经理--%>

<%--：房间号，房间类型、楼层、朝向、房间特征描述、房间状态是否空置等—经理--%>

<%--：添加删除修改各类角色账号—经理--%>

<form action="" method="" >
    <input type="submit" value="客房类型设置">
    <br>
</form>
<form action="RoomInformationSettingID.jsp" method="get" >
    <input type="submit" value="客房信息设置">
    <br>
</form>
<form action="AccountSetting.jsp" method="get" >
    <input type="submit" value="账号管理">
    <br>
</form>

</body>
</html>
