<jsp:useBean id="reply" scope="request" type="org.duol.union.entity.Reply"/>
<jsp:useBean id="advice" scope="request" type="org.duol.union.entity.Advice"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    </style>
</head>
<body>
<h2 class="title">回复${advice.title}</h2>
<h4 class="author">${sdf.format(reply.replyTime)}</h4>
<div id="committee-body">
    <%@include file="../navigation.jsp"%>
    <div class="adviceContent">
        <c:forEach var="content" items="${contentList}">
            ${content}<br/>
        </c:forEach>

    </div>
</div>
</body>
</html>
