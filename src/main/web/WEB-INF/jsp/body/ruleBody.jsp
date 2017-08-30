<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Rule';
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
                <th>提案需知</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="ruleList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="rule" items="${ruleList}">

                <tr>
                    <td><a href="<%=request.getContextPath()%>/admin/${rule.ruleId}/ruleContent">${rule.ruleName}</a></td>
                    <td>${sdf.format(rule.ruleTime)}</td>
                    <td class="handler" onclick="admin.adminHandler.deleteAdvice(${rule.ruleId},type)">删除</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" class="handler"><a href="http://<%=ip%>/db_union/ueditor/Demo4.html">添加规章制度</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>