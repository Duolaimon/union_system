<%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 17-3-24
  Time: 下午7:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>$Title$</title>
    <meta http-equiv="content-Type" content="text/html;charset=utf-8">
    <style type="text/css">
    *{
      margin: 0;
      padding: 0;
    }
    img{
      width: 100%;
      height: 100%;
      position: absolute;
      left: 0;
      top: 0;
      right: 0;
      bottom: 0;
      margin: auto;
    }
    .form{
      width: 260px;
      height: 120px;
      padding: 20px;
      border: solid 1px #000;
      position: absolute;
      left: 0;
      right: 0;
      top: 0;
      bottom: 0;
      margin: auto;
    }
    .form label{
      height: 40px;
      line-height: 40px;
    }
    .form label input{
      width: 174px;
      height: 24px;
      line-height: 24px;
      padding: 0 4px;
      outline: none;
    }
    .form label #adminPass{
      position: relative;
      left: 2px;
    }
    .form #subBtn{
      width: 60px;
      height: 30px;
      background: #74D8CB;
      border: solid 1px #4D958B;
      outline: none;
      color: #fff;
      margin: 10px 0 0 200px;
    }
    </style>
  

</head>
<body>
<img src="img/2014113017583752.jpg">
<form method="post" <%--action="<%=request.getContextPath()%>admin/index" --%>class="form"
    action="<%=request.getContextPath()%>/admin/index">
    <label>username:
    <input type="text" id="adminName" name="username">
</label><br/>
    <label>password:
    <input type="password" id="adminPass" name="password">
</label>
    <input type="submit" value="submit" name="Submit" id="subBtn" >
</form>
<hr/>
<%=request.getContextPath()%>
</body>
</html>
