<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <div id="navigation">
    <ul class="horizontal">
        <li><a href="<c:url value="//localhost:8080/admin/showAdviceBody"/>">提案管理</a></li>
        <li><a href="<c:url value="//localhost:8080/user/showCommitteeBody"/>">成员管理</a></li>
        <li><a href="<c:url value="//localhost:8080/user/showDepartmentBody"/>">部门管理</a></li>
        <li><a href="<c:url value="//localhost:8080/user/showLeaderBody"/>">领导管理</a></li>
        <li><a href="<c:url value="//localhost:8080/admin/showMeetingBody"/>">会议管理</a></li>
        <li><a href="<c:url value="//localhost:8080/admin/showNewsBody"/>">新闻管理</a></li>
        <li><a href="<c:url value="//localhost:8080/admin/showReplyBody"/>">回复管理</a></li>
        <li><a href="<c:url value="//localhost:8080/admin/showEventBody"/>">通知管理</a></li>
    </ul>
</div>
</body>
</html>
