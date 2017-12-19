<%@ page import="entity.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

        <h1>
        个人信息
        </h1>

        ID：${sessionScope.customer.userID}
        <br>

        姓名：${sessionScope.customer.username}
        <br>

        身份证号：${sessionScope.customer.IDNumber}
        <br>



    </div>
</div>

<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("PersonalSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("PersonalInformation");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>

<script src="../MDUI_files/mdui.min.js"></script>

</body></html>

