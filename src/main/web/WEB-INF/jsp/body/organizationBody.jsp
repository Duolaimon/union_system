<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Organization';
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
                <th>组织机构</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="organizationList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="organization" items="${organizationList}">

                <tr>
                    <td><a href="<%=request.getContextPath()%>/admin/${organization.organizationId}/organizationContent">${organization.eorganizationName}</a></td>
                    <td>${sdf.format(organization.organizationTime)}</td>
                    <td class="handler" onclick="admin.adminHandler.deleteAdvice(${organization.organizationId},type)">删除</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" class="handler"><a href="http://<%=ip%>/db_union/ueditor/Demo3.html">添加组织机构</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>