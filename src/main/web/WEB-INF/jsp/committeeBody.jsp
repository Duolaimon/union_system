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
    <div id="committee-body">
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
            <%--<jsp:useBean id="committeeList" scope="request" type="java.util.List"/>--%>
            <c:forEach var="committee" items="${committeeList}">
                <tr>
                    <td>${committee.committeeId}</td>
                    <td><input name="userPass" class="committee-test" type="text" title="userPass" value="${committee.committeePass}"/>
                    </td>
                    <td><input name="userName" class="committee-test" type="text" title="userName" value="${committee.committeeName}"/>
                    </td>
                    <td class="handler" onclick="admin.committeeHandler.deleteCommittee(${committee.committeeId})">删除</td>
                    <td class="handler" onclick="admin.committeeHandler.alterCommittee(${committee.committeeId},
                            this.parentNode.cells[1].firstChild.value,
                            this.parentNode.cells[2].firstChild.value)">
                        修改
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input name="committeeId" class="committee-test" type="text" title="committeeId"/></td>
                <td></td>
                <td></td>
                <td colspan="2" class="handler" onclick="admin.committeeHandler.addCommittee(this)">添加成员</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script type="application/javascript"
        src="${pageContext.request.contextPath}/resources/js/manager.js"></script>

</body>
</html>