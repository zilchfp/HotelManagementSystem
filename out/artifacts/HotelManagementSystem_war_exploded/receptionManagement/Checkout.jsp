<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="DrawerBar.html"></jsp:include>
<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入退房的房间编号
    </h1>
    <form action="/ReceptionManagemnt/Checkout.do" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">ID</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="checkoutRoomID"/>
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
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

