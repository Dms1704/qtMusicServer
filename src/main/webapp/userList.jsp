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
    <title>用户管理</title>
</head>
<body>
<h1>
    <div class="navbar-header">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp"><B>欢迎访问囚徒音乐后台管理系统</B></a>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/user/listUser?currentPage=1">用户管理</a>
    </div>
    <div id="box">
        <div class="col-lg-3">
            <div class="input-group">
                <form method="post" action="${pageContext.request.contextPath}/user/search?currentPage=1">
                    <div class="input-group">
                        <input type="text" name="unameStr" class="form-control"  placeholder="输入用户名">
                        <span class="input-group-btn">
                            <input class="btn btn-primary" type="submit" onclick="return searchUser()">搜索</input>
                        </span>
                    </div>
                </form>
            </div><!-- /input-group -->
            <br>
        </div><!-- /.col-lg-6 -->
        <table class="table" width="600px">
            <thead>
            <tr>
                <th>编号</th>
                <th>用户名</th>
                <th>密码</th>
                <th>地址</th>
                <th>性别</th>
                <th>修改</th>
                <th>删除</th>
            </tr>
            </thead>
            <tr>
            </tr>
            <tbody id="QueryTable" style="margin:10px 0 10px 0;">
                <c:forEach items="${userPageBean.list}" var="user">
                    <div>
                    <tr>
                        <th id="uid">${user.uid}</th>
                        <th>${user.username}</th>
                        <th>${user.password}</th>
                        <th>${user.address}</th>
                        <th>${user.sex}</th>
                        <th>
                            <a href="${pageContext.request.contextPath}/user/recordUser?uid=${user.uid}&username=${user.username}
                            &password=${user.password}&address=${user.address}&sex=${user.sex}"><span class="glyphicon glyphicon-pencil"></span></a>
                        </th>
                        <th>
                            <a href="${pageContext.request.contextPath}/user/delete?uid=${user.uid}"><span class="glyphicon glyphicon-trash"></span></a>
                        </th>
                    </tr>
                    </div>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <c:if test="${isQuery == false}">
            <div id="page">
                <a href="${pageContext.request.contextPath}/user/listUser?currentPage=1" class="page">首页</a>
                <a href="${pageContext.request.contextPath}/user/listUser?currentPage=${userPageBean.currentPage-1}" class="page">上一页</a>
                <a href="${pageContext.request.contextPath}/user/listUser?currentPage=${userPageBean.currentPage+1}" class="page">下一页</a>
                <a href="${pageContext.request.contextPath}/user/listUser?currentPage=${userPageBean.totalPage}" class="page">尾页</a>
                <a  href="javaScript:void(0)">共<span id="totalCounts1">${userPageBean.totalCount}</span>条数据</a>
            </div>
        </c:if>
        <c:if test="${isQuery == true}">
            <div id="page">
                <a href="${pageContext.request.contextPath}/user/search?currentPage=1&unameStr=${queryStr}" class="page">首页</a>
                <a href="${pageContext.request.contextPath}/user/search?currentPage=${userPageBean.currentPage-1}&unameStr=${queryStr}" class="page">上一页</a>
                <a href="${pageContext.request.contextPath}/user/search?currentPage=${userPageBean.currentPage+1}&unameStr=${queryStr}" class="page">下一页</a>
                <a href="${pageContext.request.contextPath}/user/search?currentPage=${userPageBean.totalPage}&unameStr=${queryStr}" class="page">尾页</a>
                <a  href="javaScript:void(0)">共<span id="totalCounts2">${userPageBean.totalCount}</span>条数据</a>
            </div>
        </c:if>

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
