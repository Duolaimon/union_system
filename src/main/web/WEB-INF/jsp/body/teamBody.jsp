<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <%@include file="../head.jsp"%>
    <script>
        var type;
        window.onload=function () {
            type = 'Team';
        }
    </script>
</head>
<body>
<div id="admin-body">
    <%@include file="../navigation.jsp"%>
    <div id="committee-body">
        <table>
            <thead>
            <tr>
                <th>队伍号</th>
                <th>队伍密码</th>
                <th>队伍名</th>
                <th colspan="2">处理</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="teamList" scope="request" type="java.util.List"/>
            <c:forEach var="team" items="${teamList}">
                <tr>
                    <td>${team.teamId}</td>
                    <td><input name="userPass" class="committee-test" type="text" title="userPass" value="${team.teamPass}"/>
                    </td>
                    <td><input name="userName" class="committee-test" type="text" title="userName" value="${team.teamName}"/>
                    </td>
                    <td class="handler" onclick="admin.userHandler.deleteUser('${team.teamId}',type)">删除</td>
                    <td class="handler" onclick="admin.userHandler.alterUser('${team.teamId}',
                            this.parentNode.cells[1].firstChild.value,
                            this.parentNode.cells[2].firstChild.value,type)">
                        修改
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td><input class="committee-test" type="text" title="committeeId"/></td>
                <td><input class="committee-test" type="text" title="committeePass"/></td>
                <td><input class="committee-test" type="text" title="committeeName"/></td>
                <td colspan="2" class="handler" onclick="admin.userHandler.addUser(this,type)">添加成员</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>