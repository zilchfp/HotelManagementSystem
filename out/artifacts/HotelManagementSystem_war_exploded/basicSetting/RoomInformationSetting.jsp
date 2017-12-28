<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<jsp:include page="DrawerBar.html"></jsp:include>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要设置的房间原信息如下
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <jsp:useBean id="resultRoomOfSetting" class="entity.Room" scope="session"></jsp:useBean>
            <tbody>
            <tr>
                <th>房间ID</th>
                <th><jsp:getProperty name="resultRoomOfSetting" property="ID"></jsp:getProperty></th>
            </tr>

            <tr>
                <td>房间号</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="number"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>房间类型</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="type"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>楼层</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="floor"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>方位</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="direction"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>房间描述</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="description"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>房间状态</td>
                <td><jsp:getProperty name="resultRoomOfSetting" property="status"></jsp:getProperty></td>
            </tr>

            </tbody>
        </table>
    </div>
    <br>
    <h1>
        将房间信息修改为如下
    </h1>
    <form>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间号</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="number"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间类型</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="type"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">楼层</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="floor"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">方位</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="direction"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间描述</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="description"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间状态</label>
            <input class="mdui-textfield-input" type="text"
                   value=<jsp:getProperty name="resultRoomOfSetting" property="status"></jsp:getProperty>>
        </div>
        <br>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
    </form>

    <br>
    <br>
    <br>
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

