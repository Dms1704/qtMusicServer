<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">  <%-- 在IE运行最新的渲染模式 --%>
    <meta name="viewport" content="width=device-width, initial-scale=1">  <%-- 初始化移动浏览显示 --%>
    <meta name="Author" content="Dreamer-1.">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/jquery2.js"></script>
    <script src="layer/layer.js"></script>
    <script type="text/javascript" src="js/vue.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <title>- 后台管理系统 -</title>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">欢迎访问QQ音乐后台管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="" onclick="showAtRight('adminList.jsp')"><i class="fa fa-users"></i> 管理员管理</a></li>
                <li><a href="" onclick="showAtRight('categoryList.jsp')"><i class="fa fa-users"></i> 分类管理</a></li>
                <li><a href="" onclick="showAtRight('discussList.jsp')"><i class="fa fa-users"></i> 评论管理</a></li>
                <li><a href="" onclick="showAtRight('userList.jsp')"><i class="fa fa-users"></i> 用户管理</a></li>
                <li><a href="###" onclick="showAtRight('UplodeSong.jsp')"><i class="fa fa-list-alt"></i> 上传资源</a></li>
                <li><a href="" onclick="showAtRight('DeleteSong.jsp')"><i class="fa fa-list-alt"></i> 歌曲管理</a></li>
                <li><a href="" onclick="showAtRight('Mv.jsp')" ><i class="fa fa-list"></i>Mv管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row-fluie">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar list-group">

                <li class="active"><a href="#categoryMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-user"></i>&nbsp; 分类管理 <span class="sr-only">(current)</span></a>
                </li>
                <ul id="categoryMeun" class="nav nav-list collapse menu-second">
                    <li><a href="${pageContext.request.contextPath}/category/listCategory?currentPage=1"><i class="fa fa-users"></i> 分类列表</a></li>
                </ul>

                <li class="active"><a href="#adminMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-user"></i>&nbsp; 管理员管理 <span class="sr-only">(current)</span></a>
                </li>

                <ul id="adminMeun" class="nav nav-list collapse menu-second">
                    <li><a href="${pageContext.request.contextPath}/admin/listAdmin"><i class="fa fa-users"></i> 管理员列表</a></li>
                </ul>

                <li class="active"><a href="#userMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-user"></i>&nbsp; 用户管理 <span class="sr-only">(current)</span></a>
                </li>
                <ul id="userMeun" class="nav nav-list collapse menu-second">
                    <li><a href="user/listUser?currentPage=1"><i class="fa fa-users"></i> 用户列表</a></li>
                </ul>

                <li><a href="#productMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-globe"></i>&nbsp; 上传 <span class="sr-only">(current)</span></a>
                </li>
                <ul id="productMeun" class="nav nav-list collapse menu-second">
                    <li><a href="###" onclick="showAtRight('UplodeSong.jsp')"><i class="fa fa-list-alt"></i> 上传歌曲</a></li>
                    <li><a href="###" onclick="showAtRight('UploadMv.jsp')"><i class="fa fa-list-alt"></i> 上传MV</a></li>
                </ul>

                <li class="active"><a href="#discussMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-user"></i>&nbsp; 评论管理 <span class="sr-only">(current)</span></a>
                </li>
                <ul id="discussMeun" class="nav nav-list collapse menu-second">
                    <li><a href="${pageContext.request.contextPath}/discuss/listDiscuss?currentPage=1"><i class="fa fa-users"></i> 评论列表</a></li>
                </ul>

                <li><a href="#recordMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                    <i class="fa fa-globe"></i>&nbsp; 歌曲管理 <span class="sr-only">(current)</span></a>
                </li>
                <ul id="recordMeun" class="nav nav-list collapse menu-second">
                    <li><a href="###" onclick="showAtRight('DeleteSong.jsp')" ><i class="fa fa-list"></i> 下架歌曲</a></li>
                </ul>
            </ul>
        </div>
    </div>
</div>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    <h1 class="page-header"><i class="fa fa-cog fa-spin"></i>&nbsp;控制台<small>&nbsp;&nbsp;&nbsp;欢迎使用XXX后台管理系统</small></h1>
    <div id="content">
<%--        <h4>
            <strong>查询页面</strong><br>
            <br><br>默认页面内容……
        </h4>--%>
    </div>
</div>
<script type="text/javascript">

    $(document).ready(function () {
        $('ul.nav > li').click(function (e) {
            $('ul.nav > li').removeClass('active');
            $(this).addClass('active');
        });
    });
    function executeScript(html)
    {
        var reg = /<script[^>]*>([^\x00]+)$/i;
        var htmlBlock = html.split("<\/script>");
        for (var i in htmlBlock)
        {
            var blocks;
            if (blocks = htmlBlock[i].match(reg))
            {
                var code = blocks[1].replace(/<!--/, '');
                try
                {
                    eval(code)
                }
                catch (e)
                {
                }
            }
        }
    }
    function showAtRight(url) {
        var xmlHttp;
        if (window.XMLHttpRequest) {
            xmlHttp=new XMLHttpRequest();
        }
        else {
            // code for IE6, IE5
            xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlHttp.onreadystatechange=function() {

            if (xmlHttp.readyState == 4) {

                if (xmlHttp.status == 200) {

                    document.getElementById("content").innerHTML=xmlHttp.responseText;
                    executeScript(xmlHttp.responseText);
                }
                else if (xmlHttp.status == 404){
                    alert("出错了☹  （错误代码：404 Not Found），……！");
                    /* 对404的处理 */
                    return;
                }
                else if (xmlHttp.status == 403) {
                    alert("出错了☹  （错误代码：403 Forbidden），……");
                    /* 对403的处理 */
                    return;
                }
                else {
                    alert("出错了☹  （错误代码：" + request.status + "），……");
                    /* 对出现了其他错误代码所示错误的处理  */
                    return;
                }
            }
        }
        //把请求发送到服务器上的指定文件（url指向的文件）进行处理
        xmlHttp.open("GET", url, true);    //true表示异步处理
        xmlHttp.send();
    }
    function ToUpdate() {
        /*一分钟更新一次数据库的数据*/
        Update();
        window.setTimeout("ToUpdate()",120000)
    }
    ToUpdate();
    function Update() {
        /*更新歌曲数据*/
        $.ajax({
            type: "post",
            url: "Update/SelectSong",
            dataType: "json",
            success: function (result) {
                var data=result.data;
                var arr=[];
                $(data).each(function (index,ele) {
                    var song_url;
                    var sid=ele.sid;
                    ajax1=$.ajax({
                        type: "post",
                        url: "https://autumnfish.cn/song/url?id="+sid,
                        dataType: "json",
                        success: function (result) {
                            song_url=result.data[0].url;
                            var elem=sid+"_"+song_url
                            arr.push(elem)
                        }
                    })
                })
                $.when(ajax1).done(function () {
                    $.ajax({
                        type: "post",
                        url: "Update/InsertSong",
                        traditional:true, //默认false
                        data: {
                            arr:arr
                        },
                        success: function (result) {
                        }
                    })
                })
            }
        })
        /*更新mv数据*/
        $.ajax({
            type: "post",
            url: "Update/SelectMv",
            dataType: "json",
            success: function (result) {
                var data = result.data;
                var arr1 = [];
                $(data).each(function (index, ele) {
                    var sid = ele.sid;
                    var mid = ele.mv_status
                    var mv_url;
                    ajax3 = $.ajax({
                        type: "post",
                        url: "https://autumnfish.cn/mv/url?id=" + mid,
                        dataType: "json",
                        success: function (result) {
                            mv_url = result.data.url;
                            var elem = sid + "_" + mv_url;
                            arr1.push(elem)
                        }
                    })
                })
                $.when(ajax3).done(function () {
                    $.ajax({
                        type: "post",
                        url: "Update/InsertMv",
                        traditional: true, //默认false
                        data: {
                            arr: arr1
                        },
                        success: function (result) {
                        }
                    })
                })
            }
        })
    }
</script>
</body>
</html>