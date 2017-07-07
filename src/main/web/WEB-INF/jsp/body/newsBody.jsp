<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'News';
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
                <th>通知标题</th>
                <th>时间</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="newsList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="news" items="${newsList}">

                <tr>
                    <td><a href="<%=request.getContextPath()%>/admin/${news.newsId}/newsContent">${news.newsTitle}</a></td>
                    <td>${sdf.format(news.newsTime)}</td>
                    <td class="handler" onclick="admin.adminHandler.deleteAdvice(${news.newsId},type)">删除</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" class="handler"><a href="http://118.89.243.99/db_union/ueditor/Demo1.html">新建通知公告</a></td>
            </tr>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>