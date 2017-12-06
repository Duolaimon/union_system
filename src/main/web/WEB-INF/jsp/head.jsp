<%--
  Created by IntelliJ IDEA.
  User: deity
  Date: 17-6-23
  Time: 下午5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String ip = "118.89.216.40";
%>
<html>
<head>
    <title>管理员账户</title>
    <meta http-equiv="content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/manager.css">
    <script>
        var contextPath = "<%=request.getContextPath()%>";
        const admin = {
            /* 访问后台非标准rest url */
            URL: {
                deleteAdminUrl: function (Id, type) {
                    return contextPath + "/admin/" + Id + "/delete" + type;
                },
                deleteUserUrl: function (userId, type) {
                    return contextPath + "/user/" + userId + "/delete" + type;
                },
                alterUserUrl: function (userId, type) {
                    return contextPath + "/user/" + userId + "/alter" + type;
                },
                addUserUrl: function (userId, type) {
                    return contextPath + "/user/" + userId + "/add" + type;
                },
                addDepartmentUrl: function (departmentId) {
                    return contextPath + "/user/" + departmentId + "/addDepartment";
                },
                addEvent: function (type) {
                    return contextPath + "/admin/add" + type;
                }
            },
            /*对内容展示相关的处理*/
            adminHandler: {
                /**
                 * 删除一条提案
                 * @param adviceId
                 * @param type
                 */
                deleteAdvice: function (adviceId, type) {
                    var con = confirm("确定删除?");
                    if (con) {
                        var xmlHttp = admin.ajaxFunc();
                        var url = admin.URL.deleteAdminUrl(adviceId, type);
                        xmlHttp.open("GET", url, true);
                        xmlHttp.send();
                        admin.sleep(300);
                        location.reload();
                    }
                },
                /**
                 * 新加内容
                 * @param type  指定类型
                 */
                addContext: function (type) {
                    var title = prompt("请输入标题");
                    if (title !== null && title !== "") {
                        var content = prompt("请输入内容");
                        if (content !== null && content !== "") {
                            var xmlHttp = admin.ajaxFunc();
                            var url = admin.URL.addEvent(type);
                            xmlHttp.open("POST", url, true);
                            xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                            xmlHttp.send("title=" + title + "&content=" + content);
                            location.reload();
                        }
                    }

                }
            },
            /*对成员的处理*/
            userHandler: {
                /**
                 * 删除一个指定id的成员信息
                 * @param userId
                 * @param type  成员类型
                 */
                deleteUser: function (userId, type) {
                    var con = confirm("确定删除?");
                    if (con) {
                        var xmlHttp = admin.ajaxFunc();
                        var url = admin.URL.deleteUserUrl(userId, type);
                        xmlHttp.open("GET", url, true);
                        xmlHttp.send();
                        admin.sleep(300);
                        location.reload();
                    }
                },
                /**
                 * 修改成员信息
                 * @param userId
                 * @param userPass
                 * @param userName
                 * @param type  成员类型
                 * @param teamId
                 */
                alterUser: function (userId, userPass, userName, type, teamId) {
                    var con = confirm("确定保存?");
                    if (con) {
                        var xmlHttp = admin.ajaxFunc();
                        var url = admin.URL.alterUserUrl(userId, type);
                        xmlHttp.open("POST", url, true);
                        var lowerType = type.toLowerCase();
                        xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                        var data = lowerType + "Pass=" + userPass + "&" + lowerType + "Name=" + userName;
                        if (teamId !== '') {
                            data = data + "&teamId=" + teamId;
                        }
                        xmlHttp.send(data);
                        // location.reload();
                    }
                },
                /**
                 * 添加一个新成员
                 * @param node
                 * @param type  成员类型
                 */
                addUser: function (node, type) {
                    var xmlHttp = admin.ajaxFunc();
                    var userId = node.parentNode.cells[0].firstChild.value;
                    var userPass = node.parentNode.cells[1].firstChild.value;
                    var userName = node.parentNode.cells[2].firstChild.value;
                    var teamId = node.parentNode.cells[3].firstChild.value;
                    var url = admin.URL.addUserUrl(userId, type);
                    xmlHttp.open("POST", url, true);
                    xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                    var lowerType = type.toLowerCase();
                    var data = lowerType + "Pass=" + userPass + "&" + lowerType + "Name=" + userName;
                    if (teamId !== '') {
                        data = data + "&teamId=" + teamId;
                    }
                    xmlHttp.send(data);
                    admin.sleep(300);
                    location.reload();
                }
            },
            /*对部门的处理*/
            departmentHandler: {
                /**
                 * 增加一个部门信息
                 * @param departmentId
                 * @param departmentPassword
                 * @param departmentName
                 */
                addDepartment: function (departmentId, departmentPassword, departmentName) {
                    var xmlHttp = admin.ajaxFunc();
                    var url = admin.URL.addDepartmentUrl(departmentId);
                    xmlHttp.open("POST", url, true);
                    xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                    xmlHttp.send("departmentPassword=" + departmentPassword + "&departmentName=" + departmentName);
                    admin.sleep(300);
                    location.reload();
                }
            },
            /**
             * 返回一个ajax对象
             * @returns {*}
             */
            ajaxFunc: function () {
                var xmlHttp;
                if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlHttp = new XMLHttpRequest();
                }
                else {// code for IE6, IE5
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                return xmlHttp;
            },
            /**
             * 暂停 d毫秒
             * @param d 毫秒
             */
            sleep: function (d) {
                for (var t = Date.now(); Date.now() - t <= d;) {
                }
            }

        };
    </script>
</head>
</html>
