<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>

<script src="../MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    var  BasicSetting = document.getElementById("BasicSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    BasicSetting.setAttribute("class",open);

    var RoomTypeSetting = document.getElementById("RoomTypeSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    RoomTypeSetting.setAttribute('class',active);
</script>

</body></html>
