<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <%-- 在IE运行最新的渲染模式 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">  <%-- 初始化移动浏览显示 --%>
    <meta name="Author" content="Dreamer-1.">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery2.js"></script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>管理员管理</title>
</head>
<body>

<h1>
    <div class="navbar-header">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><B>欢迎访问囚徒音乐后台管理系统</B></a>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/listAdmin">管理员管理</a>
    </div>
    <div id="box">
        <table class="table" width="600px">
            <thead>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
            </thead>
            <tr>
            </tr>
            <tbody id="QueryTable" style="margin:10px 0 10px 0;">
                <c:forEach items="${adminList}" var="admin">
                    <div>
                    <tr>
                        <th id="uid">${admin.id}</th>
                        <th>${admin.admin_name}</th>
                        <th>${admin.admin_password}</th>
                        <th>
                            <a href="${pageContext.request.contextPath}/admin/recordAdmin?id=${admin.id}&admin_name=${admin.admin_name}
                            &admin_password=${admin.admin_password}"><span class="glyphicon glyphicon-pencil"></span></a>
                        </th>
                        <th>
                            <a href="${pageContext.request.contextPath}/admin/delete?id=${admin.id}"><span class="glyphicon glyphicon-trash"></span></a>
                        </th>
                    </tr>
                    </div>
                </c:forEach>
            </tbody>
        </table>
    </div>
</h1>

<script>
    //搜索按钮点击事件
    function searchUser(){
        var str = $("#searchInput").value;
        if (str != ""){
            return true;
        }
        else
            return false;
    }
</script>
</body>
</html>
