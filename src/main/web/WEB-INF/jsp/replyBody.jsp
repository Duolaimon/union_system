<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Reply';
        }
    </script>
</head>
<body>
<div id="admin-body">
    <%@include file="navigation.jsp"%>
    <div id="advice-body">
        <table>
            <thead>
            <tr>
                <th>回复id号</th>
                <th>提案id号</th>
                <th>回复部门</th>
                <th>状态</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="replyList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="reply" items="${replyList}">

                <tr>
                    <td><a href="/admin/${reply.replyId}/replyContent">${reply.replyId}</a></td>
                    <td><a href="/admin/${reply.adviceId}/adviceContent">${reply.adviceId}</a></td>
                    <td>${reply.departmentId}</td>
                    <td>
                        <%--<c:choose>
                            <c:when test="${reply.replyState==0}">待审核</c:when>
                            <c:when test="${reply.replyState==2}">审核未通过</c:when>
                            <c:when test="${reply.replyState==1}">审核通过</c:when>
                            <c:otherwise>未知状态</c:otherwise>
                        </c:choose>--%>
                        ${reply.replyState}
                    </td>
                    <td>${sdf.format(reply.replyTime)}</td>
                    <td class="handler" onclick="admin.adminHandler.deleteAdvice(${reply.replyId},type)">删除</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
<script type="application/javascript"
        src="${pageContext.request.contextPath}/resources/js/manager.js"></script>

</body>
</html>