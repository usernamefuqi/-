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
    <title>修改职员信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>修改职员信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${pageContext.request.contextPath}/Entry/update">

            <input type="hidden" name="staffId" value="${entryRegist.staffId}"/>

            <div class="form-group">
                <div class="label">
                    <label>职工姓名: </label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${entryRegist.staffName}" name="staffName"
                           data-validate="required:请输入职工姓名"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>性别: </label>
                </div>
                <div class="field">
                    <div class="button-group radio">

                        <c:if test="${entryRegist.sex == true}">
                            <label class="button active">
                                <span class="icon icon-check"></span>
                                <input name="sex" value="男" type="radio" checked="checked">男
                            </label>

                            <label class="button active" onclick="displayspan($('#span1'))">
                                <span id="span1" style="display: none" class="icon icon-times"></span>
                                <input name="sex" value="女" type="radio">女
                            </label>
                        </c:if>

                        <c:if test="${entryRegist.sex == false}">
                            <label class="button active" onclick="displayspan($('#span2'))">
                                <span id="span2" style="display: none" class="icon icon-check"></span>
                                <input name="sex" value="男" type="radio">男
                            </label>

                            <label class="button active">
                                <span class="icon icon-times"></span>
                                <input name="sex" value="女" type="radio" checked="checked">女
                            </label>
                        </c:if>

                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>年龄: </label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${entryRegist.age}" name="age"
                           data-validate="required:请输入年龄"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>电话: </label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${entryRegist.phone}" name="phone"
                           data-validate="required:请输入电话"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>住址: </label>
                </div>
                <div class="field">
                    <input type="text" class="input w50" value="${entryRegist.address}" name="address"
                           data-validate="required:请输入住址"/>
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

<script type="text/javascript">

    function displayspan($span){
        $span.show();
    }

</script>

</body>
</html>