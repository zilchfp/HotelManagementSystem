<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

        <h1>
            空房查询结果
        </h1>

        <form action="/bookOnline/RoomQueryResultChosen.do" method="post" >
            <div class="mdui-table-fluid">
                <table class="mdui-table mdui-table-hoverable" >
                    <thead>
                    <tr>
                        <th>房间类型</th>
                        <th>房间数量</th>
                        <th>预定数量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="allType" items="${requestScope.AvailableQueryResult}"
                               varStatus="status" >
                        <tr>
                            <td>${allType.key}</td>
                            <td>${allType.value}</td>
                            <td>
                                <label class="mdui-radio">
                                <input id="bookChooseButton" type="radio" name="booked"/>
                                    <i class="mdui-radio-icon"></i>
                                </label>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <br>
            <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">预定</button>
        </form>


    </div>
</div>

<script type="text/javascript">
    var p = document.getElementById("bookChooseButton")
    p.setAttribute("input",disable())

</script>
<script type="text/javascript">
    //p for parent bar
    var  p = document.getElementById("BookRoom");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class",open);
    //c for child bar
    var c = document.getElementById("AvailableRoomQuery");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class',active);
</script>
<script src="../MDUI_files/mdui.min.js"></script>

</body></html>

