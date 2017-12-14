<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-14
  Time: 下午10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    您要设置的房间信息如下：
</h1>
<jsp:useBean id="resultRoomOfSetting" class="entity.Room"
             scope="session">
</jsp:useBean>

房间ID:<jsp:getProperty name="resultRoomOfSetting" property="ID"></jsp:getProperty>
<br>
房间号：<jsp:getProperty name="resultRoomOfSetting" property="number"></jsp:getProperty>
<br>
房间类型：<jsp:getProperty name="resultRoomOfSetting" property="type"></jsp:getProperty>
<br>
楼层：<jsp:getProperty name="resultRoomOfSetting" property="floor"></jsp:getProperty>
<br>
方位：<jsp:getProperty name="resultRoomOfSetting" property="direction"></jsp:getProperty>
<br>
房间描述：<jsp:getProperty name="resultRoomOfSetting" property="description"></jsp:getProperty>
<br>
房间状态：<jsp:getProperty name="resultRoomOfSetting" property="status"></jsp:getProperty>

</body>
</html>
