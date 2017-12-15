<%--
  Created by IntelliJ IDEA.
  User: zilchfp
  Date: 17-12-4
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cmn-Hans"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="./MDUI_files/mdui.min.css">
    <link rel="stylesheet" href="./MDUI_files/style.css">
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
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded" style="">




<!-- 首屏 -->
<div class="main-section mdui-color-theme">
    <div class="mdui-container main-container">
        <h2>
            <br>
            经理账户登录
        </h2>

        <form action="basicSetting/Index.jsp" method="post">
            <table>
                <tr><td>
                    用户名：
                    </td>
                    <td>
                        <%--<input type="text" name="username"/>--%>
                        <div class="mdui-textfield">
                            <input class="mdui-textfield-input" type="text" placeholder="用户名"/>
                        </div>
                    </td>
                </tr>
                <tr><td>密&nbsp;&nbsp;码：</td>
                    <td>
                        <div class="mdui-textfield">
                            <input class="mdui-textfield-input"  type="password" placeholder="密码"/>
                        </div>
                    </td>
                </tr>
                <tr><td>
                    <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">登录
                        <div class="main-btn-wrapper">
                            <a href="ManagerLogin.jsp" class="mdui-btn main-btn mdui-ripple mdui-ripple-white mdui-m-r-2" >登录</a>
                        </div>
                    </button>
                    </td>
                </tr>
            </table>
            <br>
            <br>
            <%--<br>--%>
            <%--<link rel="stylesheet" href="ionicons.css"/>--%>
            <%--&lt;%&ndash;<div class="mdui-center" >&ndash;%&gt;--%>
                <%--用户名：--%>
                    <%--<div class="mdui-textfield">--%>
                        <%--<i class="mdui-icon material-icons"></i>--%>
                        <%--<div class="mdui-hoverable">--%>
                            <%--<input class="mdui-textfield-input" type="text" placeholder="用户名"/>--%>
                        <%--</div>--%>
                    <%--</div>--%>
            <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
                    <%--<br>--%>
                <%--密&nbsp;&nbsp;码：--%>
                        <%--<div class="mdui-textfield">--%>
                            <%--<input class="mdui-textfield-input"  type="password" placeholder="密码"/>--%>
                        <%--</div>--%>
                    <%--<br>--%>
                    <%--<button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">登录--%>
                        <%--<div class="main-btn-wrapper">--%>
                            <%--<a href="ManagerLogin.jsp" class="mdui-btn main-btn mdui-ripple mdui-ripple-white mdui-m-r-2" >登录</a>--%>
                        <%--</div>--%>
                    <%--</button>--%>
            <%--</table>--%>




        </form>


    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
</div>

<script src="./MDUI_files/mdui.min.js"></script>
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

