const admin = {
    URL: {
        deleteAdviceUrl: function (adviceId) {
            return "/admin/" + adviceId + "/deleteAdvice";
        },
        deleteUserUrl: function (userId) {
            return "/admin/" + userId + "/deleteUser"
        },
        alterUserUrl: function (userId) {
            return "/admin/" + userId + "/alterUser";
        },
        addUserUrl: function (userId) {
            return "/admin/" + userId + "/addUser";
        },
        showJspUrl: function (showName) {
            return "/admin/" + showName;
        }
    },
    adviceHandler: {
        deleteAdvice: function (adviceId) {
            var con = confirm("确定删除?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.deleteAdviceUrl(adviceId);
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                location.reload();
            }
        }
    },
    userHandler: {
        deleteUser: function (userId) {
            var con = confirm("确定删除?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.deleteUserUrl(userId);
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                location.reload();
            }
        },
        alterUser: function (userId, userPass, userName) {
            var con = confirm("确定保存?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.alterUserUrl(userId);
                xmlHttp.open("POST", url, true);
                xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                xmlHttp.send("userPass=" + userPass + "&userName=" + userName);
                // location.reload();
                // admin.showUserBody();
            }
        },
        addUser: function (node) {
            var xmlHttp = admin.ajaxFunc();
            var userId = node.parentNode.cells[0].firstChild.value;
            if (userId.length !== 7) {
                alert("职工号位数为7位!");
                return;
            }
            var url = admin.URL.addUserUrl(userId);
            xmlHttp.open("GET", url, true);
            xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp.send();
            location.reload();
        }
    },
    showBody: function (bodyName) {
        var url = admin.URL.showJspUrl(bodyName);
        var xmlHttp = admin.ajaxFunc();
        xmlHttp.open("GET", url, true);
        xmlHttp.send();
    },
    ajaxFunc: function () {
        var xmlHttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlHttp = new XMLHttpRequest();
        }
        else {// code for IE6, IE5
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        return xmlHttp;
    }

};