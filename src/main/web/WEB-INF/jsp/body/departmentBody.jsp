<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
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
    <%@include file="../head.jsp" %>
    <script>
        var type;
        window.onload = function () {
            type = 'Department';
        }
    </script>
</head>
<body>
<div id="admin-body">
    <%@include file="../navigation.jsp" %>
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
                    <td><input name="departmentPass" class="department-test" type="text" title="departmentPassword"
                               value="${department.departmentPassword}"/>
                    </td>
                    <td><input name="departmentName" class="department-test" type="text" title="departmentName"
                               value="${department.departmentName}"/>
                    </td>
                    <td class="handler" onclick="admin.userHandler.deleteUser(${department.departmentId},type)">
                        删除
                    </td>

                </tr>
            </c:forEach>
            <tr>
                <td><input name="departmentId" class="department-test" type="text" title="departmentId"/></td>
                <td><input name="departmentPassword" class="department-test" type="text" title="departmentPassword"/>
                </td>
                <td><input name="departmentName" class="department-test" type="text" title="departmentName"/></td>
                <td class="handler" onclick="admin.departmentHandler.addDepartment(this.parentNode.cells[0].firstChild.value,
                        this.parentNode.cells[1].firstChild.value,
                        this.parentNode.cells[2].firstChild.value)">添加成员
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
