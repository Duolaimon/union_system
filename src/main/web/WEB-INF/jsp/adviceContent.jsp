<jsp:useBean id="advice" scope="request" type="org.duol.union.entity.Advice"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="userName" scope="request" type="java.lang.String"/>
<jsp:useBean id="contentList" scope="request" type="java.util.List"/>
<jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${advice.title}</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/manager.css">
    <style type="text/css">
        body {
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-size: 14px;
            line-height: 20px;
            color: #333;
        }

        .title {
            text-align: center;
        }

        .author {
            text-align: right;
        }

        .content {
            margin: 0 auto;
            width: 80%;
            word-wrap: break-word;
            word-break: normal;
            font-size: 20px;
            font-family: 微软雅黑, serif;
        }

    </style>
</head>
<body>
<h2 class="title">${advice.title}</h2>
<h4 class="author">${userName}---${sdf.format(advice.date)}</h4>
<div id="user-body">
    <div id="navigation">
        <ul class="horizontal">
            <li><a href="/admin/showAdviceBody">提案管理</a></li>
            <li><a href="/admin/showUserBody">成员管理</a></li>
        </ul>
    </div>
    <div class="content">
        <c:forEach var="content" items="${contentList}">
            <p>${content}</p>
        </c:forEach>

    </div>
</div>
</body>
</html>
