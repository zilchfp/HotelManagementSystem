


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 2-->
<%--<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">--%>
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

        <div class="mdui-list" style="size: 100px">
            <a href="CustomerAccountAdd.jsp" class="mdui-list-item mdui-ripple">客户账号增加</a>
            <a href="CustomerAccountModifyID.jsp" class="mdui-list-item mdui-ripple">客户账号修改</a>
            <a href="CustomerAccountDelete.jsp" class="mdui-list-item mdui-ripple">客户账号删除</a>
        </div>



            <div class="main-btn-wrapper" >
                <form action="CustomerAccountAdd.jsp" method="get" >
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号增加">
                </form>
                <br>
                <form action="CustomerAccountModifyID.jsp" method="get" >
                    <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号修改">
                </form>
                <br>
                <form action="CustomerAccountDelete.jsp" method="get" >
                    <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号删除">
                </form>
                <br>
            </div>
    </div>

</div>
<script src="../MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("CustomerSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>
</body></html>

