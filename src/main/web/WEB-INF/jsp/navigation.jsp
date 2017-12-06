<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="navigation">
    <div id="navigation-width">
        <ul class="horizontal">
            <li><a href="<%=request.getContextPath()%>/admin/showAdviceBody">提案管理</a></li>
            <li><a href="<%=request.getContextPath()%>/user/showCommitteeBody">成员管理</a></li>
            <li><a href="<%=request.getContextPath()%>/user/showLeaderBody">领导管理</a></li>
            <li><a href="<%=request.getContextPath()%>/user/showDepartmentBody">部门管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showReplyBody">回复管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showMeetingBody">会议管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showNewsBody">通知管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showEventBody">新闻管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showOrganizationBody">组织管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showQuestionBody">须知管理</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/showRuleBody">规则管理</a></li>
            <li><a href="<%=request.getContextPath()%>/user/showTeamBody">队伍管理</a></li>
        </ul>
    </div>
</div>
</body>
</html>
