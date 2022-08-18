<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <meta name="renderer" content="webkit">
    <title>个人信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>
    <style type="text/css">
        #span{
            text-align: left;
            background-color: rgba(82,80,81,0.24);
        }
    </style>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 个人信息</strong></div>
        <table class="table table-hover text-center">
            <tr>
                <th class="th">职员ID:</th><th><input type="text" class="input w50" name="staffId" value="${entryRegist.staffId}" disabled="disabled"/></th>
            </tr>
            <tr>
                <th class="th">姓名:</th><th><input type="text" class="input w50" value="${entryRegist.staffName}" name="staffName" disabled="disabled"/></th>
            </tr>
            <tr>
                <c:if test="${entryRegist.sex == true}">
                    <th class="th">性别:</th><th><input type="text" class="input w50" value="男" name="staffName" disabled="disabled"/></th>
                </c:if>
                <c:if test="${entryRegist.sex == false}">
                    <th class="th">性别:</th><th><input type="text" class="input w50" value="女" name="staffName" disabled="disabled"/></th>
                </c:if>

            </tr>
            <tr>
                <th class="th">年龄:</th><th><input type="text" class="input w50" value="${entryRegist.age}" name="staffName" disabled="disabled"/></th>
            </tr>
            <tr>
                <th class="th">电话:</th><th><input type="text" class="input w50" value="${entryRegist.phone}" name="staffName" disabled="disabled"/></th>
            </tr>
            <tr>
                <th class="th">住址:</th><th><input type="text" class="input w50" value="${entryRegist.address}" name="staffName" disabled="disabled"/></th>
            </tr>
            <tr>
                <th class="th">入职时间:</th><th><span id="span" class="input w50"><fmt:formatDate value="${entryRegist.entryTime}" pattern="yyyy.MM.dd"/></span></th>
            </tr>
            <tr>
                <th><a class="button border-main" href="${pageContext.request.contextPath}/User/selectById"><span class="icon-edit"></span>
                    修改账户</a></th>
                <th><a class="button border-main" href="javascript:void(0)" onclick="outjob(${entryRegist.staffId})"><span class="icon-edit"></span>
                    离职</a></th></th>
            </tr>
        </table>
    </div>
</form>
<script type="text/javascript">
    function outjob(staffId){
        if (confirm("您确定要离职吗?")) {
            // console.log(goodsId);
            location.href = "${pageContext.request.contextPath}/Leave/add?staffId=" + staffId;
        }
    }
</script>
</body>
</html>