<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 -->

<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <form action="/bookOnline/RoomQuery.do" method="post">
        <h1>请输入起始时间</h1>
        <br>
        入住日期：<input type="date" value="datetime-local" id="dateBeginID" name="dateBegin" min="today"/>
        <br>
        离店日期：<input type="date" value="datetime-local" name="dateEnd"/>
        <br>
        <br>
        <input type="submit" value="查询">
        </form>
    </div>
</div>

<script type="text/javascript">
    //限制入住日期从今天开始
    //document.getElementById("dateBeginID").setAttribute("min",new Date().toISOString().substring(0, 10));
</script>


<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("BookRoom");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("AvailableRoomQuery");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>
<script src="../MDUI_files/mdui.min.js"></script>
</body></html>

