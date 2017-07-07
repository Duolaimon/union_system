<jsp:useBean id="advice" scope="request" type="org.duol.union.entity.Advice"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="committeeName" scope="request" type="java.lang.String"/>
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
<h2 class="title">${advice.title}</h2>
<h4 class="author">${committeeName}---${sdf.format(advice.adviceTime)}</h4>
<div id="committee-body">
    <%@include file="../navigation.jsp"%>
    <h3>内容：</h3>
    <div class="adviceContent">
        <c:forEach var="adviceContent" items="${contentList}">
            ${adviceContent}<br/>
        </c:forEach>
    </div>
    <br/>
    <br/>
    <h2 style="padding-top:40px;clear: none">建议措施:</h2>
    <div class="adviceContent">
        ${advice.adviceDo}
    </div>
</div>
</body>
</html>
