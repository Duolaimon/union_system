<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员账户</title>
    <meta http-equiv="content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/manager.css">
</head>
<body>
<div id="admin-body">
    <div id="navigation">
        <ul class="horizontal">
            <li><a href="/admin/showAdviceBody">提案管理</a></li>
            <li><a href="/admin/showCommitteeBody">成员管理</a></li>
            <li><a href="/admin/showDepartmentBody">部门管理</a></li>
        </ul>
    </div>
    <div id="advice-body">
        <table>
            <thead>
            <tr>
                <th>提案id号</th>
                <th>提案标题</th>
                <th>提案教师职工号</th>
                <th>状态</th>
                <th>时间</th>
                <th>提案部门</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <%--<jsp:useBean id="adviceList" scope="request" type="java.util.List"/>--%>
            <%--<jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>--%>
            <c:forEach var="advice" items="${adviceList}">
            <tr>
                <td>${advice.adviceId}</td>
                <td><a href="/admin/${advice.adviceId}/content">${advice.title}</a></td>
                <td>${advice.userId}</td>
                <td>
                    <c:choose>
                        <c:when test="${advice.adviceState==0}">待审核</c:when>
                        <c:when test="${advice.adviceState==2}">审核未通过</c:when>
                        <c:when test="${advice.adviceState==1}">审核通过</c:when>
                        <c:otherwise>未知状态</c:otherwise>
                    </c:choose>
                </td>
                <td>${sdf.format(advice.adviceTime)}</td>
                <td>${advice.departmentId}</td>
                <td class="handler" onclick="admin.adviceHandler.deleteAdvice(${advice.adviceId})">删除</td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>

</div>
<script type="application/javascript"
        src="${pageContext.request.contextPath}/resources/js/manager.js"></script>

</body>
</html>