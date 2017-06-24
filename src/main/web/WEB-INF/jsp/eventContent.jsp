<jsp:useBean id="event" scope="request" type="org.duol.union.entity.Event"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="contentList" scope="request" type="java.util.List"/>
<jsp:useBean id="sdf" scope="request" type="java.text.SimpleDateFormat"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${event.eventTitle}</title>
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
<h2 class="title">${event.eventTitle}</h2>
<h4 class="author">${sdf.format(event.eventTime)}</h4>
<div id="committee-body">
    <%@include file="navigation.jsp"%>
    <div class="adviceContent">
        <c:forEach var="content" items="${contentList}">
            ${content}<br/>
        </c:forEach>

    </div>
</div>
</body>
</html>
