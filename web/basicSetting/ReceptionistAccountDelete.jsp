<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- Content-->
<div class="mdui-container doc-container main-section" style="display: flex;flex-direction: column;">
    <%--<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">--%>
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h1>
        接待员账号删除
        </h1>
        请输入要删除的接待员账号ID:
        <form action="/basicSetting/ReceptionistAccountDelete.do" method="post" >
        ID: <input type="text" size="10" name="receptionistIDDelete" required/>
        <input type="submit" value="提交">
        <br>
        </form>
        请输入要增加的接待员账号ID:
        <form action="/basicSetting/ReceptionistAccountAdd.do" method="post" >
            <input type="text" size="10" name="receptionistIDAdd">
            <input type="submit" value="提交">
        </form>
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

