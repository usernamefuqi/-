<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>电子工厂物资管理登录中心</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>

</head>
<body>
<div class="bg"></div>
<div class="container">
    <div class="line bouncein">
        <div class="xs6 xm4 xs3-move xm4-move">
            <div style="height:150px;"></div>
            <div class="media media-y margin-big-bottom">
            </div>
            <form action="" method="post" id="login" onsubmit="return submitHandler()">
                <div class="panel loginbox">
                    <div class="text-center margin-big padding-big-top"><h1>电子工厂物资管理登录中心</h1></div>
                    <div class="panel-body" style="padding:30px; padding-bottom:10px; padding-top:10px;">
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="text" class="input input-big" name="username" placeholder="登录账号"
                                       data-validate="required:请填写账号" value="${username}"/>
                                <span class="icon icon-user margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field field-icon-right">
                                <input type="password" class="input input-big" name="password" placeholder="登录密码"
                                       data-validate="required:请填写密码" value="${password}"/>
                                <span class="icon icon-key margin-small"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="field">
                                <input type="text" class="input input-big" name="code" placeholder="填写右侧的验证码"
                                       data-validate="required:请填写右侧的验证码"/>
                                <img id="ode_img" name="randImage" src="${pageContext.request.contextPath}/Image/jpeg"
                                     alt="code" width="100"
                                     height="32" class="passcode" style="height:43px;cursor:pointer;">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="field field-icon-right">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="field field-icon-right" align="center">
                                <input type="radio" name="radio" value="user"/>用户
                                <input type="radio" name="radio" value="admin" style="margin-left: 80px"/>管理员
                            </div>
                        </div>

                    </div>
                    <div style="padding:30px;"><input id="submit" type="submit"
                                                      class="button button-block bg-main text-big input-big" value="登录">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>

    $("#ode_img").click(function () {
        // 在事件响应的 function 函数中有一个 this 对象。这个 this 对象，是当前正在响应事件的 dom 对象
        // src 属性表示验证码 img 标签的 图片路径。它可读，可写
        this.src = "${pageContext.request.contextPath}/Image/jpeg?" + Math.random();
    });

    function submitHandler() {
        var role = '';
        role = $("[name='radio']:checked").val();
        //alert($("[name='radio']:checked").val());
        var actions = null;
        if (role == 'user') {
            actions = "${pageContext.request.contextPath}/Login/user";
        } else if (role == 'admin') {
            actions = "${pageContext.request.contextPath}/Login/admin";
        }
        document.getElementById("login").action = actions;
        return true;
    }
</script>

</body>
</html>