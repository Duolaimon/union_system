<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 17-4-16
  Time: 下午1:52
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
            <li><a href="/admin/showAdviceBody">提案管理</a></li>
            <li><a href="/admin/showCommitteeBody">成员管理</a></li>
            <li><a href="/admin/showDepartmentBody">部门管理</a></li>
        </ul>
    </div>
    <div id="department-body">
        <table>
            <thead>
            <tr>
                <th>部门号</th>
                <th>部门密码</th>
                <th>部门名</th>
                <th>处理</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="department" items="${departmentList}">
                <tr>
                    <td>${department.departmentId}</td>
                    <td><input name="departmentPass" class="department-test" type="text" title="departmentPassword" value="${department.departmentPassword}"/>
                    </td>
                    <td><input name="departmentName" class="department-test" type="text" title="departmentName" value="${department.departmentName}"/>
                    </td>
                    <td class="handler" onclick="admin.departmentHandler.deleteDepartment(${department.departmentId})">删除</td>

                </tr>
            </c:forEach>
            <tr>
                <td><input name="departmentId" class="department-test" type="text" title="departmentId"/></td>
                <td><input name="departmentPassword" class="department-test" type="text" title="departmentPassword"/></td>
                <td><input name="departmentName" class="department-test" type="text" title="departmentName"/></td>
                <td class="handler" onclick="admin.departmentHandler.addDepartment(this.parentNode.cells[0].firstChild.value,
                        this.parentNode.cells[1].firstChild.value,
                        this.parentNode.cells[2].firstChild.value)">添加成员</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<script type="application/javascript"
        src="${pageContext.request.contextPath}/resources/js/manager.js"></script>

</body>
</html>
