<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>职员入职登记</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>职员入职登记</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/Entry/add">
            <div class="form-group">
                <div class="label">
                    <label>职工姓名: </label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="name" data-validate="required:请输入职员姓名" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>性别: </label>
                </div>
                <div class="field">
                    <div class="button-group radio">

                        <label class="button active">
                            <span class="icon icon-check"></span>
                            <input name="sex" value="男" type="radio" checked="checked">男
                        </label>

                        <label class="button active">
                            <span class="icon icon-times"></span>
                            <input name="sex" value="女" type="radio" checked="checked">女
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>年龄</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="age" data-validate="required:请输入年龄" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>电话</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="phone" data-validate="required:请输入电话" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>住址</label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="" name="address" data-validate="required:请输入住址" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="label">
                <label></label>
            </div>
            <div class="field">
                <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
            </div>
    </form>
</div>
</div>

</body></html>