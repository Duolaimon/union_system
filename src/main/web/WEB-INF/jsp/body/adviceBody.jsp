<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Advice';
        }
    </script>
</head>
<body>
<div id="admin-body">
    <%@include file="../navigation.jsp"%>
    <div id="advice-body">
        <table>
            <thead>
            <tr>
                <th>提案id号</th>
                <th>提案标题</th>
                <th>职工号</th>
                <th>状态</th>
                <th>点赞数</th>
                <th>点赞人</th>
                <th>提案人</th>
                <th>联系方式</th>
                <th>时间</th>
                <th>提案人部门</th>
                <th>被提案部门</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="adviceList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="advice" items="${adviceList}">
            <tr>
                <td>${advice.adviceId}</td>
                <td><a href="<%=request.getContextPath()%>/admin/${advice.adviceId}/adviceContent">${advice.title}</a></td>
                <td>${advice.userId}</td>
                <td>
                    <%--<c:choose>
                        <c:when test="${event.adviceState==0}">待审核</c:when>
                        <c:when test="${event.adviceState==2}">审核未通过</c:when>
                        <c:when test="${event.adviceState==1}">审核通过</c:when>
                        <c:otherwise>未知状态</c:otherwise>
                    </c:choose>--%>
                    ${advice.adviceState}
                </td>
                <td>${advice.count}</td>
                <td>${advice.adviceAgree}</td>
                <td>${advice.adviceName}</td>
                <td>${advice.contactway}</td>
                <td>${sdf.format(advice.adviceTime)}</td>
                <td>${advice.adviceWorkspace}</td>
                <td>${advice.departmentId}</td>
                <td class="handler" onclick="admin.adminHandler.deleteAdvice(${advice.adviceId},type)">删除</td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>

</div>

</body>
</html>