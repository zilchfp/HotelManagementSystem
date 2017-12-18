
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- Content-->
<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <div class="main-btn-wrapper mui-btn--large" >
            <form action="ReceptionistAccountAdd.jsp" method="get" >
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white " value="接待员账号增  ">
            </form>
            <br>
            <form action="ReceptionistAccountModify.jsp" method="get" >
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="接待员账号修改  ">
            </form>
            <br>
            <form action="ReceptionistAccountDelete.jsp" method="get" >
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="接待员账号删除     ">
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
    var c = document.getElementById("ReceptionistSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>

</body></html>

