<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/uplodesong.css">
    <style type="text/css">
        .table {
            margin-top: 70px;
        }
    </style>
</head>
<body>
<div id="box">
    <div class="col-lg-3">
    </div><!-- /.col-lg-6 -->
    <table class="table ">
        <thead>
        <tr>
            <th>编号</th>
            <th>MV名</th>
            <th>作者</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="QueryTable">
        </tbody>
    </table>
    <div id="page">
        <a href="javaScript:void(0)" class="page">首页</a>
        <a href="javaScript:void(0)" class="page">上一页</a>
        <a href="javaScript:void(0)" class="page">下一页</a>
        <a href="javaScript:void(0)" class="page">尾页</a>
        <a href="javaScript:void(0)">共<span id="totalCounts"></span>条数据</a>
        <a href="javaScript:void(0)">共<span id="totalPages"></span>页</a>
    </div>
</div>
</body>
<script>
    $(function () {
        page(1);
        var correntPage;
        var TotalPages;
        function page(PageIndex) {
            $.ajax({
                type: "post",
                url: "Upload/SelectMv",
                dataType: "json",
                success: function (result) {
                    $("#QueryTable").empty();
                    if (result.success) {
                        var data = result.datas;
                        /*每页展示10条数据*/
                        $("#totalCounts").html(data.length)
                        TotalPages = Math.ceil(data.length/10)
                        var length=PageIndex * 10;
                        if(data.length<10){
                            length=data.length;
                        }
                        $("#totalPages").html(TotalPages)
                        for (var x = (PageIndex - 1) * 10; x < length; x++) {
                            var tr = "<tr>\n" +
                                "<td>" + (x+1) + "</td>\n" +
                                "<td>" + data[x].songname + "</td>\n" +
                                "<td>" + data[x].author + "</td>\n" +
                                "<td>\n" +
                                "<button id='upload_" + data[x].sid +"_"+data[x].mv_status+"'  class='btn btn-success btnUpload'>\n" +
                                "上传\n" +
                                "</button>\n" +
                                "</td>\n" +
                                "</tr>";
                            $("#QueryTable").append(tr);
                        }
                        correntPage = PageIndex;
                        btnUpload();
                    } else {
                        alert(result.msg);
                    }
                }
            })
        }

        $(function () {
            $(".page").click(function () {
                //这里需要进行区分
                var msg = $(this).text();
                if (msg == '首页') {
                    if (correntPage == 1) {
                        alert("当前就是首页")
                    } else {
                        correntPage = 1;
                    }
                } else if (msg == '上一页') {
                    if (correntPage == 1) {
                        alert("已经是首页")
                    } else {
                        correntPage = correntPage - 1;
                    }
                } else if (msg == '下一页') {
                    if (correntPage == TotalPages) {
                        alert("已经是最后一页")
                    } else {
                        correntPage = correntPage + 1;
                    }
                } else {
                    if (correntPage == TotalPages) {
                        alert("当前就是尾页")
                    } else {
                        correntPage = TotalPages;
                    }
                }
                page(correntPage);
            })
        })
        function btnUpload() {
            $(".btnUpload").click(function () {
                var sid=$(this).attr("id").split("_")[1];
                var mv_status=$(this).attr("id").split("_")[2];

                    //如果当前歌曲有mv资源，同时上传mv资源
                        var mv_url;
                        ajax1=$.ajax({
                            type: "post",
                            url: "https://autumnfish.cn/mv/url?id="+mv_status,
                            dataType: "json",
                            success: function (result) {
                                mv_url=result.data.url;
                            }
                        })
                        $.when(ajax1).done(function () {
                            $.ajax({
                                type: "post",
                                url: "Upload/Mv",
                                data:{
                                    mv_url:mv_url,
                                    sid:sid,
                                },
                                dataType: "json",
                                success: function (result) {
                                    if(result.success){
                                        alert("上传成功")
                                        /*初始化mv的播放量*/
                                        $.ajax({
                                            type: "post",
                                            url: "Upload/MvPlayNum",
                                            dataType: "json",
                                            data:{sid:sid},
                                            success:function (result) {

                                            }
                                        })
                                    }else{
                                        alert(result.msg)
                                    }
                                }
                             })
                        })

                })
            }
    })

</script>
</html>