<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 17-3-25
  Time: 下午1:19
  To change this template use File | Settings | File Templates.
--%>
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
            <li onclick="admin.showBody('adviceBody')">提案管理</li>
            <li onclick="admin.showBody('userBody')">成员管理</li>
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
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="adviceList" scope="request" type="java.util.List"/>
            <jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>
            <c:forEach var="advice" items="${adviceList}">
            <tr>
                <td>${advice.id}</td>
                <td><a href="/admin/${advice.id}/content">${advice.title}</a></td>
                <td>${advice.userId}</td>
                <td>
                    <c:choose>
                        <c:when test="${advice.state==0}">待审核</c:when>
                        <c:when test="${advice.state==-1}">审核未通过</c:when>
                        <c:when test="${advice.state==1}">审核通过</c:when>
                        <c:otherwise>未知状态</c:otherwise>
                    </c:choose>
                </td>
                <td>${sdf.format(advice.date)}</td>
                <td class="handler" onclick="admin.adviceHandler.deleteAdvice(${advice.id})">删除</td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
    <div id="user-body">
        <table>
            <thead>
            <tr>
                <th>职工号</th>
                <th>职工密码</th>
                <th>职工姓名</th>
                <th colspan="2">处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="userList" scope="request" type="java.util.List"/>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.userId}</td>
                    <td><input name="userPass" class="user-test" type="text" title="userPass" value="${user.userPass}"/>
                    </td>
                    <td><input name="userName" class="user-test" type="text" title="userName" value="${user.userName}"/>
                    </td>
                    <td class="handler" onclick="admin.userHandler.deleteUser(${user.userId})">删除</td>
                    <td class="handler" onclick="admin.userHandler.alterUser(${user.userId},
                            this.parentNode.cells[1].firstChild.value,
                            this.parentNode.cells[2].firstChild.value)">
                        修改
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input name="userId" class="user-test" type="text" title="userId"/></td>
                <td></td>
                <td></td>
                <td colspan="2" class="handler" onclick="admin.userHandler.addUser(this)">添加成员</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/manager.js"></script>

</body>
</html>
