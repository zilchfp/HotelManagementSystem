<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="DrawerBar.html"></jsp:include>
<!-- Content-->
<div class="mdui-container doc-container main-section" style="display: flex;flex-direction: column;">
    <%--<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">--%>
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h1>
        退房管理
        </h1>
        请输入房间编号：
        <form action="/ReceptionManagemnt/Checkout.do" method="post">
        <input type="text" size="10" name="checkoutRoomID">
        <input type="submit" value="提交">
        </form>
    </div>

</div>


<script src="../MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("ReceptionManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("Checkout");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>

</body></html>

