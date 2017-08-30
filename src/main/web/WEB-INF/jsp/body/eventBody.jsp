<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Event';
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
                <th>新闻标题</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="eventList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="event" items="${eventList}">

            <tr>
                <td><a href="<%=request.getContextPath()%>/admin/${event.eventId}/eventContent">${event.eventTitle}</a></td>
                <td>${sdf.format(event.eventTime)}</td>
                <td class="handler" onclick="admin.adminHandler.deleteAdvice(${event.eventId},type)">删除</td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="3" class="handler"><a href="http://<%=ip%>/db_union/ueditor/Demo.html">新建新闻</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
