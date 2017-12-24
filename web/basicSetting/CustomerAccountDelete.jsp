<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入要删除的客户账号ID
    </h1>
    <form action="/basicSetting/CustomerAccountDelete.do" method="post" >
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">ID</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="customerIDDelete"/>
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
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



