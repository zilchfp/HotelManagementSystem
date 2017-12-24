<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h1>
            订单详情
        </h1>

        预定以下房间：


    </div>
</div>

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

