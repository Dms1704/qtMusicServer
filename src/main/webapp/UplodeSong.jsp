<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/uplodesong.css">
</head>
<body>
<div id="box">
    <div class="col-lg-3">
        <div class="input-group">
            <input type="text" class="form-control"  placeholder="输入歌手名或歌曲名">
            <span class="input-group-btn">
        <button class="btn btn-primary" type="button" >搜索</button>
      </span>
        </div><!-- /input-group -->
    </div><!-- /.col-lg-6 -->
    <table class="table ">
        <thead>
        <tr>
            <th>编号</th>
            <th>歌曲</th>
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
           $.ajax({
               type: "post",
               url: "https://autumnfish.cn/personalized/newsong",
               dataType: "json",
               success: function (result) {
                   var data = result.result;
                   $("#QueryTable").empty();
                   $("#totalCounts").html(data.length)
                   TotalPages = Math.ceil(data.length/10)
                   $("#totalPages").html(TotalPages);
                   /*每页展示10条数据*/
                   var i = 1,PageIndex=1;
                   for (var x = (PageIndex - 1) * 10; x < PageIndex * 10; x++) {
                       var tr = "<tr>\n" +
                           "<td>" + (i++) + "</td>\n" +
                           "<td>" + data[x].name + "</td>\n" +
                           "<td>" + data[x].song.artists[0].name + "</td>\n" +
                           "<td>\n" +
                           "<button id='upload_" + data[x].id + "_" + data[x].name + "_" + data[x].song.artists[0].name + "_" + data[x].song.mvid + "' class='btn btn-success btnUpload'>\n" +
                           "上传\n" +
                           "</button>\n" +
                           "</td>\n" +
                           "</tr>";
                       $("#QueryTable").append(tr);
                   }
                   btnUpload();
               }
           })
       /*点击搜索*/
       $(".btn-primary").click(function () {
           var msg=$(".form-control").val()
           page(1)
           var correntPage;
           var TotalPages;
           function page(PageIndex) {
               $.ajax({
                   type: "post",
                   url: "https://autumnfish.cn/search?keywords=" + msg,
                   dataType: "json",
                   success: function (result) {
                       $("#QueryTable").empty();
                       var data = result.result.songs;
                       $("#totalCounts").html(data.length)
                       TotalPages = Math.ceil(data.length/10)
                       $("#totalPages").html(TotalPages);
                       for (var x = (PageIndex - 1) * 10; x < PageIndex * 10; x++) {
                           var tr = "<tr>\n" +
                               "<td>" + (x+1) + "</td>\n" +
                               "<td>" + data[x].name + "</td>\n" +
                               "<td>" + data[x].artists[0].name + "</td>\n" +
                               "<td>\n" +
                               "<button id='upload_" +data[x].id +"_"+data[x].name+"_"+data[x].artists[0].name+"_"+data[x].mvid+"' class='btn btn-success btnUpload'>\n" +
                               "上传\n" +
                               "</button>\n" +
                               "</td>\n" +
                               "</tr>";
                           $("#QueryTable").append(tr);
                       }
                       correntPage=PageIndex;
                       btnUpload();
                   }
               })
           }
           $(function () {
               $(".page").click(function () {
                   //这里需要进行区分
                   var msg= $(this).text();
                   if(msg=='首页'){
                       if(correntPage==1){
                           alert("当前就是首页")
                       }else{
                           correntPage=1;
                       }
                   }else if(msg=='上一页'){
                       if(correntPage==1){
                           alert("已经是首页")
                       }else{
                           correntPage=correntPage-1;
                       }
                   }else if(msg=='下一页'){
                       if(correntPage==TotalPages ){
                           alert("已经是最后一页")
                       }else{
                           correntPage=correntPage+1;
                       }
                   }else{
                       if(correntPage==TotalPages ){
                           alert("当前就是尾页")
                       }else{
                           correntPage=TotalPages ;
                       }
                   }
                   page(correntPage);
               })
           })

       })

       //上传
       function btnUpload() {
         $(".btnUpload").click(function () {
           var sid=$(this).attr("id").split("_")[1];
           var songname=$(this).attr("id").split("_")[2];
           var author=$(this).attr("id").split("_")[3];
           var mv_status=$(this).attr("id").split("_")[4];
           var song_url;
           var img;
           var mv_status=mv_status;
             //需要通过id发送ajax查询到改歌的其他信息
           /*播放地址*/
             ajax1=$.ajax({
               type: "post",
               url: "https://autumnfish.cn/song/url?id="+sid,
               dataType: "json",
               success: function (result) {
                   song_url=result.data[0].url;
               }
           })
           /*图片*/
           ajax2=$.ajax({
               type: "post",
               url: "https://autumnfish.cn/song/detail?ids="+sid,
               dataType: "json",
               success: function (result) {
                   img=result.songs[0].al.picUrl;
               }
           })
             $.when(ajax1&&ajax2).done(function () {
                 //上传歌曲资源
                 $.ajax({
                     type: "post",
                     url: "Upload/Upload",
                     data:{
                         sid:sid,
                         songname:songname,
                         author:author,
                         url:song_url,
                         img:img,
                         mv_status:mv_status
                     },
                     dataType: "json",
                     success: function (result) {
                         if(result.success){
                             alert("上传成功")
                             //歌曲播放量初始化
                             $.ajax({
                                 type: "post",
                                 url: "Upload/SongPlayNum",
                                 data:{
                                     sid:sid,
                                 },
                                 dataType: "json",
                             })
                         }else{
                             alert(result.msg)
                         }
                     }
                 })

             });
         })
       }
   })


</script>
</html>