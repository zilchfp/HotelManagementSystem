<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 2-->
<%--<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">--%>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        客户账号增加
    </h1>
    <form action="/basicSetting/CustomerAccountAdd.do" method="post" >
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户账号名</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="customerUsernameAdd"/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户密码</label>
            <input type="password"  class="mdui-textfield-input" size="10" name="customerPasswordAdd"/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户姓名</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="customerNameAdd"/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户身份证</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="customerIDNumberAdd"/>
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


