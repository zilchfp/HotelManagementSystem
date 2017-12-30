<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="DrawerBar.html"></jsp:include>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        退房订单信息如下
    </h1>



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

