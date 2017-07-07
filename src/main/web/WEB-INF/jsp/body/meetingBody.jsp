<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Meeting';
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
                <th>会议标题</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="meetingList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="meeting" items="${meetingList}">

                <tr>
                    <td><a href="<%=request.getContextPath()%>/admin/${meeting.meetingId}/meetingContent">${meeting.meetingTitle}</a></td>
                    <td>${sdf.format(meeting.meetingTime)}</td>
                    <td class="handler" onclick="admin.adminHandler.deleteAdvice(${meeting.meetingId},type)">删除</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" class="handler"><a href="http://118.89.243.99/db_union/ueditor/Demo2.html">新建会议资料</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>