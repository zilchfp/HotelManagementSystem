
<%--<h1>--%>
    <%--账号设置--%>
<%--</h1>--%>

<%--<form action="CustomerSetting.jsp" method="get" >--%>
    <%--<input type="submit" value="客户账号管理">--%>
    <%--<br>--%>
<%--</form>--%>

<%--<form action="ReceptionistSetting.jsp" method="get" >--%>
    <%--<input type="submit" value="接待员账号管理">--%>
    <%--<br>--%>
<%--</form>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cmn-Hans"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="../MDUI_files/mdui.min.css">
    <link rel="stylesheet" href="../MDUI_files/style.css">
    <script src="https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4"></script><script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script><style></style><style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255,255,255,.38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style></head>
<body class="mdui-drawer-body-left mdui-appbar-with-toolbar mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded" style="">
<header class="mdui-appbar mdui-appbar-fixed">
    <div class="mdui-toolbar mdui-color-theme">
        <%--<span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white" mdui-drawer="{target: '#main-drawer', swipe: true}"><i class="mdui-icon material-icons">menu</i></span>--%>
        <a href="Index.jsp" class="mdui-typo-title">经理管理</a>
        <div class="mdui-toolbar-spacer"></div>
        <%--<span class="mdui-btn mdui-btn-icon mdui-ripple mdui-ripple-white" mdui-dialog="{target: '#dialog-docs-theme'}" mdui-tooltip="{content: '设置主题'}"><i class="mdui-icon material-icons">color_lens</i></span>--%>
    </div>
</header>

<div class="mdui-drawer" id="main-drawer">
    <div class="mdui-list" mdui-collapse="{accordion: true}" style="margin-bottom: 76px;">
        <div class="mdui-collapse-item mdui-collapse-item-open ">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <%--<i class="mdui-list-item-icon mdui-icon material-icons mdui-text-color-blue">near_me</i>--%>
                <div class="mdui-list-item-content">基础设置</div>
                <%--<i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>--%>
            </div>
            <div class="mdui-collapse-item-body mdui-list">
                <a href="./" class="mdui-list-item mdui-ripple ">客房类型设置</a>
                <a href="./RoomInformationSetting.jsp" class="mdui-list-item mdui-ripple ">客房信息设置</a>
                <a href="./AccountSetting.jsp" class="mdui-list-item mdui-ripple mdui-list-item-active ">账号管理</a>

            </div>
        </div>

        <div class="mdui-collapse-item mdui-collapse-item-close">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <%--<i class="mdui-list-item-icon mdui-icon material-icons mdui-text-color-blue">near_me</i>--%>
                <div class="mdui-list-item-content">预定管理</div>
                <%--<i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>--%>
            </div>
            <div class="mdui-collapse-item-body mdui-list">
                <a href="./" class="mdui-list-item mdui-ripple ">控房功能</a>
                <a href="./" class="mdui-list-item mdui-ripple ">预订单管理</a>
                <a href="./" class="mdui-list-item mdui-ripple ">团体预定</a>

            </div>
        </div>

        <div class="mdui-collapse-item mdui-collapse-item-close">
            <div class="mdui-collapse-item-header mdui-list-item mdui-ripple">
                <%--<i class="mdui-list-item-icon mdui-icon material-icons mdui-text-color-blue">near_me</i>--%>
                <div class="mdui-list-item-content">客房管理</div>
                <%--<i class="mdui-collapse-item-arrow mdui-icon material-icons">keyboard_arrow_down</i>--%>
            </div>
            <div class="mdui-collapse-item-body mdui-list">
                <a href="./" class="mdui-list-item mdui-ripple ">销售月报表</a>
                <a href="./" class="mdui-list-item mdui-ripple ">在住客人报表</a>
                <a href="./" class="mdui-list-item mdui-ripple ">在住团队报表</a>

            </div>
        </div>

    </div>
</div>




<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">




    </div>
</div>

<script src="../MDUI_files/mdui.min.js"></script>
<script>
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });
</script></body></html>

