<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要设置的房间信息如下：
    </h1>
    <jsp:useBean id="resultRoomOfSetting" class="entity.Room" scope="session"></jsp:useBean>
    <div class="mdui-typo-body-1">
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
    </div>

</div>


<script src="../MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("BasicSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("RoomInformationSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>

<script type="text/javascript">
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });
</script></body></html>

