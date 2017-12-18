
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>--%>
    <%--客房信息设置--%>
<%--</h1>--%>


<%--<br>--%>
<%--<select name="S_ONE" id="S_ONE" onchange=your_js_function() >--%>
    <%--<OPTION value=2 selected>hahahaha</OPTION>--%>
    <%--<OPTION value=3>hehe</OPTION>--%>
    <%--<OPTION value=4>asasd</OPTION>--%>
    <%--<OPTION value=5>fvfdfgfdg</OPTION>--%>
<%--</select>--%>

<%--</body>--%>
<%--</html>--%>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入要设置的客房ID
    </h1>
    <form action="/basicSetting/RoomInformationQuery.do" method="post">

        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">ID</label>
            <input type="text"  class="mdui-textfield-input" size="10" name="IDOfSettingRoom"/>
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
    </div>

</div>


<script src="../MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("BasicSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("RoomInformationSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>

<script type="text/javascript">
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });
</script></body></html>

