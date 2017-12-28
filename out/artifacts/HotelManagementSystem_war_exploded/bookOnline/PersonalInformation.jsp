<%@ page import="entity.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="DrawerBar.html"></jsp:include>
<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <h1>
        个人信息
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>ID</th>
                <th>姓名</th>
                <th>身份证号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orders" items="${requestScope.CustomerOrdersQueryResult}"
                       varStatus="status" >
                <tr>
                    <td>${sessionScope.LoginCustomer.userID}</td>
                    <td>${sessionScope.LoginCustomer.username}</td>
                    <td>${sessionScope.LoginCustomer.IDNumber}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%
//    Customer customer = (Customer) session.getAttribute("LoginCustomer");
//    out.println(customer.getUsername());
%>
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

