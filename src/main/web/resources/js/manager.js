const admin = {
    /*访问后台restUrl*/
    URL: {
        deleteAdviceUrl: function (adviceId) {
            return "/admin/" + adviceId + "/deleteAdvice";
        },
        deleteCommitteeUrl: function (committeeId) {
            return "/admin/" + committeeId + "/deleteCommittee"
        },
        alterCommitteeUrl: function (committeeId) {
            return "/admin/" + committeeId + "/alterCommittee";
        },
        addCommitteeUrl: function (committeeId) {
            return "/admin/" + committeeId + "/addCommittee";
        },
        deleteDepartmentUrl: function (departmentId) {
            return "/admin/" + departmentId + "/deleteDepartment";
        },
        addDepartmentUrl: function (departmentId) {
            return "/admin/" + departmentId + "/addDepartment";
        },
        showJspUrl: function (showName) {
            return "/admin/" + showName;
        }
    },
    /*对提案的处理*/
    adviceHandler: {
        /**
         * 删除一条提案
         * @param adviceId
         */
        deleteAdvice: function (adviceId) {
            var con = confirm("确定删除?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.deleteAdviceUrl(adviceId);
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                admin.sleep(300);
                location.reload();
            }
        }
    },
    /*对委员的处理*/
    committeeHandler: {
        /**
         * 删除一个指定id的委员信息
         * @param committeeId
         */
        deleteCommittee: function (committeeId) {
            var con = confirm("确定删除?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.deleteCommitteeUrl(committeeId);
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                admin.sleep(300);
                location.reload();
            }
        },
        /**
         * 修改委员信息
         * @param committeeId
         * @param committeePass
         * @param committeeName
         */
        alterCommittee: function (committeeId, committeePass, committeeName) {
            var con = confirm("确定保存?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.alterCommitteeUrl(committeeId);
                xmlHttp.open("POST", url, true);
                xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                xmlHttp.send("committeePass=" + committeePass + "&committeeName=" + committeeName);
                // location.reload();
            }
        },
        /**
         * 添加一个新委员
         * @param node
         */
        addCommittee: function (node) {
            var xmlHttp = admin.ajaxFunc();
            var committeeId = node.parentNode.cells[0].firstChild.value;
            if (committeeId.length !== 5) {
                alert("职工号位数为5位!");
                return;
            }
            var url = admin.URL.addCommitteeUrl(committeeId);
            xmlHttp.open("GET", url, true);
            xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp.send();
            admin.sleep(300);
            location.reload();
        }
    },
    /*对部门的处理*/
    departmentHandler: {
        /**
         * 删除一个指定id的部门
         * @param departmentId
         */
        deleteDepartment: function (departmentId) {
            var con = confirm("确定删除?");
            if (con) {
                var xmlHttp = admin.ajaxFunc();
                var url = admin.URL.deleteDepartmentUrl(departmentId);
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                admin.sleep(300);
                location.reload();
            }
        },
        /**
         * 增加一个部门信息
         * @param departmentId
         * @param departmentPassword
         * @param departmentName
         */
        addDepartment: function (departmentId,departmentPassword,departmentName) {
            var xmlHttp = admin.ajaxFunc();
            if (departmentId.length !== 5) {
                alert("部门号位数为5位!");
                return;
            }
            if (departmentName === ""){
                alert("部门名不能为空！");
                return;
            }
            var url = admin.URL.addDepartmentUrl(departmentId);
            xmlHttp.open("POST", url, true);
            xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            xmlHttp.send("departmentPassword="+departmentPassword+"&departmentName="+departmentName);
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
        for(var t = Date.now();Date.now() - t <= d;){}
    }

};