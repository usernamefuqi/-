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
    <title>入职登记信息</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/admin.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/pintuer.js"></script>
</head>
<body>
<form method="post" action="" id="listform">
    <div class="panel admin-panel">
        <div class="panel-head"><strong class="icon-reorder"> 入职登记列表</strong></div>
        <div class="padding border-bottom">
            <ul class="search" style="padding-left:10px;">
                <li><a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath}/entryAdd.jsp"> 入职登记</a></li>

                <li>
                    <label>搜索: </label>
                    <input id="staffName" type="text" placeholder="请输入搜索职员姓名" name="staffName" class="input"
                           style="width:250px; line-height:17px;display:inline-block"/>
                    <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()"> 搜索</a>
                </li>


            </ul>
        </div>
        <table class="table table-hover text-center">
            <tr>
                <th>序号</th>
                <th>职员ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>电话</th>
                <th>住址</th>
                <th>入职时间</th>
                <th>操作</th>
            </tr>
            <volist name="list" id="vo">

                <!-- 循环输出商品信息 -->
                <c:forEach items="${entryList}" var="entry" varStatus="lis">

                    <!-- 如果是偶数行，为该行换背景颜色 -->
                    <tr
                            <c:if test="${lis.index % 2 == 0 }">
                                style="background-color:rgb(219,241,212);"
                            </c:if>
                    >
                        <td>${lis.index+((pageInfo.pageNum-1)*6)+1}</td>
                        <td>${entry.staffId}</td>
                        <td>${entry.staffName}</td>
                        <c:if test="${entry.sex == true}">
                            <td>男</td>
                        </c:if>
                        <c:if test="${entry.sex == false}">
                            <td>女</td>
                        </c:if>
                        <td>${entry.age}</td>
                        <td>${entry.phone}</td>
                        <td>${entry.address}</td>
                        <td>
                            <fmt:formatDate value="${entry.entryTime}" pattern="yyyy.MM.dd"/>
                        </td>

                        <td>
                            <div class="button-group">
                                <a class="button border-main" href="${pageContext.request.contextPath}/Entry/selectById/${entry.staffId}"><span class="icon-edit"></span>
                                    修改</a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>

                <tr>
                    <td colspan="9" style="padding:12px 0;"></td>
                </tr>

                <tr>
                    <td colspan="9">
                            <!-- 分页信息 -->
                            <div class="row">
                                <!-- 分页文字信息，其中分页信息都封装在pageInfo中 -->
                                <div class="col-md-6">
                                    当前第：${pageInfo.pageNum}页，总共：${pageInfo.pages}页，总共：${pageInfo.total}条记录
                                </div>
                                <!-- 分页条 -->
                                <div class="col-md-6">
                                    <nav aria-label="Page navigation">
                                        <ul class="pagination">
                                            <li><a href="${pageContext.request.contextPath}/Entry/select?pn=1">首页</a></li>
                                            <c:if test="${pageInfo.hasPreviousPage }">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/Entry/select?pn=${pageInfo.pageNum-1}" aria-label="Previous">
                                                        <span aria-hidden="true">&laquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
                                                <c:if test="${page_Num == pageInfo.pageNum }">
                                                    <li class="active"><a href="#">${page_Num}</a></li>
                                                </c:if>
                                                <c:if test="${page_Num != pageInfo.pageNum }">
                                                    <li><a href="${pageContext.request.contextPath}/Entry/select?pn=${page_Num}">${page_Num}</a></li>
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${pageInfo.hasNextPage }">
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/Entry/select?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                                        <span aria-hidden="true">&raquo;</span>
                                                    </a>
                                                </li>
                                            </c:if>
                                            <li><a href="${pageContext.request.contextPath}/Entry/select?pn=${pageInfo.pages}">末页</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                    </td>
                </tr>
            </volist>
        </table>
    </div>
</form>
<script type="text/javascript">

    //搜索
    function changesearch() {
        var staffName = $("#staffName").val();
        console.log(staffName);
        location.href = "${pageContext.request.contextPath}/Entry/selectByName?staffName=" + staffName;
    }

</script>
</body>
</html>