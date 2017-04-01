<%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 17-3-24
  Time: 下午7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <meta http-equiv="content-Type" content="text/html;charset=utf-8">

</head>
<body>
<form method="post" action="${pageContext.request.contextPath}admin/index">
    username:<label>
    <input type="text" name="username">
</label><br/>
    password:<label>
    <input type="password" name="password">
</label>
    <input type="submit" value="submit" name="Submit">
</form>
</body>
</html>
